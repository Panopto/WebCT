/**
 * CourseInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.panopto.services;

public class CourseInfo  implements java.io.Serializable {
    private com.panopto.services.AccessLevel access;

    private java.lang.String audioPodcastURL;

    private java.lang.String audioRssURL;

    private java.lang.String courseSettingsURL;

    private java.lang.String displayName;

    private java.lang.String externalCourseID;

    private java.lang.String publicID;

    private java.lang.String videoPodcastURL;

    private java.lang.String videoRssURL;

    public CourseInfo() {
    }

    public CourseInfo(
           com.panopto.services.AccessLevel access,
           java.lang.String audioPodcastURL,
           java.lang.String audioRssURL,
           java.lang.String courseSettingsURL,
           java.lang.String displayName,
           java.lang.String externalCourseID,
           java.lang.String publicID,
           java.lang.String videoPodcastURL,
           java.lang.String videoRssURL) {
           this.access = access;
           this.audioPodcastURL = audioPodcastURL;
           this.audioRssURL = audioRssURL;
           this.courseSettingsURL = courseSettingsURL;
           this.displayName = displayName;
           this.externalCourseID = externalCourseID;
           this.publicID = publicID;
           this.videoPodcastURL = videoPodcastURL;
           this.videoRssURL = videoRssURL;
    }


    /**
     * Gets the access value for this CourseInfo.
     * 
     * @return access
     */
    public com.panopto.services.AccessLevel getAccess() {
        return access;
    }


    /**
     * Sets the access value for this CourseInfo.
     * 
     * @param access
     */
    public void setAccess(com.panopto.services.AccessLevel access) {
        this.access = access;
    }


    /**
     * Gets the audioPodcastURL value for this CourseInfo.
     * 
     * @return audioPodcastURL
     */
    public java.lang.String getAudioPodcastURL() {
        return audioPodcastURL;
    }


    /**
     * Sets the audioPodcastURL value for this CourseInfo.
     * 
     * @param audioPodcastURL
     */
    public void setAudioPodcastURL(java.lang.String audioPodcastURL) {
        this.audioPodcastURL = audioPodcastURL;
    }


    /**
     * Gets the audioRssURL value for this CourseInfo.
     * 
     * @return audioRssURL
     */
    public java.lang.String getAudioRssURL() {
        return audioRssURL;
    }


    /**
     * Sets the audioRssURL value for this CourseInfo.
     * 
     * @param audioRssURL
     */
    public void setAudioRssURL(java.lang.String audioRssURL) {
        this.audioRssURL = audioRssURL;
    }


    /**
     * Gets the courseSettingsURL value for this CourseInfo.
     * 
     * @return courseSettingsURL
     */
    public java.lang.String getCourseSettingsURL() {
        return courseSettingsURL;
    }


    /**
     * Sets the courseSettingsURL value for this CourseInfo.
     * 
     * @param courseSettingsURL
     */
    public void setCourseSettingsURL(java.lang.String courseSettingsURL) {
        this.courseSettingsURL = courseSettingsURL;
    }


    /**
     * Gets the displayName value for this CourseInfo.
     * 
     * @return displayName
     */
    public java.lang.String getDisplayName() {
        return displayName;
    }


    /**
     * Sets the displayName value for this CourseInfo.
     * 
     * @param displayName
     */
    public void setDisplayName(java.lang.String displayName) {
        this.displayName = displayName;
    }


    /**
     * Gets the externalCourseID value for this CourseInfo.
     * 
     * @return externalCourseID
     */
    public java.lang.String getExternalCourseID() {
        return externalCourseID;
    }


    /**
     * Sets the externalCourseID value for this CourseInfo.
     * 
     * @param externalCourseID
     */
    public void setExternalCourseID(java.lang.String externalCourseID) {
        this.externalCourseID = externalCourseID;
    }


    /**
     * Gets the publicID value for this CourseInfo.
     * 
     * @return publicID
     */
    public java.lang.String getPublicID() {
        return publicID;
    }


    /**
     * Sets the publicID value for this CourseInfo.
     * 
     * @param publicID
     */
    public void setPublicID(java.lang.String publicID) {
        this.publicID = publicID;
    }


    /**
     * Gets the videoPodcastURL value for this CourseInfo.
     * 
     * @return videoPodcastURL
     */
    public java.lang.String getVideoPodcastURL() {
        return videoPodcastURL;
    }


    /**
     * Sets the videoPodcastURL value for this CourseInfo.
     * 
     * @param videoPodcastURL
     */
    public void setVideoPodcastURL(java.lang.String videoPodcastURL) {
        this.videoPodcastURL = videoPodcastURL;
    }


    /**
     * Gets the videoRssURL value for this CourseInfo.
     * 
     * @return videoRssURL
     */
    public java.lang.String getVideoRssURL() {
        return videoRssURL;
    }


    /**
     * Sets the videoRssURL value for this CourseInfo.
     * 
     * @param videoRssURL
     */
    public void setVideoRssURL(java.lang.String videoRssURL) {
        this.videoRssURL = videoRssURL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CourseInfo)) return false;
        CourseInfo other = (CourseInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.access==null && other.getAccess()==null) || 
             (this.access!=null &&
              this.access.equals(other.getAccess()))) &&
            ((this.audioPodcastURL==null && other.getAudioPodcastURL()==null) || 
             (this.audioPodcastURL!=null &&
              this.audioPodcastURL.equals(other.getAudioPodcastURL()))) &&
            ((this.audioRssURL==null && other.getAudioRssURL()==null) || 
             (this.audioRssURL!=null &&
              this.audioRssURL.equals(other.getAudioRssURL()))) &&
            ((this.courseSettingsURL==null && other.getCourseSettingsURL()==null) || 
             (this.courseSettingsURL!=null &&
              this.courseSettingsURL.equals(other.getCourseSettingsURL()))) &&
            ((this.displayName==null && other.getDisplayName()==null) || 
             (this.displayName!=null &&
              this.displayName.equals(other.getDisplayName()))) &&
            ((this.externalCourseID==null && other.getExternalCourseID()==null) || 
             (this.externalCourseID!=null &&
              this.externalCourseID.equals(other.getExternalCourseID()))) &&
            ((this.publicID==null && other.getPublicID()==null) || 
             (this.publicID!=null &&
              this.publicID.equals(other.getPublicID()))) &&
            ((this.videoPodcastURL==null && other.getVideoPodcastURL()==null) || 
             (this.videoPodcastURL!=null &&
              this.videoPodcastURL.equals(other.getVideoPodcastURL()))) &&
            ((this.videoRssURL==null && other.getVideoRssURL()==null) || 
             (this.videoRssURL!=null &&
              this.videoRssURL.equals(other.getVideoRssURL())));
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
        if (getAccess() != null) {
            _hashCode += getAccess().hashCode();
        }
        if (getAudioPodcastURL() != null) {
            _hashCode += getAudioPodcastURL().hashCode();
        }
        if (getAudioRssURL() != null) {
            _hashCode += getAudioRssURL().hashCode();
        }
        if (getCourseSettingsURL() != null) {
            _hashCode += getCourseSettingsURL().hashCode();
        }
        if (getDisplayName() != null) {
            _hashCode += getDisplayName().hashCode();
        }
        if (getExternalCourseID() != null) {
            _hashCode += getExternalCourseID().hashCode();
        }
        if (getPublicID() != null) {
            _hashCode += getPublicID().hashCode();
        }
        if (getVideoPodcastURL() != null) {
            _hashCode += getVideoPodcastURL().hashCode();
        }
        if (getVideoRssURL() != null) {
            _hashCode += getVideoRssURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CourseInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.panopto.com", "CourseInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("access");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "Access"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://services.panopto.com", "AccessLevel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audioPodcastURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "AudioPodcastURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audioRssURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "AudioRssURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("courseSettingsURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "CourseSettingsURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "DisplayName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("externalCourseID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "ExternalCourseID"));
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
        elemField.setFieldName("videoPodcastURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "VideoPodcastURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("videoRssURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.panopto.com", "VideoRssURL"));
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
