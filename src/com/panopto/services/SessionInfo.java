/**
 * SessionInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.panopto.services;

public class SessionInfo  implements java.io.Serializable {
    private java.lang.String broadcastViewerURL;

    private java.lang.String liveNotesURL;

    private java.lang.String name;

    private java.lang.String publicID;

    public SessionInfo() {
    }

    public SessionInfo(
           java.lang.String broadcastViewerURL,
           java.lang.String liveNotesURL,
           java.lang.String name,
           java.lang.String publicID) {
           this.broadcastViewerURL = broadcastViewerURL;
           this.liveNotesURL = liveNotesURL;
           this.name = name;
           this.publicID = publicID;
    }


    /**
     * Gets the broadcastViewerURL value for this SessionInfo.
     * 
     * @return broadcastViewerURL
     */
    public java.lang.String getBroadcastViewerURL() {
        return broadcastViewerURL;
    }


    /**
     * Sets the broadcastViewerURL value for this SessionInfo.
     * 
     * @param broadcastViewerURL
     */
    public void setBroadcastViewerURL(java.lang.String broadcastViewerURL) {
        this.broadcastViewerURL = broadcastViewerURL;
    }


    /**
     * Gets the liveNotesURL value for this SessionInfo.
     * 
     * @return liveNotesURL
     */
    public java.lang.String getLiveNotesURL() {
        return liveNotesURL;
    }


    /**
     * Sets the liveNotesURL value for this SessionInfo.
     * 
     * @param liveNotesURL
     */
    public void setLiveNotesURL(java.lang.String liveNotesURL) {
        this.liveNotesURL = liveNotesURL;
    }


    /**
     * Gets the name value for this SessionInfo.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this SessionInfo.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the publicID value for this SessionInfo.
     * 
     * @return publicID
     */
    public java.lang.String getPublicID() {
        return publicID;
    }


    /**
     * Sets the publicID value for this SessionInfo.
     * 
     * @param publicID
     */
    public void setPublicID(java.lang.String publicID) {
        this.publicID = publicID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SessionInfo)) return false;
        SessionInfo other = (SessionInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.broadcastViewerURL==null && other.getBroadcastViewerURL()==null) || 
             (this.broadcastViewerURL!=null &&
              this.broadcastViewerURL.equals(other.getBroadcastViewerURL()))) &&
            ((this.liveNotesURL==null && other.getLiveNotesURL()==null) || 
             (this.liveNotesURL!=null &&
              this.liveNotesURL.equals(other.getLiveNotesURL()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.publicID==null && other.getPublicID()==null) || 
             (this.publicID!=null &&
              this.publicID.equals(other.getPublicID())));
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
        if (getBroadcastViewerURL() != null) {
            _hashCode += getBroadcastViewerURL().hashCode();
        }
        if (getLiveNotesURL() != null) {
            _hashCode += getLiveNotesURL().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPublicID() != null) {
            _hashCode += getPublicID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SessionInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.panopto.com", "SessionInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("broadcastViewerURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "BroadcastViewerURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liveNotesURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "LiveNotesURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "PublicID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
