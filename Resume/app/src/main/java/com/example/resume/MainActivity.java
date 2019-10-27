package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button workHistoryButton;
    Button educationButton;
    Button callButton;
    Button emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workHistoryButton = findViewById(R.id.workHistoryButton);
        educationButton = findViewById(R.id.educationButton);
        callButton = findViewById(R.id.callButton);
        emailButton = findViewById(R.id.emailButton);

        workHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToTheOtherActivity = new Intent(getApplicationContext(), WorkHistoryActivity.class);
                startActivity(goToTheOtherActivity);

            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri myPhoneNumber = Uri.parse("tel: +372 53426789");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, myPhoneNumber);
                startActivity(callIntent);

            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"kaupo.aun@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Kaupo's Resume");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "This is so cool resume!");
                startActivity(emailIntent);

            }
        });

        educationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent educationActivity = new Intent(getApplicationContext(), EducationActivity.class);
                startActivity(educationActivity);

            }
        });

    }
}
