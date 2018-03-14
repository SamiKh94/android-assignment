package com.example.samikhleaf.android_assignment.Utils;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.samikhleaf.android_assignment.Constants;
import com.example.samikhleaf.android_assignment.Fragments.DetailsFragment;
import com.example.samikhleaf.android_assignment.Fragments.MainWeatherInformationFragment;
import com.example.samikhleaf.android_assignment.R;

public class UIUtil {

    public static void loadImageFromURL(String countryCode, Context context, ImageView image) {
        String url = String.format(Constants.countriesFlagsApiUrl, countryCode);
        Glide.with(context)
                .load(url)
                .into(image);
    }

    public static void updateFragments(FragmentManager supportFragmentManager) {
        DetailsFragment mDetailsFragment = new DetailsFragment();
        MainWeatherInformationFragment mWeatherInfoFragm = new MainWeatherInformationFragment();
        FragmentTransaction transaction =
                supportFragmentManager.beginTransaction();
        transaction.replace(R.id.country_details, mDetailsFragment);
        transaction.replace(R.id.weather_details, mWeatherInfoFragm);
        transaction.commit();
    }
}
