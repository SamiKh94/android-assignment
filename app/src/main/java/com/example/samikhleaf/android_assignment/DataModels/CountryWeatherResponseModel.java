package com.example.samikhleaf.android_assignment.DataModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CountryWeatherResponseModel implements Serializable {

    @SerializedName("list")
    DayWeatherInfo[] dayWeatherInfo;
    @SerializedName("city")
    CityDataModel city;

    public DayWeatherInfo[] getDayWeatherInfo() {
        return dayWeatherInfo;
    }

    public void setDayWeatherInfo(DayWeatherInfo[] dayWeatherInfo) {
        this.dayWeatherInfo = dayWeatherInfo;
    }

    public CityDataModel getCity() {
        return city;
    }

    public void setCity(CityDataModel city) {
        this.city = city;
    }
}
