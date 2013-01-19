package com.panopto;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.oscelot.webct.dao.LearningContextService;
import org.oscelot.webct.dao.LearningContextVO;
import org.oscelot.webct.dao.UserService;
import org.oscelot.webct.dao.UserVO;
import org.oscelot.webct.dao.VistaDataException;

import com.panopto.services.AccessLevel;
import com.panopto.services.ClientData;
import com.panopto.services.ClientDataLocator;
import com.panopto.services.CourseInfo;
import com.panopto.services.CourseProvisioningInfo;
import com.panopto.services.IClientDataService;
import com.panopto.services.UserProvisioningInfo;
import com.webct.platform.sdk.context.client.ContextSDK;
import com.webct.platform.sdk.context.gen.ContextException;
import com.webct.platform.sdk.context.gen.SessionVO;

/**
 * Contains methods that abstract the details of working against the Panopto web services
 */
/**
 * @author kschmidt
 *
 */
@SuppressWarnings("rawtypes")
public class PanoptoTools 
{
	private String instanceName;
	private String serverName;
	private String applicationKey;
	private String userId;
	private String courseUrl;
	private String panoptoCourseId;
	
	private static final String serverNameSettingKey = "PanoptoServerName";
	private static final String instanceNameSettingKey = "WebCTInstanceName";
	private static final String applicationKeySettingKey = "PanoptoApplicationKey";
	public static final String panoptoCourseUrlSettingKey = "PanoptoCourseUrl";
	public static final String panoptoCourseIdSettingKey = "PanoptoCourseId";
	
	
	/**
	 * Creates a new PanoptoTools
	 * @param webctSettings	The settings from WebCT.
	 * @param userId		The userId of the current WebCT user
	 * @throws PanoptoFatalException
	 */
	public PanoptoTools(Map webctSettings, String userId) throws PanoptoFatalException
	{
		instanceName = (String)webctSettings.get(instanceNameSettingKey);
		serverName = (String)webctSettings.get(serverNameSettingKey);
		applicationKey = (String)webctSettings.get(applicationKeySettingKey);
		this.userId = userId;
		courseUrl = (String)webctSettings.get(panoptoCourseUrlSettingKey);
		panoptoCourseId = (String)webctSettings.get(panoptoCourseIdSettingKey);
	}
	
	/**
	 * Appends a parameter to the end of the url. Takes care of encoding the parameter name and value and handles if the url already has parameters
	 * @param url				the url to add the parameter to
	 * @param parameterName		the name of the parameter
	 * @param parameterValue	the value of the parameter
	 * @return					the url with the added parameter
	 * @throws PanoptoFatalException
	 */
	public static String AddParameterToUrl(String url, String parameterName, String parameterValue) throws PanoptoFatalException
	{
		try 
		{
			char seperator = url.contains("?") ? '&' : '?';
			return url + seperator + URLEncoder.encode(parameterName, "utf-8") + "=" + URLEncoder.encode(parameterValue, "utf-8"); 
		}
		catch (UnsupportedEncodingException e) 
		{
			throw new PanoptoFatalException("URLEncoder.encode(, \"utf-8\") threw an exception. This probably indicates a bug", e);
		}
	}
	
	/**
	 * Calls the Panopto web service to get the url for the list page of a course
	 * @param courseId	The panopto courseId of the course
	 * @return			The url for the list page of the course
	 * @throws PanoptoException
	 * @throws PanoptoFatalException
	 */
	public String GetCourseSessionListUrl(String courseId) throws PanoptoException, PanoptoFatalException
	{
		IClientDataService port = GetClientDataService();
		try 
		{
			String retVal = port.getCourseSessionListUrl(courseId, GetUserKey(userId), GetWebServiceUserAuthCode());
			if (retVal == null)
			{
				throw new PanoptoException("Unable to get the course URL for " + courseId);
			}
			return retVal;
		}
		catch (RemoteException e) 
		{
			throw new PanoptoException("Recieved an exception when provisioning the course in Panopto. This could indicate that the panopto server is down, or one of the WebCT settings is wrong", e);
		}
	}
	
	/**
	 * Calls the Panopto web service to provision or re-provision a course. 
	 * PRECONDITION: the current webct context must be the section that you wish to provision
	 * @return	The panopto ID of the provisioned course
	 * @throws PanoptoFatalException
	 * @throws PanoptoException
	 */
	public String ProvisionCourse() throws PanoptoFatalException, PanoptoException
	{
		long courseId = GetCurrentCourseId();
		LearningContextVO courseContext = GetLearningContext(courseId);
		
		List<UserProvisioningInfo> instructors = new ArrayList<UserProvisioningInfo>();
		List<UserProvisioningInfo> students = new ArrayList<UserProvisioningInfo>();
		GetInstructorsAndStudentsOfCourse(courseId, instructors, students);
		
		CourseProvisioningInfo courseInfo = new CourseProvisioningInfo();
		courseInfo.setExternalCourseID(instanceName + ":" + courseId);
		courseInfo.setLongName(courseContext.getName());

		UserProvisioningInfo empty[] = new UserProvisioningInfo[0];
		courseInfo.setInstructors(instructors.toArray(empty));
		courseInfo.setStudents(students.toArray(empty));
		
		return ProvisionCourse(courseInfo);
	}

	/**
	 * Creates the full URL (including authentication information) to open the list page for the current course in Panopto 
	 * @return The URL to open the list page for the current course in Panopto (including SSO Auth stuff)
	 * @throws PanoptoFatalException
	 */
	public String MakePanoptoOutgoingSsoUrl() throws PanoptoFatalException
	{
		String expirationTime = GetExpirationTime();
		String authPayload = String.format("serverName=%s&externalUserKey=%s&expiration=%s|%s",
				new Object[]{ serverName, GetUserKey(userId), expirationTime, applicationKey } );
		String authCode = GetSha1Hash(authPayload);
		
		String retVal = "http://" + serverName + "/panopto/pages/auth/login.aspx";
		retVal = AddParameterToUrl(retVal, "ReturnUrl", courseUrl);
		retVal = AddParameterToUrl(retVal, "serverName", serverName);
		retVal = AddParameterToUrl(retVal, "externalUserKey", GetUserKey(userId));
		retVal = AddParameterToUrl(retVal, "expiration", expirationTime);
		retVal = AddParameterToUrl(retVal, "authCode", authCode);
		
		return retVal;
	}
	
	/**
	 * Ensures that the current user has been provisioned in the Panopto course the corresponds to the current context 
	 */
	public void EnsureCurrentUserIsInCourse() throws PanoptoException, PanoptoFatalException
	{
		IClientDataService port = GetClientDataService();
		
		AccessLevel role = IsUserInstructor(GetCurrentUser()) ? AccessLevel.Creator : AccessLevel.Viewer;
		
		try 
		{
			port.addUsersToCourse(panoptoCourseId, role, new String[]{ GetUserKey(userId) }, GetUserKey(userId), GetWebServiceUserAuthCode());
		}
		catch (RemoteException e) 
		{
			throw new PanoptoException("Recieved an exception while ensuring the user is in Panopto. This could indicate that the panopto server is down, or one of the WebCT settings is wrong", e);
		}
	}
	
	/**
	 * Constructs the key to use for authentication of the user 
	 */
	private String GetUserKey(String userId)
	{
		return instanceName + "\\" + userId;
	}
	
	/**
	 * Constructs the auth code for the current user to call a Panopto web service
	 */
	private String GetWebServiceUserAuthCode() throws PanoptoFatalException
	{
		String payload = GetUserKey(userId) + "@" + serverName;
		
		return GetWebServiceAuthCode(payload);
	}

	/**
	 * Converts a payload into a signed auth code to call a Panopto web service 
	 */
	private String GetWebServiceAuthCode(String payload) throws PanoptoFatalException
	{
		String signedPayload = payload + "|" + applicationKey;
		return GetSha1Hash(signedPayload);
	}
	
	/**
	 * Gets the Sha1 hash for a given payload 
	 */
	private static String GetSha1Hash(String payload) throws PanoptoFatalException
	{
		MessageDigest sha1 = null;
		try 
		{
			sha1 = MessageDigest.getInstance("SHA-1");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			throw new PanoptoFatalException("java.security.MessageDigest threw a NoSuchAlgorithmException on SHA-1", e);
		}
		try 
		{
			sha1.update(payload.getBytes("UTF-8"));
		} 
		catch (UnsupportedEncodingException e)
		{
			throw new PanoptoFatalException("String.getBytes threw an UnsupportedEncodingException on UTF-8", e);
		}
		byte raw[] = sha1.digest();
		String authCode = ByteArrayToHexString(raw);
		return authCode.toUpperCase();
	}
	
	/**
	 * Converts a byte array to a string of hex. Ex: {5, 12} -> "050C" 
	 */
	private static String ByteArrayToHexString(byte in[])
	{
		// Each byte will turn into two characters, so allocate a long enough buffer.
		StringBuffer retVal = new StringBuffer(in.length * 2);
		for (int i = 0; i < in.length; i++)
		{
			// Java doesn't support negative numbers, so we need to bit-mask away all the other bits
			int intValue = 0x000000FF & ((int)in[i]);
			if (intValue < 16)
			{
				// We want to make sure that every byte turns into two characters, even if it is less than 16
				retVal.append('0');
			}
			retVal.append(Integer.toHexString(intValue));
		}
		return retVal.toString().toUpperCase();
	}
	
	/**
	 * Gets information about the current user
	 */
	private UserVO GetCurrentUser() throws PanoptoFatalException, PanoptoException
	{
		UserService userService = UserService.getInstance();
		long sectionId = GetCurrentSectionId();
		
		try
		{
			return userService.getUser(userId, sectionId);
		}
		catch (VistaDataException e)
		{
			throw new PanoptoException("Unable to get information about user " + userId, e);
		}
	}
	
	/**
	 * Gets all the members of a WebCT section. This includes instructors, students, designers, etc
	 * @throws PanoptoException 
	 */
	@SuppressWarnings("unchecked")
	private static List<UserVO> GetSectionMembers(long lcid) throws PanoptoException
	{
		try 
		{
			UserService userService = UserService.getInstance();
			return (List<UserVO>)userService.getMembers(new Long(lcid));
		} 
		catch (VistaDataException e) 
		{
			throw new PanoptoException("Unable to get the members of section " + lcid);
		}
	}
	
	/**
	 * Gets all the members of all the sections of a course
	 * @param courseId - the lcid of the course
	 * @return - a list of all the members of all the sections of the course
	 * @throws PanoptoException
	 * @throws PanoptoFatalException
	 */
	private static List<UserVO> GetCourseMembers(long courseId) throws PanoptoException, PanoptoFatalException
	{
		long[] sectionIds;
		try
		{
			ContextSDK contextSdk = new ContextSDK();
			SessionVO session = contextSdk.getCurrentSession();
			sectionIds = contextSdk.getChildren(session, courseId);
		}
		catch (ContextException e)
		{
			throw new PanoptoException("Unable to get the list of sections assocaited with the course", e);
		}
		catch (RemoteException e) 
		{
			throw new PanoptoFatalException("We got a RemoteException when calling local methods. This should not be possible.", e);
		}
		
		List<UserVO> retVal = new ArrayList<UserVO>();
		for (int i = 0; i < sectionIds.length; i++)
		{
			retVal.addAll(GetSectionMembers(sectionIds[i]));
		}
		return retVal;
	}
	
	/**
	 * Gets the URL to make soap calls into Panopto
	 */
	private URL GetSoapUrl() throws PanoptoException
	{
		try 
		{
			return new URL("http://" + serverName + "/Panopto/Services/ClientData.svc");
		} 
		catch (MalformedURLException e) 
		{
			throw new PanoptoException("Unable to construct the Url of the panopto server. This means the " + serverNameSettingKey + " setting is invalid. Contact your WebCT admin to correct it", e);
		}
	}
	
	/**
	 * Determines if a user should be considered an instructor by Panopto (should have create rights)
	 */
	private static boolean IsUserInstructor(UserVO user)
	{
		//Auditor, DemoUser, Mentor, and Student don't have instructor access
		//DesignerInstructor is deprecated, so it will default to not instructor if it appears
		return user.isCourseDesigner()
				|| user.isCourseInstructor()
				|| user.isDivisionAdmin()
				|| user.isDivisionDesigner()
				|| user.isDomainAdmin()
				|| user.isDomainDesigner()
				|| user.isGroupAdmin()
				|| user.isGroupDesigner()
				|| user.isInstitutionalAdmin()
				|| user.isInstitutionalDesigner()
				|| user.isPrimarySectionInstructor()
				|| user.isSectionDesigner()
				|| user.isSectionInstructor()
				|| user.isServerAdmin()
				|| user.isTA();
	}
	
	/**
	 * Gets all the instructors and students for all the sections of a course
	 * @param lcid 				The id of the section
	 * @param out_instructors	OUT: a list of instructors
	 * @param out_students		OUT: a list of students
	 * @throws PanoptoFatalException
	 * @throws PanoptoException 
	 */
	private void GetInstructorsAndStudentsOfCourse(long courseId, List<UserProvisioningInfo> out_instructors, List<UserProvisioningInfo> out_students) throws PanoptoFatalException, PanoptoException
	{
		if (out_instructors == null || out_students == null)
		{
			throw new PanoptoFatalException("You must pass valid instructors and students lists into GetInstructorsAndStudentsOfCourse");
		}
		
		// First get all the members of the section
		List<UserVO> members = GetCourseMembers(courseId);
		
		// Now sort them as instructors or students
		for (int i = 0; i < members.size(); i++)
		{
			UserVO user = members.get(i);
			boolean isInstructor = IsUserInstructor(user);
			
			UserProvisioningInfo userInfo = new UserProvisioningInfo();
			userInfo.setUserKey(GetUserKey(user.getUserId()));
			if (isInstructor)
			{
				userInfo.setFirstName(user.getFirstname());
				userInfo.setLastName(user.getLastname());
				userInfo.setEmail(user.getEmail());
				userInfo.setMailLectureNotifications(Boolean.TRUE);
				out_instructors.add(userInfo);
			}
			else
			{
				out_students.add(userInfo);
			}
		}
	}
	
	/**
	 * Creates an IClientDataService for use in connecting to Panopto
	 * @throws PanoptoException
	 */
	private IClientDataService GetClientDataService() throws PanoptoException
	{
		URL soapUrl = GetSoapUrl();

		// The two following lines are necessary since there are multiple implementations of the xml parsers
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
		System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
		ClientData service = new ClientDataLocator();
		try 
		{
			return service.getBasicHttpBinding_IClientDataService(soapUrl);
		}
		catch (ServiceException e) 
		{
			throw new PanoptoException("Recieved an exception while trying to connect to the Panopto server. This could indicate that it is down, or that one of the WebCT settings is wrong", e);
		}
	}
	
	/**
	 * Given a CourseProvisioningInfo makes a call to the Panopto web service to provision the course
	 */
	private String ProvisionCourse(CourseProvisioningInfo courseInfo) throws PanoptoException, PanoptoFatalException
	{
		IClientDataService port = GetClientDataService();
		try 
		{
			CourseInfo course = port.provisionCourse(courseInfo, GetUserKey(userId), GetWebServiceUserAuthCode());
			if (course == null)
			{
				throw new PanoptoException("Panopto failed to provision the course, but didn't report an error. This typically means that authentication failed. Check the application key and server name settings.");
			}
			return course.getPublicID();
		}
		catch (RemoteException e) 
		{
			throw new PanoptoException("Recieved an exception when provisioning the course in Panopto. This could indicate that the panopto server is down, or one of the WebCT settings is wrong", e);
		}
	}
	
	/**
	 * Gets the LCID of the current section
	 * @throws PanoptoFatalException 
	 */
	private static long GetCurrentSectionId() throws PanoptoFatalException
	{
		try
		{
			ContextSDK context = new ContextSDK();
			SessionVO session = context.getCurrentSession();
			return session.getCurrentLCID();
		}
		catch (RemoteException e) 
		{
			throw new PanoptoFatalException("We got a RemoteException when calling local methods. This should not be possible.", e);
		}
	}
	
	/**
	 * Gets the LCID of the current course
	 * PRECONDITION: the current context is assumed to be a section of the course
	 * @throws PanoptoFatalException 
	 */
	private static long GetCurrentCourseId() throws PanoptoFatalException
	{
		try
		{
			ContextSDK context = new ContextSDK();
			SessionVO session = context.getCurrentSession();
			long sectionId = session.getCurrentLCID();
			return context.getParent(session, sectionId);
		}
		catch (RemoteException e) 
		{
			throw new PanoptoFatalException("We got a RemoteException when calling local methods. This should not be possible.", e);
		}
	}
	
	/**
	 * Gets information about a given learning context 
	 */
	private LearningContextVO GetLearningContext(long lcid) throws PanoptoFatalException
	{
		try
		{
			LearningContextService contextService = LearningContextService.getInstance();
			return contextService.getLCInfo(lcid);
		}
		catch(VistaDataException e)
		{
			throw new PanoptoFatalException("We got a VistaDataException when calling local methods. This should not be possible.", e);
		}
	}
	
	/**
	 * Gets the expiration time as it will be passed to panopto for SSO.
	 * Formatted in seconds since the Windows file time epoch (12:00 AM on 1/1/1601 UTC)
	 */
	private static String GetExpirationTime()
	{
		long currentTimeInMillisecondsSinceJavaEpoch = new Date().getTime();
		double currentTimeInSecondsSinceJavaEpoch = currentTimeInMillisecondsSinceJavaEpoch / 1000;
		long secondsBetweenWindowsEpochAndJavaEpoch = 11644473600L;
		double currentTimeInSecondsSinceWindowsEpoch = currentTimeInSecondsSinceJavaEpoch + secondsBetweenWindowsEpochAndJavaEpoch;

		// The experation time will be 5 minutes from current 
		double expirationTime = currentTimeInSecondsSinceWindowsEpoch + (5 * 60);
		java.text.DecimalFormat formatter = new java.text.DecimalFormat("#0");
		return formatter.format(expirationTime);
	}
}
