package com.example.samikhleaf.android_assignment.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.samikhleaf.android_assignment.DataModels.DayWeatherInfo;
import com.example.samikhleaf.android_assignment.Fragments.WeatherInformationFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by samikhleaf on 1/24/18.
 */

public class WeatherInfoPagerAdapter extends FragmentPagerAdapter implements Observer {

    private DayWeatherInfo[] dayWeatherInfo;

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public void setDayWeatherInfo(DayWeatherInfo[] dayWeatherInfo) {
        this.dayWeatherInfo = dayWeatherInfo;
    }


    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public WeatherInfoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        WeatherInformationFragment fragment = new WeatherInformationFragment();
        Bundle args = new Bundle();

        // Our object is just an integer :-P
        args.putSerializable("day_weather", dayWeatherInfo[position == 0 ? 0 : 3]);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return  mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
