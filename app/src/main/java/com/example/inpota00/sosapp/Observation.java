
package com.example.inpota00.sosapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Observation {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("expire_time_gmt")
    @Expose
    private Integer expireTimeGmt;
    @SerializedName("obs_id")
    @Expose
    private String obsId;
    @SerializedName("obs_name")
    @Expose
    private String obsName;
    @SerializedName("valid_time_gmt")
    @Expose
    private Integer validTimeGmt;
    @SerializedName("day_ind")
    @Expose
    private String dayInd;
    @SerializedName("temp")
    @Expose
    private Integer temp;
    @SerializedName("wx_icon")
    @Expose
    private Integer wxIcon;
    @SerializedName("icon_extd")
    @Expose
    private Integer iconExtd;
    @SerializedName("wx_phrase")
    @Expose
    private String wxPhrase;
    @SerializedName("pressure_tend")
    @Expose
    private Integer pressureTend;
    @SerializedName("pressure_desc")
    @Expose
    private String pressureDesc;
    @SerializedName("dewPt")
    @Expose
    private Integer dewPt;
    @SerializedName("heat_index")
    @Expose
    private Integer heatIndex;
    @SerializedName("rh")
    @Expose
    private Integer rh;
    @SerializedName("pressure")
    @Expose
    private Double pressure;
    @SerializedName("vis")
    @Expose
    private Integer vis;
    @SerializedName("wc")
    @Expose
    private Integer wc;
    @SerializedName("wdir")
    @Expose
    private Integer wdir;
    @SerializedName("wdir_cardinal")
    @Expose
    private String wdirCardinal;
    @SerializedName("gust")
    @Expose
    private Object gust;
    @SerializedName("wspd")
    @Expose
    private Integer wspd;
    @SerializedName("max_temp")
    @Expose
    private Object maxTemp;
    @SerializedName("min_temp")
    @Expose
    private Object minTemp;
    @SerializedName("precip_total")
    @Expose
    private Object precipTotal;
    @SerializedName("precip_hrly")
    @Expose
    private Object precipHrly;
    @SerializedName("snow_hrly")
    @Expose
    private Object snowHrly;
    @SerializedName("uv_desc")
    @Expose
    private String uvDesc;
    @SerializedName("feels_like")
    @Expose
    private Integer feelsLike;
    @SerializedName("uv_index")
    @Expose
    private Integer uvIndex;
    @SerializedName("qualifier")
    @Expose
    private Object qualifier;
    @SerializedName("qualifier_svrty")
    @Expose
    private Object qualifierSvrty;
    @SerializedName("blunt_phrase")
    @Expose
    private Object bluntPhrase;
    @SerializedName("terse_phrase")
    @Expose
    private Object tersePhrase;
    @SerializedName("clds")
    @Expose
    private Object clds;
    @SerializedName("water_temp")
    @Expose
    private Object waterTemp;
    @SerializedName("primary_wave_period")
    @Expose
    private Object primaryWavePeriod;
    @SerializedName("primary_wave_height")
    @Expose
    private Object primaryWaveHeight;
    @SerializedName("primary_swell_period")
    @Expose
    private Object primarySwellPeriod;
    @SerializedName("primary_swell_height")
    @Expose
    private Object primarySwellHeight;
    @SerializedName("primary_swell_direction")
    @Expose
    private Object primarySwellDirection;
    @SerializedName("secondary_swell_period")
    @Expose
    private Object secondarySwellPeriod;
    @SerializedName("secondary_swell_height")
    @Expose
    private Object secondarySwellHeight;
    @SerializedName("secondary_swell_direction")
    @Expose
    private Object secondarySwellDirection;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public Integer getExpireTimeGmt() {
        return expireTimeGmt;
    }

    public void setExpireTimeGmt(Integer expireTimeGmt) {
        this.expireTimeGmt = expireTimeGmt;
    }

    public String getObsId() {
        return obsId;
    }

    public void setObsId(String obsId) {
        this.obsId = obsId;
    }

    public String getObsName() {
        return obsName;
    }

    public void setObsName(String obsName) {
        this.obsName = obsName;
    }

    public Integer getValidTimeGmt() {
        return validTimeGmt;
    }

    public void setValidTimeGmt(Integer validTimeGmt) {
        this.validTimeGmt = validTimeGmt;
    }

    public String getDayInd() {
        return dayInd;
    }

    public void setDayInd(String dayInd) {
        this.dayInd = dayInd;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getWxIcon() {
        return wxIcon;
    }

    public void setWxIcon(Integer wxIcon) {
        this.wxIcon = wxIcon;
    }

    public Integer getIconExtd() {
        return iconExtd;
    }

    public void setIconExtd(Integer iconExtd) {
        this.iconExtd = iconExtd;
    }

    public String getWxPhrase() {
        return wxPhrase;
    }

    public void setWxPhrase(String wxPhrase) {
        this.wxPhrase = wxPhrase;
    }

    public Integer getPressureTend() {
        return pressureTend;
    }

    public void setPressureTend(Integer pressureTend) {
        this.pressureTend = pressureTend;
    }

    public String getPressureDesc() {
        return pressureDesc;
    }

    public void setPressureDesc(String pressureDesc) {
        this.pressureDesc = pressureDesc;
    }

    public Integer getDewPt() {
        return dewPt;
    }

    public void setDewPt(Integer dewPt) {
        this.dewPt = dewPt;
    }

    public Integer getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(Integer heatIndex) {
        this.heatIndex = heatIndex;
    }

    public Integer getRh() {
        return rh;
    }

    public void setRh(Integer rh) {
        this.rh = rh;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Integer getVis() {
        return vis;
    }

    public void setVis(Integer vis) {
        this.vis = vis;
    }

    public Integer getWc() {
        return wc;
    }

    public void setWc(Integer wc) {
        this.wc = wc;
    }

    public Integer getWdir() {
        return wdir;
    }

    public void setWdir(Integer wdir) {
        this.wdir = wdir;
    }

    public String getWdirCardinal() {
        return wdirCardinal;
    }

    public void setWdirCardinal(String wdirCardinal) {
        this.wdirCardinal = wdirCardinal;
    }

    public Object getGust() {
        return gust;
    }

    public void setGust(Object gust) {
        this.gust = gust;
    }

    public Integer getWspd() {
        return wspd;
    }

    public void setWspd(Integer wspd) {
        this.wspd = wspd;
    }

    public Object getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Object maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Object getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Object minTemp) {
        this.minTemp = minTemp;
    }

    public Object getPrecipTotal() {
        return precipTotal;
    }

    public void setPrecipTotal(Object precipTotal) {
        this.precipTotal = precipTotal;
    }

    public Object getPrecipHrly() {
        return precipHrly;
    }

    public void setPrecipHrly(Object precipHrly) {
        this.precipHrly = precipHrly;
    }

    public Object getSnowHrly() {
        return snowHrly;
    }

    public void setSnowHrly(Object snowHrly) {
        this.snowHrly = snowHrly;
    }

    public String getUvDesc() {
        return uvDesc;
    }

    public void setUvDesc(String uvDesc) {
        this.uvDesc = uvDesc;
    }

    public Integer getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Integer feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Integer getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Object getQualifier() {
        return qualifier;
    }

    public void setQualifier(Object qualifier) {
        this.qualifier = qualifier;
    }

    public Object getQualifierSvrty() {
        return qualifierSvrty;
    }

    public void setQualifierSvrty(Object qualifierSvrty) {
        this.qualifierSvrty = qualifierSvrty;
    }

    public Object getBluntPhrase() {
        return bluntPhrase;
    }

    public void setBluntPhrase(Object bluntPhrase) {
        this.bluntPhrase = bluntPhrase;
    }

    public Object getTersePhrase() {
        return tersePhrase;
    }

    public void setTersePhrase(Object tersePhrase) {
        this.tersePhrase = tersePhrase;
    }

    public Object getClds() {
        return clds;
    }

    public void setClds(Object clds) {
        this.clds = clds;
    }

    public Object getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(Object waterTemp) {
        this.waterTemp = waterTemp;
    }

    public Object getPrimaryWavePeriod() {
        return primaryWavePeriod;
    }

    public void setPrimaryWavePeriod(Object primaryWavePeriod) {
        this.primaryWavePeriod = primaryWavePeriod;
    }

    public Object getPrimaryWaveHeight() {
        return primaryWaveHeight;
    }

    public void setPrimaryWaveHeight(Object primaryWaveHeight) {
        this.primaryWaveHeight = primaryWaveHeight;
    }

    public Object getPrimarySwellPeriod() {
        return primarySwellPeriod;
    }

    public void setPrimarySwellPeriod(Object primarySwellPeriod) {
        this.primarySwellPeriod = primarySwellPeriod;
    }

    public Object getPrimarySwellHeight() {
        return primarySwellHeight;
    }

    public void setPrimarySwellHeight(Object primarySwellHeight) {
        this.primarySwellHeight = primarySwellHeight;
    }

    public Object getPrimarySwellDirection() {
        return primarySwellDirection;
    }

    public void setPrimarySwellDirection(Object primarySwellDirection) {
        this.primarySwellDirection = primarySwellDirection;
    }

    public Object getSecondarySwellPeriod() {
        return secondarySwellPeriod;
    }

    public void setSecondarySwellPeriod(Object secondarySwellPeriod) {
        this.secondarySwellPeriod = secondarySwellPeriod;
    }

    public Object getSecondarySwellHeight() {
        return secondarySwellHeight;
    }

    public void setSecondarySwellHeight(Object secondarySwellHeight) {
        this.secondarySwellHeight = secondarySwellHeight;
    }

    public Object getSecondarySwellDirection() {
        return secondarySwellDirection;
    }

    public void setSecondarySwellDirection(Object secondarySwellDirection) {
        this.secondarySwellDirection = secondarySwellDirection;
    }

}
