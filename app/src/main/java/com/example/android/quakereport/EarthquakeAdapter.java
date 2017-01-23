package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Navya's PC on 1/22/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(currentEarthquake.getmMagnitude());

        String location = currentEarthquake.getmLocation();
        String LOCATION_SEPARATOR = " of ";
        String locationOffset;
        String primaryLocation;

        if (location.contains(LOCATION_SEPARATOR)) {
            String[] parts = location.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = location;
        }

        TextView offsetlocationView = (TextView) listItemView.findViewById(R.id.offsetlocation);
        offsetlocationView.setText(locationOffset);

        TextView primarylocationView = (TextView) listItemView.findViewById(R.id.primarylocation);
        primarylocationView.setText(primaryLocation);


        Date dateObject = new Date(currentEarthquake.getmTimeInMilliSeconds());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    public String formatDate(Date dateObject){
        SimpleDateFormat dateformat = new SimpleDateFormat("LLL dd, yyyy");
        return  dateformat.format(dateObject);
    }

    public String formatTime(Date dateObject){
        SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
        return  timeformat.format(dateObject);
    }

}
