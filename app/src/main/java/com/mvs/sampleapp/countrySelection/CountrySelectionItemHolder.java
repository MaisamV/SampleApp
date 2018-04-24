package com.mvs.sampleapp.countrySelection;

import android.view.View;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.tool.adapter.TitleDescRecyclerAdapter;

public class CountrySelectionItemHolder extends TitleDescRecyclerAdapter.TitleDescRecyclerHolder<CountryData> {
    public CountrySelectionItemHolder(View itemView) {
        super(itemView);
    }
}