package com.example.android.quakereport;

/**
 * Created by Navya's PC on 1/22/2017.
 */

public class Earthquake {

    private String mMagnitude;
    private String mLocation;
    private long mTimeInMilliSeconds;

    public  Earthquake(String magnitude, String location, long timeInMilliSeconds){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliSeconds = timeInMilliSeconds;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(String mMagnitude) {
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
}
