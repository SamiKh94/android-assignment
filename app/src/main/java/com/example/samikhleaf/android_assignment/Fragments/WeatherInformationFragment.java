package com.example.samikhleaf.android_assignment.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samikhleaf.android_assignment.DataModels.DayWeatherInfo;
import com.example.samikhleaf.android_assignment.R;

/**
 * Created by samikhleaf on 1/24/18.
 */

public class WeatherInformationFragment extends Fragment {

    private DayWeatherInfo dayWeatherInfo;
    private TextView date, temp, pressure, humidity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragement_weather_details, container, false);

        Bundle args = getArguments();

        if (args != null)
            dayWeatherInfo = (DayWeatherInfo) args.getSerializable("day_weather");


        date = rootView.findViewById(R.id.date);
        temp = rootView.findViewById(R.id.temp);
        pressure = rootView.findViewById(R.id.pressure);
        humidity = rootView.findViewById(R.id.humidity);

        setData(dayWeatherInfo);

        return rootView;
    }

    public void setData(DayWeatherInfo data) {
        date.setText(dayWeatherInfo.getDate());
        temp.setText(dayWeatherInfo.getMain().getTemp() + "");
        pressure.setText(dayWeatherInfo.getMain().getPressure() + "");
        humidity.setText(dayWeatherInfo.getMain().getHumidity() + "");
    }
}
