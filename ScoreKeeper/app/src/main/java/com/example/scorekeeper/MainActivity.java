package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button firstTeamResetGoalsText;
    Button firstTeamResetFaultsText;
    Button secondTeamResetGoalsText;
    Button secondTeamResetFaultsText;
    Button enterTeamButton;
    Button resetEverything;
    EditText teamNameEdit;
    TextView firstTeamNameText;
    TextView secondTeamNameText;

    int firstTeamGoals = 0;
    int firstTeamFaults = 0;
    int secondTeamGoals = 0;
    int secondTeamFaults = 0;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTeamResetGoalsText = findViewById(R.id.firstTeamResetGoals);
        firstTeamResetFaultsText = findViewById(R.id.firstTeamResetFaults);
        secondTeamResetGoalsText = findViewById(R.id.secondTeamResetGoals);
        secondTeamResetFaultsText = findViewById(R.id.secondTeamResetFaults);
        enterTeamButton = findViewById(R.id.enterTeamButton);
        resetEverything = findViewById(R.id.resetEverything);
        teamNameEdit = findViewById(R.id.teamNameEdit);
        firstTeamNameText = findViewById(R.id.firstTeamNameText);
        secondTeamNameText = findViewById(R.id.secondTeamNameText);

    }

    public void displayFirstTeamGoals(int number) {
        TextView goals = findViewById(R.id.firstTeamGoals);
        goals.setText(String.valueOf(number));
    }

    public void displayFirstTeamFaults(int number) {
        TextView faults = findViewById(R.id.firstTeamFaults);
        faults.setText(String.valueOf(number));
    }

    public void firstGoals(View v) {
        firstTeamGoals = firstTeamGoals + 1;
        displayFirstTeamGoals(firstTeamGoals);
        if (firstTeamGoals > 1) {
            firstTeamResetGoalsText.setText("Reset goals");
        }
    }

    public void firstFaults(View v) {
        firstTeamFaults = firstTeamFaults + 1;
        displayFirstTeamFaults(firstTeamFaults);
        if (firstTeamFaults > 1) {
            firstTeamResetFaultsText.setText("Reset faults");
        }
    }

    public void firstResetGoals(View v) {
        firstTeamGoals = 0;
        displayFirstTeamGoals(firstTeamGoals);
        firstTeamResetGoalsText.setText("Reset goal");
    }

    public void firstResetFaults(View v) {
        firstTeamFaults = 0;
        displayFirstTeamFaults(firstTeamFaults);
        firstTeamResetFaultsText.setText("Reset fault");
    }


    public void displaySecondTeamGoals(int number) {
        TextView goals = findViewById(R.id.secondTeamGoals);
        goals.setText(String.valueOf(number));
    }

    public void displaySecondTeamFaults(int number) {
        TextView faults = findViewById(R.id.secondTeamFaults);
        faults.setText(String.valueOf(number));
    }

    public void secondGoals(View v) {
        secondTeamGoals = secondTeamGoals + 1;
        displaySecondTeamGoals(secondTeamGoals);
        if (secondTeamGoals > 1) {
            secondTeamResetGoalsText.setText("Reset goals");
        }
    }

    public void secondFaults(View v) {
        secondTeamFaults = secondTeamFaults + 1;
        displaySecondTeamFaults(secondTeamFaults);
        if (secondTeamFaults > 1) {
            secondTeamResetFaultsText.setText("Reset faults");
        }
    }

    public void secondResetGoals(View v) {
        secondTeamGoals = 0;
        displaySecondTeamGoals(secondTeamGoals);
        secondTeamResetGoalsText.setText("Reset goal");
    }

    public void secondResetFaults(View v) {
        secondTeamFaults = 0;
        displaySecondTeamFaults(secondTeamFaults);
        secondTeamResetFaultsText.setText("Reset fault");
    }

    public void enterTeamName(View v) {
            if (counter == 0) {
                firstTeamNameText.setText(teamNameEdit.getText());
                teamNameEdit.setText("");
                teamNameEdit.setHint("Second Team Name");
                counter = 1;
            } else {
                secondTeamNameText.setText(teamNameEdit.getText());
                teamNameEdit.setVisibility(View.INVISIBLE);
                enterTeamButton.setVisibility(View.INVISIBLE);
                resetEverything.setVisibility(View.VISIBLE);
            }
    }

    public void resetEverything(View v) {
        firstTeamGoals = 0;
        firstTeamFaults = 0;
        secondTeamGoals = 0;
        secondTeamFaults = 0;
        counter = 0;

        firstTeamNameText.setText("");
        firstTeamResetGoalsText.setText("Reset goal");
        firstTeamResetFaultsText.setText("Reset fault");

        secondTeamNameText.setText("");
        secondTeamResetGoalsText.setText("Reset goal");
        secondTeamResetFaultsText.setText("Reset fault");

        teamNameEdit.setVisibility(View.VISIBLE);
        enterTeamButton.setVisibility(View.VISIBLE);
        resetEverything.setVisibility(View.INVISIBLE);

    }
}
