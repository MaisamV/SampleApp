package com.mvs.sampleapp.net.retrofit;

import com.mvs.sampleapp.net.callback.IResponseCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceCallback<T> implements Callback<T> {

    private IResponseCallback<T> result;

    ServiceCallback(IResponseCallback<T> result) {
        this.result = result;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        this.result.onResponse(new RetrofitResponse<T>(response));
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        t.printStackTrace();
        this.result.onFailure(t);
    }
}