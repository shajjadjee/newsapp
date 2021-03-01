package com.newspaperboot.model;

import com.google.gson.annotations.SerializedName;

public class CatModel {
    @SerializedName("id")
    private long id;
    @SerializedName("cname")
    private String cname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "CatModel{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                '}';
    }
}
