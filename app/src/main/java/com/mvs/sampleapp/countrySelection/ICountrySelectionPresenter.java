package com.mvs.sampleapp.countrySelection;

import com.mvs.sampleapp.countrySelection.model.CountryData;

public interface ICountrySelectionPresenter {
    void countrySelected(CountryData countryData);

    void onDestroy();
}
