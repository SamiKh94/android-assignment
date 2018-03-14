package com.example.samikhleaf.android_assignment.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samikhleaf.android_assignment.Adapters.WeatherInfoPagerAdapter;
import com.example.samikhleaf.android_assignment.DataModels.DayWeatherInfo;
import com.example.samikhleaf.android_assignment.Observers.WeatherDataObserver;
import com.example.samikhleaf.android_assignment.R;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by samikhleaf on 1/24/18.
 */

public class MainWeatherInformationFragment extends Fragment implements Observer {

    ViewPager tabsPager;
    TabLayout tabs;
    DayWeatherInfo today, tomorrow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main_weather_info, container, false);
        tabsPager = rootView.findViewById(R.id.tabs_pager);
        tabs = rootView.findViewById(R.id.tabs);
        Bundle args = getArguments();
        if (args != null) {
            today = (DayWeatherInfo) args.getSerializable("day_weather");
            tomorrow = (DayWeatherInfo) args.getSerializable("tomorrow_weather");
        }


        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        WeatherDataObserver.getInstance().addObserver(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        WeatherDataObserver.getInstance().deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof WeatherDataObserver) {

            initTabs((DayWeatherInfo[]) arg);

        }
    }

    private void initTabs(DayWeatherInfo[] arg) {

        WeatherInfoPagerAdapter adapter = new WeatherInfoPagerAdapter(getChildFragmentManager());
        adapter.setDayWeatherInfo(arg);

        WeatherInformationFragment mFragementToday = new WeatherInformationFragment();
        Bundle args1 = new Bundle();
        args1.putSerializable("day_weather", arg[0]);
        mFragementToday.setArguments(args1);
        adapter.addFragment(mFragementToday, "Today");

        WeatherInformationFragment mFragementTomorrow = new WeatherInformationFragment();
        Bundle args2 = new Bundle();
        args1.putSerializable("day_weather", arg[3]);
        mFragementToday.setArguments(args2);
        adapter.addFragment(mFragementTomorrow, "Tomorrow");

        tabsPager.setAdapter(adapter);

        tabs.setupWithViewPager(tabsPager);

    }
}
