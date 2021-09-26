package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Categorized_Meal_Plan extends AppCompatActivity {

    Button button,button2,button3;
    ImageButton imageButton2,imageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorized_meal_plan);

        button = findViewById(R.id.Mbutton3);

        button3=findViewById(R.id.Mbutton2);
        imageButton2=findViewById(R.id.MimageButton3);
        imageButton3=findViewById(R.id.MimageButton6);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Meal_Plan_1200.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HealthyMealPlan.class);
                startActivity(intent);
            }
        });


        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),crud_main.class);
                startActivity(intent2);
            }
        });


//        imageButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2=new Intent(getApplicationContext(),WelcomePage.class);
//                startActivity(intent2);
//            }
//        });
    }
}