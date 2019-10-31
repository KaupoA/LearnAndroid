package com.example.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView counter;
    LinearLayout playAgainLayout;
    TextView winnerMessage;
    androidx.gridlayout.widget.GridLayout gridLayout;

    // 0 = red, 1 = yellow
    int activePlayer = 0;

    // Game is active or not

    boolean gameIsActive = true;

    // 2 means unplayed
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2},{3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    @SuppressLint("SetTextI18n")
    public void gameButton(View view) {

        counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameIsActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1100f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.red);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.yellow);

                activePlayer = 0;

            }

            counter.animate().translationYBy(1100f).setDuration(300);

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2){

                    // Someone has won

                    gameIsActive = false;

                    String winner = "Yellow";

                    if (gameState[winningPosition[0]] == 0) {

                        winner = "Red";

                    }

                    winnerMessage = findViewById(R.id.winnerMessage);

                    winnerMessage.setText( winner + " has won!");

                    playAgainLayout = findViewById(R.id.playAgainLayout);

                    playAgainLayout.setVisibility(View.VISIBLE);

                } else {

                    boolean gameIsOver = true;

                    for (int counterState : gameState) {

                        if (counterState == 2) gameIsOver = false;

                    }

                    if (gameIsOver) {

                        winnerMessage = findViewById(R.id.winnerMessage);

                        winnerMessage.setText("It's a tie");

                        playAgainLayout = findViewById(R.id.playAgainLayout);

                        playAgainLayout.setVisibility(View.VISIBLE);

                    }

                }

            }

        }

    }

    public void playAgain(View view) {

        gameIsActive = true;

        playAgainLayout = findViewById(R.id.playAgainLayout);

        playAgainLayout.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        for (int i = 0; i < gameState.length; i++) {

            gameState[i] = 2;

        }

        gridLayout = findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
