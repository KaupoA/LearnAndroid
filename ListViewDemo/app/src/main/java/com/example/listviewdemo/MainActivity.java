package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView with 4 friends
        myListView = findViewById(R.id.myListView);

        final ArrayList<String> friendNames = new ArrayList<>();
        friendNames.add("Gustav");
        friendNames.add("Siim");
        friendNames.add("Mikk");
        friendNames.add("Bratid");

        ArrayAdapter<String> nameAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, friendNames);
        myListView.setAdapter(nameAdapter);

        // When tapped, create Toast that says Hello, + name
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,
                        "Hello, " + friendNames.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
