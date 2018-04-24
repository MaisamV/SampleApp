package com.mvs.sampleapp.countrySelection.model;

import com.mvs.tool.adapter.TitleDescRecyclerAdapter;

public class CountryData implements TitleDescRecyclerAdapter.TitleDescRecyclerItem {
    private String iso;
    private String country;
    private String code;

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

    @Override
    public String getDescription() {
        return "+" + code;
    }

    @Override
    public String getTitle() {
        return country;
    }
}
