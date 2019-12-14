package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<QuakeReport> earthquake = QueryUtils.extractEarthquakes();

        QuakeReportAdapter adapter = new QuakeReportAdapter(this, earthquake);

        ListView earthquakeListView = findViewById(R.id.list);

        earthquakeListView.setAdapter(adapter);
    }
}
