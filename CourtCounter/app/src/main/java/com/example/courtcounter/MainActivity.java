package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.teamAScore);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointsTeamA(View view) {
        teamAScore = teamAScore + 3;
        displayForTeamA(teamAScore);
    }

    public void twoPointsTeamA(View view) {
        teamAScore = teamAScore + 2;
        displayForTeamA(teamAScore);
    }

    public void freeThrowTeamA(View view) {
        teamAScore = teamAScore + 1;
        displayForTeamA(teamAScore);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.teamBScore);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointsTeamB(View view) {
        teamBScore = teamBScore + 3;
        displayForTeamB(teamBScore);
    }

    public void twoPointsTeamB(View view) {
        teamBScore = teamBScore + 2;
        displayForTeamB(teamBScore);
    }

    public void freeThrowTeamB(View view) {
        teamBScore = teamBScore + 1;
        displayForTeamB(teamBScore);
    }

    /**
     * Reset scores.
     */

    public void reset(View view) {
        teamAScore = 0;
        teamBScore = 0;
        displayForTeamA(teamAScore);
        displayForTeamB(teamBScore);
    }

}
