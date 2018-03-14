package com.example.samikhleaf.android_assignment.DataModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by samikhleaf on 1/24/18.
 */

public class DayWeatherInfo implements Serializable {

    @SerializedName("dt_txt")
    private String date;
    @SerializedName("main")
    private Main main;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
