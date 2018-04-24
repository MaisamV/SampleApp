package com.mvs.sampleapp;

import android.support.annotation.NonNull;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.sampleapp.net.IPreLoginApiManager;
import com.mvs.sampleapp.net.IResponse;
import com.mvs.sampleapp.net.callback.IResponseCallback;
import com.mvs.sampleapp.net.retrofit.RetrofitPreLoginApiManager;
import com.mvs.tool.callback.OnLoadCallback;

import java.util.ArrayList;
import java.util.List;

public class AppPreLoginDataProvider implements IPreLoginDataProvider {

    private IPreLoginApiManager preLoginApiManager;

    public AppPreLoginDataProvider() {
        preLoginApiManager = new RetrofitPreLoginApiManager();
    }

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
        //TODO: retrieve from database
        //mock data
        int num = 50;
        ArrayList countryList = new ArrayList(num);
        for (int i = 0; i < num; i++) {
            CountryData data = new CountryData();
            data.setCountry("Country" + i);
            data.setCode(String.valueOf(i));
            data.setIso("iso" + i);
            countryList.add(data);
        }
        callback.onLoad(countryList);
    }

    @Override
    public void refreshCountryListAsync(@NonNull final OnLoadCallback<List<CountryData>> callback) {
        preLoginApiManager.getCountryData(new IResponseCallback<List<CountryData>>() {
            @Override
            public void onResponse(IResponse<List<CountryData>> response) {
                callback.onLoad(response.getBody());
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
