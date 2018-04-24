package com.mvs.sampleapp;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.tool.callback.OnLoadCallback;

import java.util.List;

public interface IPreLoginDataProvider {

    /**
     * NOTE: do not call this method on main thread
     *
     * @return list of countries
     * @see {@link IPreLoginDataProvider#refreshCountryList()}
     */
    List<CountryData> getCountryList();

    /**
     * NOTE: do not call this method on main thread
     *
     * @return refresh the list and then return
     * @see {@link IPreLoginDataProvider#getCountryList()}
     */
    List<CountryData> refreshCountryList();


    void getCountryListAsync(OnLoadCallback<List<CountryData>> callback);

    void refreshCountryListAsync(OnLoadCallback<List<CountryData>> callback);
}
