package br.com.agriconnected.agrispeed.presenter;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import br.com.agriconnected.agrispeed.R;
import br.com.agriconnected.agrispeed.model.GeoData;
import de.nitri.gauge.Gauge;

public class Speed implements LocationListener {
    private final Activity activity;

    private final RadioButton rbSpeedAuto;
    private final RadioButton rbSpeedManual;
    private final Gauge gauge;
    private final TextView tvSpeed;

    private final GeoData geoData;

    public Speed(Activity activity) {
        this.activity = activity;

        rbSpeedAuto = this.activity.findViewById(R.id.rbSpeedAuto);
        rbSpeedManual = this.activity.findViewById(R.id.rbSpeedManual);
        tvSpeed = this.activity.findViewById(R.id.tvSpeed);
        gauge = this.activity.findViewById(R.id.gauge);

        geoData = new GeoData();
    }

    @Override
    public void onLocationChanged(Location location) {
        double speed = 0D;

        geoData.updateData(location);

        if (rbSpeedAuto.isChecked()) {
            speed = geoData.getSpeedAuto();
        }
        else if (rbSpeedManual.isChecked()) {
            speed = geoData.getSpeedManual();
        }
        else {
            Toast.makeText(activity, this.activity.getString(R.string.erro_desconhecido), Toast.LENGTH_SHORT).show();
        }

        tvSpeed.setText(activity.getString(R.string.velocidade, speed));
        gauge.moveToValue((float) speed);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

    @Override
    public void onProviderEnabled(String provider) { }

    @Override
    public void onProviderDisabled(String provider) { }
}