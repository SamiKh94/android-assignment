package com.example.samikhleaf.android_assignment.VH;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.samikhleaf.android_assignment.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by samikhleaf on 1/24/18.
 */

public class CountryItemVH extends RecyclerView.ViewHolder {

    public CircleImageView flag;
    public TextView country;
    public TextView region;

    public CountryItemVH(View itemView) {
        super(itemView);

        flag = itemView.findViewById(R.id.country_flag);
        country = itemView.findViewById(R.id.country_name);
        region = itemView.findViewById(R.id.region_name);
    }
}
