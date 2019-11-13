package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView counterTextView;
    MediaPlayer mplayer;
    Button controlButton;
    Boolean counterIsActive = false;
    CountDownTimer countDownTimer;

    public void resetTimer() {

        counterTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        countDownTimer.cancel();
        controlButton.setText("Go!");
        timerSeekBar.setEnabled(true);
        counterIsActive = false;

    }

    public void updateTimer(int secondsLeft) {

        // if secondsLeft / 60 isn't whole number, then (int) rounds it down
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String secondString = Integer.toString(seconds);

        if (seconds <= 9){

            secondString = "0" + secondString;

        }

        counterTextView.setText(minutes + ":" + secondString);

    }

    public void controlTimer(View view) {

        if (!counterIsActive) {

            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            controlButton.setText("Stop");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                    updateTimer((int) millisUntilFinished / 1000);

                }

                @Override
                public void onFinish() {

                    resetTimer();
                    mplayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mplayer.start();

                }
            }.start();

        } else {

            resetTimer();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timerSeekBar);
        counterTextView = findViewById(R.id.counterTextView);
        controlButton = findViewById(R.id.controlButton);

        // Maximum is 10 minutes and default is 30 seconds
        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTimer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
