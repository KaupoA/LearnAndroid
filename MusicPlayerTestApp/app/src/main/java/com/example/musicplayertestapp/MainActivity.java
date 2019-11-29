package com.example.musicplayertestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private Button playButton, pauseButton, forwardButton, rewindButton;
    private SeekBar seekbar;
    private MediaPlayer mplayer;

    private double startTime = 0;
    private double finalTime = 0;
    private int forwardTime = 5000;
    private int rewindTime = 5000;

    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        forwardButton = findViewById(R.id.forwardyButton);
        rewindButton = findViewById(R.id.rewindButton);
        seekbar = findViewById(R.id.seekBar);
        mplayer = MediaPlayer.create(this, R.raw.bensounddubstep);

        mHandler = new Handler();

        // Disable pause button
        pauseButton.setEnabled(false);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mplayer.start();

                finalTime = mplayer.getDuration();
                startTime = mplayer.getCurrentPosition();

                initializeSeekBar();
                playButton.setEnabled(false);
                pauseButton.setEnabled(true);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mplayer.pause();
                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if ((temp + forwardTime) <= finalTime) {
                    startTime = startTime + forwardTime;
                    mplayer.seekTo((int)startTime);
                }
            }
        });

        rewindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if ((temp - rewindTime) > 0) {
                    startTime = startTime - rewindTime;
                    mplayer.seekTo((int)startTime);
                }
            }
        });

        /**
         * seekBar SeekBar : The SeekBar whose progress has changed
         * int progress : The current progress level. This will be in the range min...max
         *                where min and max were set by setMin(int) and setMax(int) respectively.
         *                Default value for min is 0 and max is 100.
         * boolean fromUser : True if the progress was initiated by the user.
         */
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mplayer != null && fromUser) {
                    mplayer.seekTo(progress * 100);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initializeSeekBar() {
        seekbar.setMax(mplayer.getDuration() / 100);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                int currentPosition = mplayer.getCurrentPosition() / 100;
                seekbar.setProgress(currentPosition);
                mHandler.postDelayed(mRunnable, 100);
            }
        };
        mHandler.postDelayed(mRunnable, 100);
    }

}
