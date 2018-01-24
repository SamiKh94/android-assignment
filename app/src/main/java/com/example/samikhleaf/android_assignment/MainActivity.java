package com.example.samikhleaf.android_assignment;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.example.samikhleaf.android_assignment.Adapters.CountriesAdapter;
import com.example.samikhleaf.android_assignment.DataModels.CountriesResponseModel;
import com.example.samikhleaf.android_assignment.Managers.RetrofitManager;
import com.example.samikhleaf.android_assignment.Observers.CityDataObserver;
import com.example.samikhleaf.android_assignment.Utils.UIUtil;
import com.google.gson.Gson;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    DrawerLayout androidDrawerLayout;
    RecyclerView menuList;
    CountriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountriesList();

        menuList = findViewById(R.id.menu_list);

        androidDrawerLayout = findViewById(R.id.drawer_layout);

        initFragments();
    }


    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        CityDataObserver.getInstance().addObserver(this);

    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        CityDataObserver.getInstance().deleteObserver(this);
    }

    private void initFragments() {

        UIUtil.updateFragments(getSupportFragmentManager());
    }

    public void getCountriesList() {

        RetrofitManager.getInstance().getCountriesList((isSuccess, result) -> {

            if (isSuccess && result != null) {

                Log.d("CountriesResult", new Gson().toJson(result));

                adapter = new CountriesAdapter((List<CountriesResponseModel>) result);
                menuList.setHasFixedSize(true);
                menuList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                menuList.setAdapter(adapter);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof CityDataObserver) {
            androidDrawerLayout.closeDrawer(Gravity.LEFT, true);
            findViewById(R.id.fragments_container).setVisibility(View.VISIBLE);
        }
    }
}

