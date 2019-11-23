package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Make a new ArrayList named words
        ArrayList<String> words = new ArrayList<>();

        // Add items to the ArrayList
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        ArrayAdapter<String> wordsAdapter = new ArrayAdapter<>(this, R.layout.list_item, words);

        ListView numbersListView = findViewById(R.id.numbersListView);
        numbersListView.setAdapter(wordsAdapter);
    }
}
