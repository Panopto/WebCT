/**
 * SystemInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.panopto.services;

public class SystemInfo  implements java.io.Serializable {
    private java.lang.String macRecorderDownloadUrl;

    private java.lang.String recorderDownloadUrl;

    public SystemInfo() {
    }

    public SystemInfo(
           java.lang.String macRecorderDownloadUrl,
           java.lang.String recorderDownloadUrl) {
           this.macRecorderDownloadUrl = macRecorderDownloadUrl;
           this.recorderDownloadUrl = recorderDownloadUrl;
    }


    /**
     * Gets the macRecorderDownloadUrl value for this SystemInfo.
     * 
     * @return macRecorderDownloadUrl
     */
    public java.lang.String getMacRecorderDownloadUrl() {
        return macRecorderDownloadUrl;
    }


    /**
     * Sets the macRecorderDownloadUrl value for this SystemInfo.
     * 
     * @param macRecorderDownloadUrl
     */
    public void setMacRecorderDownloadUrl(java.lang.String macRecorderDownloadUrl) {
        this.macRecorderDownloadUrl = macRecorderDownloadUrl;
    }


    /**
     * Gets the recorderDownloadUrl value for this SystemInfo.
     * 
     * @return recorderDownloadUrl
     */
    public java.lang.String getRecorderDownloadUrl() {
        return recorderDownloadUrl;
    }


    /**
     * Sets the recorderDownloadUrl value for this SystemInfo.
     * 
     * @param recorderDownloadUrl
     */
    public void setRecorderDownloadUrl(java.lang.String recorderDownloadUrl) {
        this.recorderDownloadUrl = recorderDownloadUrl;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SystemInfo)) return false;
        SystemInfo other = (SystemInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.macRecorderDownloadUrl==null && other.getMacRecorderDownloadUrl()==null) || 
             (this.macRecorderDownloadUrl!=null &&
              this.macRecorderDownloadUrl.equals(other.getMacRecorderDownloadUrl()))) &&
            ((this.recorderDownloadUrl==null && other.getRecorderDownloadUrl()==null) || 
             (this.recorderDownloadUrl!=null &&
              this.recorderDownloadUrl.equals(other.getRecorderDownloadUrl())));
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
        if (getMacRecorderDownloadUrl() != null) {
            _hashCode += getMacRecorderDownloadUrl().hashCode();
        }
        if (getRecorderDownloadUrl() != null) {
            _hashCode += getRecorderDownloadUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SystemInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.panopto.com", "SystemInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("macRecorderDownloadUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "MacRecorderDownloadUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recorderDownloadUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "RecorderDownloadUrl"));
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
