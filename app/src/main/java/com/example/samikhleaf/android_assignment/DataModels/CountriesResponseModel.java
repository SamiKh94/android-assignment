package com.example.samikhleaf.android_assignment.DataModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CountriesResponseModel implements Serializable {

    @SerializedName("name")
    private String countryName;
    @SerializedName("region")
    private String regionName;
    @SerializedName("alpha2Code")
    private String countryCode;
    @SerializedName("latlng")
    private double[] latlng;
    @SerializedName("capital")
    private String capital;
    @SerializedName("population")
    private int population;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double[] getLatlng() {
        return latlng;
    }

    public void setLatlng(double[] latlng) {
        this.latlng = latlng;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
