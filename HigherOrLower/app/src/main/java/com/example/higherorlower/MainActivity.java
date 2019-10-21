package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random r = new Random();

    int randomNumber = r.nextInt(20) + 1;
    // 20 max and 1 min + means it's 1 - 20 without +1 it's 0 - 19

    public void makeToast(String string) {

        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }

    public void guessClick (View view) {

        EditText guessNumberEditText = (EditText) findViewById(R.id.guessNumberEditText);

        int numberInt = Integer.parseInt(guessNumberEditText.getText().toString());

        if (numberInt > randomNumber) {

            makeToast("Lower");

        } else if (numberInt < randomNumber){

            makeToast("Higher");

        } else {

            makeToast("That's right! Try again!");

            randomNumber = r.nextInt(20) + 1;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
