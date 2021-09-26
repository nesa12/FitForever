package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BMIResult extends AppCompatActivity {
    //ImageButton backArr;
    //TextView bmiresult;
    //String bmiresultmsg;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i_result);

        /*bmiresult =findViewById(R.id.txtYourBMI);
        Intent i = getIntent();
        bmiresultmsg = i.getStringExtra("BMIResult");
        bmiresult.setText("YOUR BODY MASS INDEX IS: " +bmiresultmsg+ "!!!");*/

        /*backArr = (ImageButton) findViewById(R.id.BackArr);

        backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backTobmiCal(); }
        });*/

        home = findViewById(R.id.imageButton6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });

    }

    public void backToHome(){
        Intent in = new Intent(BMIResult.this,WelcomePage.class);
        startActivity(in);
    }

    /*public  void backTobmiCal(){
        Intent in = new Intent(BMIResult.this,BMICalculator.class);
        startActivity(in);
    }*/




}
