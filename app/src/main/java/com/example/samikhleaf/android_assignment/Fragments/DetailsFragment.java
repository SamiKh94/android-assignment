package com.example.samikhleaf.android_assignment.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samikhleaf.android_assignment.DataModels.CountriesResponseModel;
import com.example.samikhleaf.android_assignment.Observers.CityDataObserver;
import com.example.samikhleaf.android_assignment.R;
import com.example.samikhleaf.android_assignment.Utils.UIUtil;

import java.util.Observable;
import java.util.Observer;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsFragment extends Fragment implements Observer {

    CircleImageView flag;
    TextView name, region, population, capital;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CityDataObserver.getInstance().addObserver(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        CityDataObserver.getInstance().deleteObserver(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragement_country_details, container, false);
        name = rootView.findViewById(R.id.name);
        population = rootView.findViewById(R.id.population);
        region = rootView.findViewById(R.id.region);
        capital = rootView.findViewById(R.id.capital);
        flag = rootView.findViewById(R.id.flag);
        return rootView;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof CityDataObserver) {
            CountriesResponseModel model = (CountriesResponseModel) arg;
            updateDetails(model);
        }
    }

    private void updateDetails(CountriesResponseModel model) {
        name.setText(model.getCountryName());
        region.setText(model.getRegionName());
//        population.setText(model.getPopulation());
        capital.setText(model.getCapital());
        UIUtil.loadImageFromURL(model.getCountryCode(), getContext(), flag);
    }
}
