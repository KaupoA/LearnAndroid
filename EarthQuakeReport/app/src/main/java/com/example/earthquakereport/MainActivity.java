package com.example.earthquakereport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<QuakeReport>>{

    public static final String LOG_TAG = MainActivity.class.getName();
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";
    private QuakeReportAdapter mAdapter;
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoaderManager loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);

        ListView earthquakeListView = findViewById(R.id.list);

        mAdapter = new QuakeReportAdapter(this, new ArrayList<QuakeReport>());

        earthquakeListView.setAdapter(mAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                QuakeReport currentQuakeReport = mAdapter.getItem(position);

                Intent i = new Intent(Intent.ACTION_VIEW);
                assert currentQuakeReport != null;
                i.setData(Uri.parse(currentQuakeReport.getUrl()));
                startActivity(i);
            }
        });

        mEmptyStateTextView = findViewById(R.id.emptyView);
        earthquakeListView.setEmptyView(mEmptyStateTextView);
    }

    @NonNull
    @Override
    public Loader onCreateLoader(int i, @Nullable Bundle bundle) {
        // Create a new loader for the given URL.
        return new EarthquakeLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<QuakeReport>> loader, List<QuakeReport> quakeReports) {
        // After loading is finished set the visibility for the progress bar to invisible.
        View loadingSpinner = findViewById(R.id.loadingSpinner);
        loadingSpinner.setVisibility(View.GONE);

        /*ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null ) {
        // State that there is no internet connection
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        } else if (networkInfo!=null && networkInfo.isAvailable()){
        // There is internet but list is still empty
            mEmptyStateTextView.setText(R.string.no_earthquakes);
        }
        // Clear the adapter of previous data.*/

        if (!isOnline()) {
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        } else {
            mEmptyStateTextView.setText(R.string.no_earthquakes);
        }

        mAdapter.clear();

        // If there is a valid list on {@QuakeReport}, then add them to the adapters
        // quakeReports set. This will trigger the ListView to update.
        if (quakeReports != null && !quakeReports.isEmpty()) {
            mAdapter.addAll(quakeReports);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }

    // Check internet connectivity.
    // Is that a valid solution?
    public boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        }
        catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }
}
