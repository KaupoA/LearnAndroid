package com.example.peatee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<Peatee> peateeGang = new ArrayList<>();
    List<String> peateeNames = new ArrayList<>();
    ListView nameListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peateeGang.add(new Peatee(R.drawable.poksikinnas, "Siim Poks", 28, "Mazda MX-5", "Mercedes-Benz"));
        peateeGang.add(new Peatee(R.drawable.kaupo, "Kaupo Aun", 28, "BMW E34", "Toyota Land Cruiser 95"));
        peateeGang.add(new Peatee(R.drawable.ookull, "Gustav Kull", 25, "Mitsubishi Lancer Ralliart", "Subaru Forrester"));

        for (Peatee peatee : peateeGang) {
            peateeNames.add(peatee.getPeateeName());
        }

        for (String name : peateeNames) {
            Log.d("Peateename", name);
        }

        nameListView = findViewById(R.id.nameListView);

        ArrayAdapter<String> peateeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, peateeNames);
        nameListView.setAdapter(peateeAdapter);

        nameListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent moveToDetailIntent = new Intent(getApplicationContext(), PeateeDetailActivity.class);
        moveToDetailIntent.putExtra("peatee", peateeGang.get(position));
        startActivity(moveToDetailIntent);
    }
}

