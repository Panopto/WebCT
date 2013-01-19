/**
 * DeliveryInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.panopto.services;

public class DeliveryInfo  implements java.io.Serializable {
    private java.lang.String displayName;

    private java.lang.String publicID;

    private java.lang.String viewerURL;

    public DeliveryInfo() {
    }

    public DeliveryInfo(
           java.lang.String displayName,
           java.lang.String publicID,
           java.lang.String viewerURL) {
           this.displayName = displayName;
           this.publicID = publicID;
           this.viewerURL = viewerURL;
    }


    /**
     * Gets the displayName value for this DeliveryInfo.
     * 
     * @return displayName
     */
    public java.lang.String getDisplayName() {
        return displayName;
    }


    /**
     * Sets the displayName value for this DeliveryInfo.
     * 
     * @param displayName
     */
    public void setDisplayName(java.lang.String displayName) {
        this.displayName = displayName;
    }


    /**
     * Gets the publicID value for this DeliveryInfo.
     * 
     * @return publicID
     */
    public java.lang.String getPublicID() {
        return publicID;
    }


    /**
     * Sets the publicID value for this DeliveryInfo.
     * 
     * @param publicID
     */
    public void setPublicID(java.lang.String publicID) {
        this.publicID = publicID;
    }


    /**
     * Gets the viewerURL value for this DeliveryInfo.
     * 
     * @return viewerURL
     */
    public java.lang.String getViewerURL() {
        return viewerURL;
    }


    /**
     * Sets the viewerURL value for this DeliveryInfo.
     * 
     * @param viewerURL
     */
    public void setViewerURL(java.lang.String viewerURL) {
        this.viewerURL = viewerURL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeliveryInfo)) return false;
        DeliveryInfo other = (DeliveryInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.displayName==null && other.getDisplayName()==null) || 
             (this.displayName!=null &&
              this.displayName.equals(other.getDisplayName()))) &&
            ((this.publicID==null && other.getPublicID()==null) || 
             (this.publicID!=null &&
              this.publicID.equals(other.getPublicID()))) &&
            ((this.viewerURL==null && other.getViewerURL()==null) || 
             (this.viewerURL!=null &&
              this.viewerURL.equals(other.getViewerURL())));
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
        if (getDisplayName() != null) {
            _hashCode += getDisplayName().hashCode();
        }
        if (getPublicID() != null) {
            _hashCode += getPublicID().hashCode();
        }
        if (getViewerURL() != null) {
            _hashCode += getViewerURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeliveryInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.panopto.com", "DeliveryInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "DisplayName"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viewerURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "ViewerURL"));
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
