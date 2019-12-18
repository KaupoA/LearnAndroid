package com.example.earthquakereport;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class QuakeReportAdapter extends ArrayAdapter<QuakeReport> {

    private static final String LOG_TAG = QuakeReportAdapter.class.getSimpleName();
    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context    The current context. Used to inflate the layout file.
     * @param earthquake A List of QuakeReport objects to display in a list
     */

    QuakeReportAdapter(Activity context, List<QuakeReport> earthquake) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquake);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link QuakeReport} object located at this position in the list
        QuakeReport currentQuakeReport = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magnitudeText = listItemView.findViewById(R.id.magnitudeText);

        assert currentQuakeReport != null;
        String magnitude = formatMagnitude(currentQuakeReport.getMagnitude());
        // Get the magnitude from the current QuakeReport object and
        // set this text on the number TextView
        magnitudeText.setText(magnitude);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView nearLocationText = listItemView.findViewById(R.id.nearLocationText);

        String originalLocation = currentQuakeReport.getLocation();

        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        // Get the location from the current QuakeReport object and
        // set this text on the name TextView
        nearLocationText.setText(locationOffset);

        TextView locationText = listItemView.findViewById(R.id.locationText);
        locationText.setText(primaryLocation);

        Date dateobject = new Date(currentQuakeReport.getDate());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView dateText = listItemView.findViewById(R.id.dateText);
        // Get the date from the current QuakeReport object and
        // set this text on the name TextView
        String dateToDisplay = formatDate(dateobject);
        dateText.setText(dateToDisplay);

        Date timeObject = new Date(currentQuakeReport.getDate());

        TextView timeText = listItemView.findViewById(R.id.timeText);
        String timeToDisplay = formatTime(timeObject);
        timeText.setText(timeToDisplay);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuakeReport.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

    private String formatDate(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat =
                new SimpleDateFormat("EEE, d MMM yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date timeObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat =
                new SimpleDateFormat("HH:mm:ss z");
        return timeFormat.format(timeObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {
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
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
