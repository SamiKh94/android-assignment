package com.example.samikhleaf.android_assignment.Observers;

import com.example.samikhleaf.android_assignment.DataModels.DayWeatherInfo;

import java.util.Observable;

/**
 * Created by samikhleaf on 1/24/18.
 */

public class WeatherDataObserver extends Observable {


    private static WeatherDataObserver instance = null;

    public static WeatherDataObserver getInstance() {

        if (instance == null)
            instance = new WeatherDataObserver();

        return instance;
    }

    public void setCityChanged(DayWeatherInfo[] model) {

        setChanged();

        notifyObservers(model);
    }

}
