package com.mvs.sampleapp.net;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.sampleapp.net.callback.IResponseCallback;

import java.io.IOException;
import java.util.List;

/**
 * this class handles all pre-login APIs from all the services in app.
 */
public interface IPreLoginApiManager {

    void getCountryData(IResponseCallback<List<CountryData>> callback);

    IResponse<List<CountryData>> getCountryData() throws IOException;
}
