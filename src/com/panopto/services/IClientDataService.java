/**
 * IClientDataService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.panopto.services;

public interface IClientDataService extends java.rmi.Remote {
    public com.panopto.services.SystemInfo getSystemInfo() throws java.rmi.RemoteException;
    public com.panopto.services.CourseInfo provisionCourse(com.panopto.services.CourseProvisioningInfo provisioningInfo, java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
    public com.panopto.services.CourseInfo[] provisionCourses(com.panopto.services.CourseProvisioningInfo[] provisioningInfo, java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
    public java.lang.String createCourse(java.lang.String shortName, java.lang.String longName, java.lang.String externalCourseID, java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
    public void addUsersToCourse(java.lang.String coursePublicID, com.panopto.services.AccessLevel role, java.lang.String[] userKeys, java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
    public void setContactInfo(java.lang.String contactUserKey, java.lang.String firstName, java.lang.String lastName, java.lang.String email, java.lang.Boolean mailLectureNotifications, java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
    public com.panopto.services.CourseInfo[] getCourses(java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
    public com.panopto.services.CourseInfo getCourse(java.lang.String coursePublicID, java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
    public com.panopto.services.SessionInfo[] getLiveSessions(java.lang.String coursePublicID, java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
    public com.panopto.services.DeliveryInfo[] getCompletedDeliveries(java.lang.String coursePublicID, java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
    public java.lang.String getCourseSessionListUrl(java.lang.String coursePublicID, java.lang.String apiUserKey, java.lang.String authCode) throws java.rmi.RemoteException;
}
