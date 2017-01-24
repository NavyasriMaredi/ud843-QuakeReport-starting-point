package com.example.android.quakereport;

/**
 * Created by Navya's PC on 1/22/2017.
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliSeconds;
    private String mUrl;

    public  Earthquake(double magnitude, String location, long timeInMilliSeconds, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliSeconds = timeInMilliSeconds;
        mUrl = url;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public long getmTimeInMilliSeconds() {
        return mTimeInMilliSeconds;
    }

    public void setmTimeInMilliSeconds(long mTimeInMilliSeconds) {
        this.mTimeInMilliSeconds = mTimeInMilliSeconds;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
