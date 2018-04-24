package com.mvs.sampleapp.net;

import com.mvs.sampleapp.net.callback.IResponseCallback;

import java.io.IOException;

/**
 * this class handles all pre-login APIs from all the services in app.
 */
public interface IPreLoginApiManager {

    void getCountryData(IResponseCallback callback);

    IResponse getCountryData() throws IOException;
}
