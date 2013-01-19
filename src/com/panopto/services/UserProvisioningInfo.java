/**
 * UserProvisioningInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.panopto.services;

public class UserProvisioningInfo  implements java.io.Serializable {
    private java.lang.String email;

    private java.lang.String firstName;

    private java.lang.String lastName;

    private java.lang.Boolean mailLectureNotifications;

    private java.lang.String userKey;

    public UserProvisioningInfo() {
    }

    public UserProvisioningInfo(
           java.lang.String email,
           java.lang.String firstName,
           java.lang.String lastName,
           java.lang.Boolean mailLectureNotifications,
           java.lang.String userKey) {
           this.email = email;
           this.firstName = firstName;
           this.lastName = lastName;
           this.mailLectureNotifications = mailLectureNotifications;
           this.userKey = userKey;
    }


    /**
     * Gets the email value for this UserProvisioningInfo.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this UserProvisioningInfo.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the firstName value for this UserProvisioningInfo.
     * 
     * @return firstName
     */
    public java.lang.String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this UserProvisioningInfo.
     * 
     * @param firstName
     */
    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the lastName value for this UserProvisioningInfo.
     * 
     * @return lastName
     */
    public java.lang.String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this UserProvisioningInfo.
     * 
     * @param lastName
     */
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the mailLectureNotifications value for this UserProvisioningInfo.
     * 
     * @return mailLectureNotifications
     */
    public java.lang.Boolean getMailLectureNotifications() {
        return mailLectureNotifications;
    }


    /**
     * Sets the mailLectureNotifications value for this UserProvisioningInfo.
     * 
     * @param mailLectureNotifications
     */
    public void setMailLectureNotifications(java.lang.Boolean mailLectureNotifications) {
        this.mailLectureNotifications = mailLectureNotifications;
    }


    /**
     * Gets the userKey value for this UserProvisioningInfo.
     * 
     * @return userKey
     */
    public java.lang.String getUserKey() {
        return userKey;
    }


    /**
     * Sets the userKey value for this UserProvisioningInfo.
     * 
     * @param userKey
     */
    public void setUserKey(java.lang.String userKey) {
        this.userKey = userKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserProvisioningInfo)) return false;
        UserProvisioningInfo other = (UserProvisioningInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.firstName==null && other.getFirstName()==null) || 
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.lastName==null && other.getLastName()==null) || 
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            ((this.mailLectureNotifications==null && other.getMailLectureNotifications()==null) || 
             (this.mailLectureNotifications!=null &&
              this.mailLectureNotifications.equals(other.getMailLectureNotifications()))) &&
            ((this.userKey==null && other.getUserKey()==null) || 
             (this.userKey!=null &&
              this.userKey.equals(other.getUserKey())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        if (getMailLectureNotifications() != null) {
            _hashCode += getMailLectureNotifications().hashCode();
        }
        if (getUserKey() != null) {
            _hashCode += getUserKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserProvisioningInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.panopto.com", "UserProvisioningInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "FirstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "LastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailLectureNotifications");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "MailLectureNotifications"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "UserKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
