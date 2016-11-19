package com.example.paxie.stormy.Adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paxie.stormy.R;
import com.example.paxie.stormy.weather.Day;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;

/**
 * Created by paxie on 9/17/15.
 */
public class DayAdapter extends BaseAdapter {



    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;

    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; //we aren't going to use this.  tag items for easy reference
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            //brand new
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);
            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder) convertView.getTag();

        }
        Day day = mDays[position];

        holder.iconImageView.setImageResource(day.getIconId());

        holder.temperatureLabel.setText(day.getTemperatureMax() + "");

        if (position == 0) {

            holder.dayLabel.setText("Today");
        }

        else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }



        return convertView;
    }

    private static class ViewHolder {
        ImageView iconImageView; //public by default
        TextView temperatureLabel;
        TextView dayLabel;
        TextView locationLabel;

    }



}
