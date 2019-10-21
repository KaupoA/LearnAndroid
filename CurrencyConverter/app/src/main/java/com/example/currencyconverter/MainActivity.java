package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public void convertButton(View view) {

        EditText numberEditText = (EditText) findViewById(R.id.numberEditText);

        Double d = Double.parseDouble(numberEditText.getText().toString());

        Double result = d * 1.116;

        DecimalFormat var = new DecimalFormat("0.00");

        Toast.makeText(this, var.format(result) + "$", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
