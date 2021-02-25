package com.newspaperboot.model;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    @SerializedName("id")
    private long id;
    @SerializedName("ptitle")
    private String ptitle;
    @SerializedName("pdesc")
    private String pdesc;
    @SerializedName("pdate")
    private String pdate;
    @SerializedName("fimage")
    private String fimage;
    @SerializedName("feature")
    private String feature;
    @SerializedName("cname")
    private String cname;
    @SerializedName("username")
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getFimage() {
        return fimage;
    }

    public void setFimage(String fimage) {
        this.fimage = fimage;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id=" + id +
                ", ptitle='" + ptitle + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", pdate='" + pdate + '\'' +
                ", fimage='" + fimage + '\'' +
                ", feature='" + feature + '\'' +
                ", cname='" + cname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
