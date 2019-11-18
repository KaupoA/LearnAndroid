package com.example.menu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView menuItem1 = findViewById(R.id.menu_item_1);
        Log.i("Menu 1", menuItem1.getText().toString());

        // Find second menu item TextView and print the text to the logs
        TextView menuItem2 = findViewById(R.id.menu_item_2);
        Log.i("Menu 2", menuItem2.getText().toString());

        // Find third menu item TextView and print the text to the logs
        TextView menuItem3 = findViewById(R.id.menu_item_3);
        Log.i("Menu 3", menuItem3.getText().toString());

    }
}