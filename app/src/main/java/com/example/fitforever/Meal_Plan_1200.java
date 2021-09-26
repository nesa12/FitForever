package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Meal_Plan_1200 extends AppCompatActivity {

    Button button,button2,button3,button4,button5;
    ImageButton imageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan_1200);

        button = findViewById(R.id.hmp1);
        imageButton3=findViewById(R.id.MimageButton3);
        button2=findViewById(R.id.hmp2);
        button3=findViewById(R.id.hmp3);
        button4=findViewById(R.id.hmp4);
        button5=findViewById(R.id.hmp5);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Menu2_1200.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Menu1_1200.class);
                startActivity(intent);
            }
        });


        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),mymealplan.class);
                startActivity(intent2);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),Menu3_1200.class);
                startActivity(intent2);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),Menu4_1200.class);
                startActivity(intent2);
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),Menu5_1200.class);
                startActivity(intent2);
            }
        });

    }
}