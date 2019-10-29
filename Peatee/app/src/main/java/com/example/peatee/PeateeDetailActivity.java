package com.example.peatee;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.Bundle;
import android.widget.TextView;

public class PeateeDetailActivity extends AppCompatActivity {

    CircleImageView peateeProfileView;
    TextView nameTextView;
    TextView ageTextView;
    TextView carOneTextView;
    TextView carTwoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peatee_detail);

        peateeProfileView = findViewById(R.id.peateeProfileView);
        nameTextView = findViewById(R.id.nameTextView);
        ageTextView = findViewById(R.id.ageTextView);
        carOneTextView = findViewById(R.id.carOneTextView);
        carTwoTextView = findViewById(R.id.carTwoTextView);

        Peatee peatee = (Peatee) getIntent().getExtras().get("peatee");

        if (peatee != null) {
            peateeProfileView.setImageResource(peatee.getPeateeDrawableImage());
        }
        if (peatee != null) {
            nameTextView.setText(peatee.getPeateeName());
        }
        if (peatee != null) {
            ageTextView.setText(getString(R.string.age, peatee.getPeateeAge()));
        }
        if (peatee != null) {
            carOneTextView.setText(peatee.getPeateeCarOne());
        }
        if (peatee != null) {
            carTwoTextView.setText(peatee.getPeateeCarTwo());
        }

    }
}
