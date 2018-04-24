package com.mvs.sampleapp.net.retrofit;

import com.mvs.sampleapp.countrySelection.model.CountryData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IWhichAppApi {
    @GET("/{apiVersion}/countries")
    Call<List<CountryData>> getCountryList(@Path("apiVersion") String apiVersion);
}
