package br.com.agriconnected.agrispeed.presenter;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;

import br.com.agriconnected.agrispeed.R;
import br.com.agriconnected.agrispeed.model.GeoData;

public class Speed implements LocationListener {
    private final Activity activity;
    private final TextView tvSpeedAuto;
    private final TextView tvSpeedManual;

    private final GeoData geoData;

    public Speed(Activity activity) {
        this.activity = activity;
        tvSpeedAuto = this.activity.findViewById(R.id.tvSpeedAuto);
        tvSpeedManual = this.activity.findViewById(R.id.tvSpeedManual);

        geoData = new GeoData();
    }

    @Override
    public void onLocationChanged(Location location) {
        geoData.updateData(location);

        tvSpeedAuto.setText(activity.getString(R.string.velocidade, geoData.getSpeedAuto()));
        tvSpeedManual.setText(activity.getString(R.string.velocidade, geoData.getSpeedManual()));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

    @Override
    public void onProviderEnabled(String provider) { }

    @Override
    public void onProviderDisabled(String provider) { }
}