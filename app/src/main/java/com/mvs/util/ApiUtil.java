package com.mvs.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtil {

    public static <T> T initService(Class<T> clazz, String serviceAddress) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(serviceAddress)
                .build();

        return retrofit.create(clazz);
    }
}