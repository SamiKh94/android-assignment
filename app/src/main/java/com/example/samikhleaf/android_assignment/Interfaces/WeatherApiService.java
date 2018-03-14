package com.example.samikhleaf.android_assignment.Interfaces;

import com.example.samikhleaf.android_assignment.DataModels.CountriesResponseModel;
import com.example.samikhleaf.android_assignment.DataModels.CountryWeatherResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface WeatherApiService {

    @GET
    Call<List<CountriesResponseModel>> getCountriesList(@Url String serviceUrl);

    @GET("data/2.5/forecast")
    Call<CountryWeatherResponseModel> getCountryWeatherDetails(@Query("lat") double lat,
                                                               @Query("lon") double lon,
                                                               @Query("appid") String appId);
}
