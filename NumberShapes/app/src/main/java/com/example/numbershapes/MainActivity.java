package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void askShapeButton(View view) {

        EditText numberEditText = (EditText) findViewById(R.id.numberEditText);

        Toast.makeText(this, numberEditText.getText().toString(), Toast.LENGTH_SHORT).show();

    }

    public

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
