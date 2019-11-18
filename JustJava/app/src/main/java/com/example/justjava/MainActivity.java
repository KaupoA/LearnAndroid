package com.example.justjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
        } else {
            Toast.makeText(this,
                    "We don't want your coffee!",
                    Toast.LENGTH_SHORT).show();
        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        createOrderSummary();
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Create summary of the order.
     */
    private void createOrderSummary() {
        String orderSummary = "Name: Pentanool" +
                "\nQuantity: " + quantity +
                "\nTotal: " + calculatePrice() + "€" +
                "\nThank you!";
        displayMessage(orderSummary);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */

    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.orderSummaryTextView);
        orderSummaryTextView.setText(message);
    }
}
