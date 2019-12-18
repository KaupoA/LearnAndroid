package com.example.earthquakereport;

import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class EarthquakeLoader extends AsyncTaskLoader<List<QuakeReport>> {
    /** Tag for log messages. */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL. */
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();

    }

    /**
     * This is on a background thread.
     */
    @Nullable
    @Override
    public List<QuakeReport> loadInBackground() {
        // Don't perform the request if there are no URLs, or the first URL is null.
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<QuakeReport> earthqukes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthqukes;
    }
}
