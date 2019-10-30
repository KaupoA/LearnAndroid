package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView kennyImageView;
//    ImageView cartmanImageView;

    public void fade(View view) {

        kennyImageView = findViewById(R.id.kennyImageView);

        kennyImageView.animate()
                .scaleX(1f)
                .scaleY(1f)
                .rotation(1800f)
                .setDuration(2000);

//        cartmanImageView = findViewById(R.id.cartmanImageView);


        /*if(kennyImageView.getAlpha() == 1f) {

            kennyImageView.animate().alpha(0f).setDuration(1000);
            cartmanImageView.animate().alpha(1f).setDuration(1000);

        }else {

            cartmanImageView.animate().alpha(0f).setDuration(1000);
            kennyImageView.animate().alpha(1f).setDuration(1000);

        }*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kennyImageView = findViewById(R.id.kennyImageView);

        kennyImageView.setScaleX(0.1f);
        kennyImageView.setScaleY(0.1f);

    }
}
