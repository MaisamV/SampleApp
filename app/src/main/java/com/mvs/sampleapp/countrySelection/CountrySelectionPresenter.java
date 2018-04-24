package com.mvs.sampleapp.countrySelection;

import com.mvs.sampleapp.AppDataManager;
import com.mvs.sampleapp.IPreLoginDataProvider;
import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.tool.callback.OnLoadCallback;

import java.util.List;

public class CountrySelectionPresenter implements ICountrySelectionPresenter {

    private final IPreLoginDataProvider preLoginDataProvider;
    private ICountrySelectionMvpView mvpView;

    public CountrySelectionPresenter(ICountrySelectionMvpView mvpView) {
        this.mvpView = mvpView;
        preLoginDataProvider = AppDataManager.getInstance().getPreLoginDataProvider();

        getCountryList();
    }

    private void getRefreshedCountryList() {
        preLoginDataProvider.refreshCountryListAsync(new OnLoadCallback<List<CountryData>>() {
            @Override
            public void onLoad(List<CountryData> countryData) {
                loadCountries(countryData);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                //failed to refresh country data
            }
        });
    }

    private void getCountryList() {
        preLoginDataProvider.getCountryListAsync(new OnLoadCallback<List<CountryData>>() {
            @Override
            public void onLoad(List<CountryData> countryData) {
                loadCountries(countryData);
                getRefreshedCountryList();
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                getRefreshedCountryList();
            }
        });
    }

    private void loadCountries(List<CountryData> countryData) {
        mvpView.loadCountryList(countryData);
    }

    @Override
    public void countrySelected(CountryData countryData) {
        //the country is selected, do something
    }

    @Override
    public void onDestroy() {
        //preventing memory leak
        mvpView = null;
    }
}
