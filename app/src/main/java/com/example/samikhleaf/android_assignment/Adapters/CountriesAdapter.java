package com.example.samikhleaf.android_assignment.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samikhleaf.android_assignment.DataModels.CountriesResponseModel;
import com.example.samikhleaf.android_assignment.DataModels.CountryWeatherResponseModel;
import com.example.samikhleaf.android_assignment.Managers.RetrofitManager;
import com.example.samikhleaf.android_assignment.Observers.CityDataObserver;
import com.example.samikhleaf.android_assignment.Observers.WeatherDataObserver;
import com.example.samikhleaf.android_assignment.R;
import com.example.samikhleaf.android_assignment.Utils.UIUtil;
import com.example.samikhleaf.android_assignment.VH.CountryItemVH;
import com.google.gson.Gson;

import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CountriesResponseModel> dataSet;

    public CountriesAdapter(List<CountriesResponseModel> data) {

        this.dataSet = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_item, parent, false);
        return new CountryItemVH(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CountryItemVH vh = (CountryItemVH) holder;
        vh.country.setText(dataSet.get(position).getCountryName());
        vh.region.setText(dataSet.get(position).getRegionName());
        UIUtil.loadImageFromURL(dataSet.get(position).getCountryCode(), vh.itemView.getContext(), vh.flag);
        vh.itemView.setOnClickListener(v -> getCountryData(dataSet.get(position).getLatlng()[0], dataSet.get(position).getLatlng()[1], position));
    }

    private void getCountryData(double lat, double lng, int position) {

        RetrofitManager.getInstance().getCountryWeather(lat, lng, (isSuccess, result) -> {
            Log.d("CountryWeather", new Gson().toJson(result));
            CityDataObserver.getInstance().setCityChanged(dataSet.get(position));
            WeatherDataObserver.getInstance().setCityChanged(((CountryWeatherResponseModel)result).getDayWeatherInfo());
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
