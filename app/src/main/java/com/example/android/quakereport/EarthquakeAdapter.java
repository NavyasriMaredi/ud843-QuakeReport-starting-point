package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;

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

        TextView magView = (TextView) listItemView.findViewById(R.id.magnitude);
        String magToDisplay = formatMagnitude(currentEarthquake.getmMagnitude());
        magView.setText(magToDisplay);

        GradientDrawable magnitueCircle = (GradientDrawable) magView.getBackground();
        int magnituecolor = getMagnitudeColor(currentEarthquake.getmMagnitude());
        magnitueCircle.setColor(magnituecolor);

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
    private String formatMagnitude(double magnitude){
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return  decimalFormat.format(magnitude);
    }
    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }

}
