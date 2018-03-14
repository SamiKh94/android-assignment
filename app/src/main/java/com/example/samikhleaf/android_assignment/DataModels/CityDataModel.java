package com.example.samikhleaf.android_assignment.DataModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CityDataModel implements Serializable {

    @SerializedName("name")
    String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
