package com.example.justjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

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

    /**
     * Increments and Decrements order quantity
     */
    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
        }else {
            Toast.makeText(this,
                    "You cannot order more than 100 coffees",
                    Toast.LENGTH_SHORT).show();
        }
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this,
                    "You cannot have less than 1 coffee",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Fint the user's name
        EditText nameEditText = findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString();

        // Figure out if the user wants whipped cream
        CheckBox whippedCreamCheckBox = findViewById(R.id.whippedCreamCheckBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out is the user wants chocolate
        CheckBox chocolateCheckBox = findViewById(R.id.chocolateCheckBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream
     * @param addChocolate is whether or not the user wants chocolate
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        // Price of 1 cup of coffee
        int pricePerCup = 5;

        // Add 1€ if the user wants whipped cream
        if (addWhippedCream) {
            pricePerCup = pricePerCup + 1;
        }

        // Add 2€ if the user wants chocolate
        if (addChocolate) {
            pricePerCup = pricePerCup + 2;
        }

        // Calculate the total orded price by multiplying by quantity
        return quantity * pricePerCup;
    }

    private String createOrderSummary(String name, int price,
                                      boolean addWhippedCream, boolean addChocolate) {
        return getString(R.string.order_summary_name, name) +
                "\n" + getString(R.string.add_whipped_cream) + addWhippedCream +
                "\n" + getString(R.string.add_chocolate) + addChocolate +
                "\n" + getString(R.string.quantity_order) + quantity +
                "\n" + getString(R.string.total) + NumberFormat.getCurrencyInstance().format(price) +
                "\n" + getString(R.string.thank_you);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + number);
    }
}
