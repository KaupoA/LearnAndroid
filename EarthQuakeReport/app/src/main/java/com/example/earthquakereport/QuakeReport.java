package com.example.earthquakereport;

class QuakeReport {

    private double mMagnitude;
    private String mLocation;
    private long mDate;
    private String mUrl;

    QuakeReport(double magnitude, String location, long date, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mUrl = url;
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

    String getUrl() {
        return mUrl;
    }
}
