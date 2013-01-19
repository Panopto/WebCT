package com.panopto;

import java.util.HashMap;
import java.util.Hashtable;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import com.webct.platform.sdk.proxytool.common.ProcessCallback;
import com.webct.platform.sdk.security.authentication.module.AuthenticationModule;
import com.webct.platform.sdk.security.authentication.module.WebCTSSOContext;

@SuppressWarnings("rawtypes")
public class PanoptoAuthModule extends AuthenticationModule 
{
	private static final String userIdUrlParameterKey = "userid";
	
	public PanoptoAuthModule()
	{
		super();
	}
	
	public PanoptoAuthModule(Hashtable componentHash)
	{
		super(componentHash);
	}
	
	public boolean login() throws LoginException
	{
		// We don't have any special logic for logging in
		return true;
	}
	
	public boolean commit() throws LoginException
	{
		// get the SSO context object
		WebCTSSOContext ssoContext = super.getWebCTSSOContext();

		if (ssoContext.getCurrentMode().equals(INCOMING_MODE))
		{
			IncomingConfigAssist(ssoContext);
		}	
		else if (ssoContext.getCurrentMode().equals(OUTGOING_MODE))
		{
			String guid = ssoContext.getGUID();
			
			if (guid != null)
			{
				OutgoingConfigAssist(ssoContext, guid);
			}
			else
			{
				OutgoingProxy(ssoContext);
			}
		}
		
		return true;
	}
	
	/**
	 * Handles the case when a user has just added the tool to a section and we are doing assisted config.
	 * Attempts to provision the course in Panopto. If successful sends the course's url to incoming auth. If not successful displays an error message
	 */
	private void OutgoingConfigAssist(WebCTSSOContext ssoContext, String guid) throws LoginException
	{
		String user = ssoContext.getUserId();
		String url = ssoContext.getSSOUrl(super.getSettingsGroupName(), null);
		
		try 
		{
			url = PanoptoTools.AddParameterToUrl(url, ProcessCallback.PROXY_TOOL_CALLBACK_GUID, guid);
			url = PanoptoTools.AddParameterToUrl(url, userIdUrlParameterKey, user);
			
			//Provision the course
			PanoptoTools panoptoTools = new PanoptoTools(ssoContext.getSettings(), ssoContext.getUserId());
			String panoptoCourseId = panoptoTools.ProvisionCourse();
			String panoptoCourseUrl = panoptoTools.GetCourseSessionListUrl(panoptoCourseId);

			// Success!
			url = PanoptoTools.AddParameterToUrl(url, PanoptoTools.panoptoCourseUrlSettingKey, panoptoCourseUrl);
			url = PanoptoTools.AddParameterToUrl(url, PanoptoTools.panoptoCourseIdSettingKey, panoptoCourseId);
			this.setRedirectUrl(url);
		} 
		catch (PanoptoFatalException e) 
		{
			String output = "<html><body>Fatal exception while provisioning course in Panopto:<br>";
			output += "  " + e.getMessage() + "<br><br>";
			if (e.getInnerException() != null)
			{
				output += "Inner Exception:<br>";
				output += "  " + e.getInnerException().getMessage() + "<br>";
			}
			output += "</body></html>";
			setResponseContent(output);
		} 
		catch (PanoptoException e) 
		{
			String output = "<html><body>Exception while provisioning course in Panopto:<br>";
			output += "  " + e.getMessage() + "<br><br>";
			if (e.getInnerException() != null)
			{
				output += "Inner Exception:<br>";
				output += "  " + e.getInnerException().getMessage() + "<br>";
			}
			output += "</body></html>";
			setResponseContent(output);
		}
	}
	
	/**
	 * Handles the second half of assisted config when a user has added the tool to a section
	 * PRECONDITION: OutgoingConfigAssist has been called and a course was successfully provisioned in Panopto
	 * Saves the courses URL into WebCT's settings 
	 */
	@SuppressWarnings("unchecked")
	private void IncomingConfigAssist(WebCTSSOContext ssoContext) throws LoginException
	{
		HttpServletRequest request = ssoContext.getRequest();
		
		// get the GUID and user
		String guid = request.getParameter(ProcessCallback.PROXY_TOOL_CALLBACK_GUID);
		String user = request.getParameter(userIdUrlParameterKey);
		String panoptoCourseUrl = request.getParameter(PanoptoTools.panoptoCourseUrlSettingKey);
		String panoptoCourseId = request.getParameter(PanoptoTools.panoptoCourseIdSettingKey);

		if (user == null || guid == null)
		{
			throw new LoginException("Must supply both guid and userid for incoming authentication");
		}
		else if (panoptoCourseUrl == null || panoptoCourseId == null)
		{
			throw new LoginException("Must supply a panoptoCourseID and panoptoCourseUrl for incoming config assist");
		}
		super.setUserId(user);
		
		// build config value map
		HashMap config = new HashMap();
		config.put(PanoptoTools.panoptoCourseUrlSettingKey, panoptoCourseUrl);
		config.put(PanoptoTools.panoptoCourseIdSettingKey, panoptoCourseId);
		super.setProxyToolConfiguredValues(guid, config);
	}
	
	/**
	 * Handles the case when a user clicks on the tool in the context of a section.
	 * Redirects the user to the course's list page in Panopto 
	 */
	private void OutgoingProxy(WebCTSSOContext ssoContext) throws LoginException
	{
		try
		{
			PanoptoTools panoptoTools = new PanoptoTools(ssoContext.getSettings(), ssoContext.getUserId());
			panoptoTools.EnsureCurrentUserIsInCourse();
			this.setRedirectUrl(panoptoTools.MakePanoptoOutgoingSsoUrl());
		}
		catch(PanoptoException e)
		{
			if (e.getInnerException() == null)
			{
				throw new LoginException("Outgoing proxy failed, recieved a PanoptoException: " + e.getMessage());
			}
			else
			{
				throw new LoginException("Outgoing proxy failed, recieved a PanoptoException: " + e.getMessage() + " InnerException: " + e.getInnerException().getMessage());
			}
		
		}
		catch(PanoptoFatalException e)
		{
			if (e.getInnerException() == null)
			{
				throw new LoginException("Outgoing proxy failed, recieved a PanoptoFatalException: " + e.getMessage());
			}
			else
			{
				throw new LoginException("Outgoing proxy failed, recieved a PanoptoFatalException: " + e.getMessage() + " InnerException: " + e.getInnerException().getMessage());
			}
		}
	}
}
