package com.mvs.sampleapp;

import android.support.annotation.NonNull;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.sampleapp.net.IPreLoginApiManager;
import com.mvs.sampleapp.net.IResponse;
import com.mvs.sampleapp.net.callback.IResponseCallback;
import com.mvs.sampleapp.net.retrofit.RetrofitPreLoginApiManager;
import com.mvs.sampleapp.storage.IPreLoginStorageManager;
import com.mvs.sampleapp.storage.room.RoomPreLoginStorageManager;
import com.mvs.tool.callback.OnLoadCallback;

import java.util.List;

public class AppPreLoginDataProvider implements IPreLoginDataProvider {

    private IPreLoginApiManager preLoginApiManager;
    private IPreLoginStorageManager preLoginStorageManager;

    public AppPreLoginDataProvider() {
        preLoginApiManager = new RetrofitPreLoginApiManager();
        preLoginStorageManager = new RoomPreLoginStorageManager();
    }

    @Override
    public List<CountryData> getCountryList() {
        return preLoginStorageManager.getCountryList();
    }

    @Override
    public List<CountryData> refreshCountryList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getCountryListAsync(OnLoadCallback<List<CountryData>> callback) {
        //TODO: do the task on another thread
        callback.onLoad(preLoginStorageManager.getCountryList());
    }

    @Override
    public void refreshCountryListAsync(@NonNull final OnLoadCallback<List<CountryData>> callback) {
        preLoginApiManager.getCountryData(new IResponseCallback<List<CountryData>>() {
            @Override
            public void onResponse(IResponse<List<CountryData>> response) {
                List<CountryData> dataList = response.getBody();
                refreshDatabaseData(dataList);
                callback.onLoad(dataList);
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    private void refreshDatabaseData(List<CountryData> dataList) {
        preLoginStorageManager.deleteAllCountryData();
        preLoginStorageManager.insertCountryList(dataList);
    }
}
