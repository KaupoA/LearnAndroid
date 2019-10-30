package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numberEditText;

    public void makeToast(String string) {

        Toast.makeText(this, numberEditText.getText().toString() + string, Toast.LENGTH_SHORT).show();

    }

    public void askShapeButton(View view) {

        numberEditText = findViewById(R.id.numberEditText);

        int i = Integer.parseInt(numberEditText.getText().toString());


        if (Numbers.isSquare(i)) {

            if (Numbers.isTriangular(i)) {

                makeToast(" is a triangular and a square number.");

            } else {

                makeToast(" is a square number.");

            }

        } else {

            if (Numbers.isTriangular(i)) {

                makeToast(" is a triangular number.");

            } else {

                makeToast(" is not a triangular or a square number.");

            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}