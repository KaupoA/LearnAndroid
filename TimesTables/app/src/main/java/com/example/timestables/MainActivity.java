package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView numbersListView;
    SeekBar numberSeekBar;

    public void generateTimesTable(int timesTable) {

        ArrayList<String> numbersList = new ArrayList<>();

        for(int i = 1; i <= 10; i++) {

            numbersList.add(Integer.toString(i * timesTable));

        }

        ArrayAdapter<String> numbersAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbersList);
        numbersListView.setAdapter(numbersAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersListView = findViewById(R.id.numbersListView);

        numberSeekBar = findViewById(R.id.numberSeekBar);

        numberSeekBar.setMax(20);

        numberSeekBar.setProgress(10);

        numberSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timesTable;

                if (progress < min) {

                    timesTable = min;
                    numberSeekBar.setProgress(min);

                } else {

                    timesTable = progress;

                }

                generateTimesTable(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(10);

    }
}
