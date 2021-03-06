package com.example.samikhleaf.android_assignment.DataModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by samikhleaf on 1/24/18.
 */

public class Main implements Serializable {

    @SerializedName("temp")
    private double temp;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("humidity")
    private double humidity;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
