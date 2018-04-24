package com.mvs.sampleapp.countrySelection.model;

import com.mvs.tool.adapter.TitleRecyclerAdapter;

public class TitleItem implements TitleRecyclerAdapter.TitleRecyclerItem {

    private String title;

    public TitleItem(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
