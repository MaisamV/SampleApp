package com.mvs.sampleapp;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.tool.callback.OnLoadCallback;

import java.util.ArrayList;
import java.util.List;

public class MockPreLoginDataProvider implements IPreLoginDataProvider {
    @Override
    public List<CountryData> getCountryList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CountryData> refreshCountryList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getCountryListAsync(OnLoadCallback<List<CountryData>> callback) {
        //mock data
        int num = 50;
        ArrayList countryList = new ArrayList(num);
        for (int i = 0; i < num; i++) {
            CountryData data = new CountryData();
            data.setCountry("Country" + i);
            data.setCode(i);
            data.setIso("iso" + i);
            countryList.add(data);
        }
        callback.onLoad(countryList);
    }

    @Override
    public void refreshCountryListAsync(OnLoadCallback<List<CountryData>> callback) {
        //mock data
        int num = 100;
        ArrayList countryList = new ArrayList(num);
        for (int i = 0; i < num; i++) {
            CountryData data = new CountryData();
            data.setCountry("Country" + i);
            data.setCode(i);
            data.setIso("iso" + i);
            countryList.add(data);
        }
        callback.onLoad(countryList);
    }
}
