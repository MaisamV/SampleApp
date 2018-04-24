package com.mvs.sampleapp.storage;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.sampleapp.storage.callback.IResponseCallback;

import java.util.List;

public interface IPreLoginStorageManager {

    /**
     * loads the list async
     *
     * @param callback
     */
    void getCountryList(IResponseCallback<List<CountryData>> callback);

    List<CountryData> getCountryList();

    void insertCountryList(List<CountryData> data);

    void deleteAllCountryData();
}
