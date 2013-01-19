/**
 * CourseProvisioningInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.panopto.services;

public class CourseProvisioningInfo  implements java.io.Serializable {
    private java.lang.String externalCourseID;

    private com.panopto.services.UserProvisioningInfo[] instructors;

    private java.lang.String longName;

    private java.lang.String shortName;

    private com.panopto.services.UserProvisioningInfo[] students;

    public CourseProvisioningInfo() {
    }

    public CourseProvisioningInfo(
           java.lang.String externalCourseID,
           com.panopto.services.UserProvisioningInfo[] instructors,
           java.lang.String longName,
           java.lang.String shortName,
           com.panopto.services.UserProvisioningInfo[] students) {
           this.externalCourseID = externalCourseID;
           this.instructors = instructors;
           this.longName = longName;
           this.shortName = shortName;
           this.students = students;
    }


    /**
     * Gets the externalCourseID value for this CourseProvisioningInfo.
     * 
     * @return externalCourseID
     */
    public java.lang.String getExternalCourseID() {
        return externalCourseID;
    }


    /**
     * Sets the externalCourseID value for this CourseProvisioningInfo.
     * 
     * @param externalCourseID
     */
    public void setExternalCourseID(java.lang.String externalCourseID) {
        this.externalCourseID = externalCourseID;
    }


    /**
     * Gets the instructors value for this CourseProvisioningInfo.
     * 
     * @return instructors
     */
    public com.panopto.services.UserProvisioningInfo[] getInstructors() {
        return instructors;
    }


    /**
     * Sets the instructors value for this CourseProvisioningInfo.
     * 
     * @param instructors
     */
    public void setInstructors(com.panopto.services.UserProvisioningInfo[] instructors) {
        this.instructors = instructors;
    }


    /**
     * Gets the longName value for this CourseProvisioningInfo.
     * 
     * @return longName
     */
    public java.lang.String getLongName() {
        return longName;
    }


    /**
     * Sets the longName value for this CourseProvisioningInfo.
     * 
     * @param longName
     */
    public void setLongName(java.lang.String longName) {
        this.longName = longName;
    }


    /**
     * Gets the shortName value for this CourseProvisioningInfo.
     * 
     * @return shortName
     */
    public java.lang.String getShortName() {
        return shortName;
    }


    /**
     * Sets the shortName value for this CourseProvisioningInfo.
     * 
     * @param shortName
     */
    public void setShortName(java.lang.String shortName) {
        this.shortName = shortName;
    }


    /**
     * Gets the students value for this CourseProvisioningInfo.
     * 
     * @return students
     */
    public com.panopto.services.UserProvisioningInfo[] getStudents() {
        return students;
    }


    /**
     * Sets the students value for this CourseProvisioningInfo.
     * 
     * @param students
     */
    public void setStudents(com.panopto.services.UserProvisioningInfo[] students) {
        this.students = students;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CourseProvisioningInfo)) return false;
        CourseProvisioningInfo other = (CourseProvisioningInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.externalCourseID==null && other.getExternalCourseID()==null) || 
             (this.externalCourseID!=null &&
              this.externalCourseID.equals(other.getExternalCourseID()))) &&
            ((this.instructors==null && other.getInstructors()==null) || 
             (this.instructors!=null &&
              java.util.Arrays.equals(this.instructors, other.getInstructors()))) &&
            ((this.longName==null && other.getLongName()==null) || 
             (this.longName!=null &&
              this.longName.equals(other.getLongName()))) &&
            ((this.shortName==null && other.getShortName()==null) || 
             (this.shortName!=null &&
              this.shortName.equals(other.getShortName()))) &&
            ((this.students==null && other.getStudents()==null) || 
             (this.students!=null &&
              java.util.Arrays.equals(this.students, other.getStudents())));
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
        if (getExternalCourseID() != null) {
            _hashCode += getExternalCourseID().hashCode();
        }
        if (getInstructors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInstructors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInstructors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLongName() != null) {
            _hashCode += getLongName().hashCode();
        }
        if (getShortName() != null) {
            _hashCode += getShortName().hashCode();
        }
        if (getStudents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStudents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStudents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CourseProvisioningInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.panopto.com", "CourseProvisioningInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("externalCourseID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "ExternalCourseID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instructors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "Instructors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://services.panopto.com", "UserProvisioningInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://services.panopto.com", "UserProvisioningInfo"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "LongName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "ShortName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("students");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "Students"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://services.panopto.com", "UserProvisioningInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://services.panopto.com", "UserProvisioningInfo"));
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
