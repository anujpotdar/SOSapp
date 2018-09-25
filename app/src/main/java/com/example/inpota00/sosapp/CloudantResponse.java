
package com.example.inpota00.sosapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloudantResponse {

    @SerializedName("ok")
    @Expose
    private Boolean ok;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("rev")
    @Expose
    private String rev;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

}
