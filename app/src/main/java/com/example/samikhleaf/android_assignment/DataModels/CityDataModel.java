package com.example.samikhleaf.android_assignment.DataModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by samikhleaf on 1/24/18.
 */

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
