package com.example.textfielddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

        public void loginButton(View view) {

            EditText usernameText = (EditText) findViewById(R.id.usernameText);
            EditText passwordText = (EditText) findViewById(R.id.passwordText);

            Log.i("Username", usernameText.getText().toString());
            Log.i("Password", passwordText.getText().toString());

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
