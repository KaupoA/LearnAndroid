package com.example.earthquakereport;

class QuakeReport {

    private double mMagnitude;
    private String mLocation;
    private long mDate;

    QuakeReport(double magnitude, String location, long date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    double getMagnitude() {
        return mMagnitude;
    }

    String getLocation(){
        return mLocation;
    }

    long getDate() {
        return mDate;
    }
}
