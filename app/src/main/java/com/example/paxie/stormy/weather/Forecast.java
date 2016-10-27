package com.example.paxie.stormy.weather;

import com.example.paxie.stormy.R;

/**
 * Created by paxie on 9/1/15.
 */
public class Forecast {
    private Current mCurrent;
    private Hour[] mHourlyForecast;
    private Day[] mDailyForecast;

    public Current getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Current current) {
        mCurrent = current;
    }

    public Hour[] getHourlyForecast() {
        return mHourlyForecast;
    }

    public void setHourlyForecast(Hour[] hourlyForecast) {
        mHourlyForecast = hourlyForecast;
    }

    public Day[] getDailyForecast() {
        return mDailyForecast;
    }

    public void setDailyForecast(Day[] dailyForecast) {
        mDailyForecast = dailyForecast;
    }

    public static int getIconId(String iconString) {

        int iconID = R.drawable.clear_day;

        if (iconString.equals("clear-day")) {
            iconID = R.drawable.clear_day;
        }

        else if (iconString.equals("clear-night")) {
            iconID = R.drawable.clear_night;
        }
        else if (iconString.equals("rain")) {
            iconID = R.drawable.rain;
        }
        else if (iconString.equals("snow")) {
            iconID = R.drawable.snow;
        }
        else if (iconString.equals("sleet")) {
            iconID = R.drawable.sleet;
        }
        else if (iconString.equals("wind")) {
            iconID = R.drawable.wind;
        }
        else if (iconString.equals("fog")) {
            iconID = R.drawable.fog;
        }
        else if (iconString.equals("cloudy")) {
            iconID = R.drawable.cloudy;
        }
        else if (iconString.equals("partly-cloudy-day")) {
            iconID = R.drawable.partly_cloudy;
        }
        else if (iconString.equals("partly-cloudy-night")) {
            iconID = R.drawable.cloudy_night;
        }
        return iconID;

    }
}
