package com.example.fitforever;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MyProfile extends AppCompatActivity {
    Button updateWeightbtn;
    Button bmicalculatorbtn;
    Button calcalculatorbtn;
    Button reminderbtn;
    Button rateUsbtn;
    Button feedbackbtn;
    ImageButton home;
    //ImageButton backArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        /*backArr = (ImageButton) findViewById(R.id.BackArr);
        backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backToWelcomePage(); }
        });*/

        updateWeightbtn = (Button) findViewById(R.id.btnUpdateWeight);
        updateWeightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUpdateWeight();
            }
        });

        bmicalculatorbtn= (Button) findViewById(R.id.btnBMICalculator);
        bmicalculatorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBMICalculator();
            }
        });



        reminderbtn= (Button) findViewById(R.id.btnReminder);
        reminderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReminder();
            }
        });

        rateUsbtn= (Button) findViewById(R.id.btnRateus);
        rateUsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRateUs();
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

    /*public  void backToWelcomePage(){
        Intent in = new Intent(MyProfile.this,WelcomePage.class);
        startActivity(in);
    }*/

    public void backToHome(){
        Intent in = new Intent(MyProfile.this,WelcomePage.class);
        startActivity(in);
    }

    public void  openUpdateWeight(){
        Intent in = new Intent(MyProfile.this,UpdateWeight.class);
        startActivity(in);
    }

    public void  openBMICalculator(){
        Intent in = new Intent(MyProfile.this,BMICalculator.class);
        startActivity(in);
    }

    public void  openCalCalculator(){
 //       Intent in = new Intent(MyProfile.this,CalorieCalculator.class);
 //       startActivity(in);
    }

    public void  openReminder(){
       Intent in = new Intent(MyProfile.this,SetReminder.class);
       startActivity(in);
    }

    public void  openRateUs(){
        Intent in = new Intent(MyProfile.this,RateUs.class);
        startActivity(in);
    }

    public void openGmail(View view){
        startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:fitnutro@gmail.com")));
    }
}
