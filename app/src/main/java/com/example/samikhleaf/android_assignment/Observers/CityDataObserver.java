package com.example.samikhleaf.android_assignment.Observers;

import com.example.samikhleaf.android_assignment.DataModels.CountriesResponseModel;

import java.util.Observable;

/**
 * Created by samikhleaf on 1/24/18.
 */

public class CityDataObserver extends Observable {

    private static CityDataObserver instance = null;

    public static CityDataObserver getInstance() {

        if (instance == null)
            instance = new CityDataObserver();

        return instance;
    }

    public void setCityChanged(CountriesResponseModel model) {

        setChanged();

        notifyObservers(model);
    }
}
