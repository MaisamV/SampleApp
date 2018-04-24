package com.mvs.sampleapp.storage.room.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "country")
public class CountryDataModel {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "iso")
    private String iso;

    @ColumnInfo(name = "name")
    private String country;

    @ColumnInfo(name = "phone")
    private String code;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
