package com.mvs.sampleapp.net.retrofit;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.util.ApiUtil;

import java.util.List;

import retrofit2.Call;

public class WhichAppServiceAccess {

    public static final String SERVICE_PROTOCOL = "https";
    public static final String SERVICE_HOST = "api.whichapp.com";
    public static final String SERVICE_PORT = "80";

    private static WhichAppServiceAccess instance;

    public static WhichAppServiceAccess getInstance() {
        if (instance == null) {
            instance = new WhichAppServiceAccess();
        }
        return instance;
    }

    //-------------------------------------

    private IWhichAppApi service;

    private WhichAppServiceAccess() {
    }

    private boolean isInitialized() {
        return service != null;
    }

    public void init() {
        service = createApiImplementation();
    }

    protected IWhichAppApi createApiImplementation() {
        return ApiUtil.initService(IWhichAppApi.class,
                SERVICE_PROTOCOL + "://" + SERVICE_HOST + ":" + SERVICE_PORT);
    }

    public Call<List<CountryData>> getCountryList() {
        if (!isInitialized()) {
            init();
        }
        return service.getCountryList("v1");
    }
}
