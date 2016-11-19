package com.example.paxie.stormy;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;


/**
 * Created by paxie on 10/27/16.
 */

public class GPS_Service extends Service {

    private LocationListener mListener;
    private LocationManager mManager;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Intent i = new Intent("location_update");
                i.putExtra("coordinates", location.getLatitude() + " " + location.getLatitude());
                i.putExtra("latitude", location.getLatitude());
                i.putExtra("longitude", location.getLongitude());
                sendBroadcast(i);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        };

        mManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

        //noinspection MissingPermission
        mManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 0, mListener);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mManager != null) {
            //noinspection MissingPermission
            mManager.removeUpdates(mListener);
        }
        }
    }


