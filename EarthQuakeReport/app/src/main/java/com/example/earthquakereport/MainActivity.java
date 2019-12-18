package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QuakeReportAdapter mAdapter;
    public static final String LOG_TAG = MainActivity.class.getName();
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EarthquakeASyncTask task = new EarthquakeASyncTask();
        task.execute(USGS_REQUEST_URL);

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
    }

    private class EarthquakeASyncTask extends AsyncTask<String, Void, List<QuakeReport>> {
        @Override
        protected List<QuakeReport> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            return QueryUtils.fetchEarthquakeData(urls[0]);
        }

        @Override
        protected void onPostExecute(List<QuakeReport> quakeReports) {
            // Clear the adapter of previous data.
            mAdapter.clear();

            // If there is a valid list on {@QuakeReport}, then add them to the adapters
            // quakeReports set. This will trigger the ListView to update.
            if (quakeReports != null && !quakeReports.isEmpty()) {
                mAdapter.addAll(quakeReports);
            }
        }
    }
}
