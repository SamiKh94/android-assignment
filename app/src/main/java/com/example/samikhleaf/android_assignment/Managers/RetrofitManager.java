package com.example.samikhleaf.android_assignment.Managers;

import com.example.samikhleaf.android_assignment.Constants;
import com.example.samikhleaf.android_assignment.DataModels.CountriesResponseModel;
import com.example.samikhleaf.android_assignment.DataModels.CountryWeatherResponseModel;
import com.example.samikhleaf.android_assignment.Interfaces.AbstractCallback;
import com.example.samikhleaf.android_assignment.Interfaces.WeatherApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samikhleaf on 1/24/18.
 */

public class RetrofitManager {

    private static RetrofitManager instance = null;
    private WeatherApiService service;

    private RetrofitManager() {
        // Exists only to defeat instantiation.

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.openWeatherMapBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(WeatherApiService.class);

    }

    public static RetrofitManager getInstance() {
        if (instance == null) {
            instance = new RetrofitManager();
        }
        return instance;
    }

    public void getCountryWeather(double lat, double lng, AbstractCallback callback) {

        Call<CountryWeatherResponseModel> call = service.getCountryWeatherDetails(lat,
                lng, Constants.openWeatherMapAppId);

        call.enqueue(new Callback<CountryWeatherResponseModel>() {
            @Override
            public void onResponse(Call<CountryWeatherResponseModel> call, Response<CountryWeatherResponseModel> response) {
                callback.onResult(true, response.body());
            }

            @Override
            public void onFailure(Call<CountryWeatherResponseModel> call, Throwable t) {

                callback.onResult(false, null);

            }
        });
    }

    public void getCountriesList(final AbstractCallback callback) {

        Call<List<CountriesResponseModel>> call = service.getCountriesList(Constants.coutriesApiUrl);

        call.enqueue(new Callback<List<CountriesResponseModel>>() {
            @Override
            public void onResponse(Call<List<CountriesResponseModel>> call, Response<List<CountriesResponseModel>> response) {

                callback.onResult(true, response.body());
            }

            @Override
            public void onFailure(Call<List<CountriesResponseModel>> call, Throwable t) {

                callback.onResult(false, null);
            }
        });
    }
}
