package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RateUs extends AppCompatActivity {
    Button button;
    RatingBar ratingStars;
    ImageButton home;
    //ImageButton backArr;

    float myRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        /*backArr = (ImageButton) findViewById(R.id.BackArr);
        backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backToMyProfile(); }
        });*/

        button = findViewById(R.id.btnRate);
        ratingStars = findViewById(R.id.ratingBar);

        //rating stars
        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String message = null;

                myRating = ratingBar.getRating();

                switch (rating) {
                    case 1:
                        message = "Sorry to hear that! :(";
                        break;
                    case 2:
                        message = "You always accept suggestions!";
                        break;
                    case 3:
                        message = "Good enough!";
                        break;
                    case 4:
                        message = "Great! Thank you!";
                        break;
                    case 5:
                        message = "Awesome! FITNUTRO is the best!";
                        break;
                }

                Toast.makeText(RateUs.this,  message, Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RateUs.this, "Your Rating is: " + myRating, Toast.LENGTH_SHORT).show();
            }
        });

        home = findViewById(R.id.imageButton6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });
    }

    public void backToHome(){
        Intent in = new Intent(RateUs.this,WelcomePage.class);
        startActivity(in);
    }

    /*public  void backToMyProfile(){
        Intent in = new Intent(RateUs.this,MyProfile.class);
        startActivity(in);
    }*/
}
