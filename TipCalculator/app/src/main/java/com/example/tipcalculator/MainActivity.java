package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText amountEditText;
    EditText tipPrecentEditText;
    Button calculateButton;
    TextView tipTextView;
    TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = findViewById(R.id.amountEditText);
        tipPrecentEditText = findViewById(R.id.tipPrecentEditText);
        calculateButton = findViewById(R.id.calculateButton);
        tipTextView = findViewById(R.id.tipTextView);
        totalTextView = findViewById(R.id.totalTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get number from amountEditText

                double billAmount = Double.parseDouble(amountEditText.getText().toString());

                // Get number from tipPrecentEditText

                double tipPrecentage = Double.parseDouble(tipPrecentEditText.getText().toString());

                double tipToPrecentage = tipPrecentage / 100;

                // Calculate the tip and total

                double tipAmount = billAmount * tipToPrecentage;
                double totalAmount = billAmount + tipAmount;

                String tipDecimal = String.format(Locale.getDefault(), "%.2f", tipAmount);
                String totalDecimal = String.format(Locale.getDefault(), "%.2f", totalAmount);

                // Display tip and total

                tipTextView.setText("Tip - " + tipDecimal + "€");
                totalTextView.setText("Total - " + totalDecimal + "€");
            }
        });

    }

}
