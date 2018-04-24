package com.mvs.sampleapp.net.retrofit;

import com.google.gson.Gson;
import com.mvs.sampleapp.net.IResponse;
import com.mvs.util.ObjectUtil;

import java.io.IOException;

import retrofit2.Response;

public class RetrofitResponse<T> implements IResponse<T> {
    Response<T> response;

    RetrofitResponse(retrofit2.Response<T> response) {
        this.response = response;
    }

    public boolean isSuccessful() {
        return response.isSuccessful();
    }

    @Override
    public T getBody() {
        return response.body();
    }

    @Override
    public <M> M getErrorBody(Class<M> clazz) {
        M result = null;
        if (ObjectUtil.notNull(response.errorBody())) {
            try {
                result = new Gson().fromJson(response.errorBody().string(), clazz);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to convert error message to object", e);
            }
        }
        return result;
    }

    @Override
    public Object getHeaders() {
        return response.headers();
    }

    @Override
    public int getCode() {
        return response.code();
    }
}