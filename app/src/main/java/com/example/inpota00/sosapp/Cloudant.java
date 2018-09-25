
package com.example.inpota00.sosapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cloudant {

    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("image-url")
    @Expose
    private String imageUrl;
    @SerializedName("wx_icon")
    @Expose
    private String wxIcon;
    @SerializedName("wx_phrase")
    @Expose
    private String wxPhrase;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @SerializedName("phoneNo")
    @Expose
    private String phoneNo;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWxIcon() {
        return wxIcon;
    }

    public void setWxIcon(String wxIcon) {
        this.wxIcon = wxIcon;
    }

    public String getWxPhrase() {
        return wxPhrase;
    }

    public void setWxPhrase(String wxPhrase) {
        this.wxPhrase = wxPhrase;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
