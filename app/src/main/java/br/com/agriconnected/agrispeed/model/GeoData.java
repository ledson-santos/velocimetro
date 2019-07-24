package br.com.agriconnected.agrispeed.model;

import android.location.Location;

public class GeoData {
    private double latitudeStart;
    private double longitudeStart;
    private double latitudeEnd;
    private double longitudeEnd;
    private long timeStart;
    private long timeEnd;

    private double speedAuto;
    private double speedManual;

    public GeoData() {
        latitudeStart = 0;
        longitudeStart = 0;
        latitudeEnd = 0;
        longitudeEnd = 0;
        timeStart = 0L;
        timeEnd = 0L;
        speedAuto = 0D;
        speedManual = 0D;
    }

    public void updateData(Location location) {
        latitudeStart = latitudeEnd;
        latitudeEnd = location.getLatitude();
        longitudeStart = longitudeEnd;
        longitudeEnd = location.getLongitude();
        timeStart = timeEnd;
        timeEnd = System.currentTimeMillis();

        speedAuto = location.getSpeed() * 3.6F;
        speedManual = calculateSpeed();
    }

    private double calculateSpeed() {
        float[] result = new float[2];
        Location.distanceBetween(latitudeStart, longitudeStart, latitudeEnd, longitudeEnd, result);

        double time = (timeEnd - timeStart) / 1000D;
        double distance = (double) result[0];

        return ((distance/time) * 3.6D);
    }

    public double getSpeedAuto() {
        return speedAuto;
    }

    public double getSpeedManual() {
        return speedManual;
    }
}
