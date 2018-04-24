package com.mvs.sampleapp.net.retrofit;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.sampleapp.net.IPreLoginApiManager;
import com.mvs.sampleapp.net.IResponse;
import com.mvs.sampleapp.net.callback.IResponseCallback;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class RetrofitPreLoginApiManager implements IPreLoginApiManager {

    @Override
    public void getCountryData(IResponseCallback callback) {
        Call<List<CountryData>> call = WhichAppServiceAccess.getInstance().getCountryList();
        call.enqueue(new ServiceCallback<List<CountryData>>(callback));
    }

    @Override
    public IResponse getCountryData() throws IOException {
        Response<List<CountryData>> response = WhichAppServiceAccess.getInstance().getCountryList().execute();
        return new RetrofitResponse<>(response);
    }
}
