package com.example.toastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickmeButton(View view) {

        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);

        Toast.makeText(this, "Hi there, " + nameEditText.getText().toString(), Toast.LENGTH_SHORT).show();

        Log.i("Info", nameEditText.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
