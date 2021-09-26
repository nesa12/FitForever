package com.example.fitforever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WelcomeToTimetablePage extends AppCompatActivity {
    private Button button1, button2;
    private ImageButton imageButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcometotimetablepage);

        button1 = (Button) findViewById(R.id.tstartedbtn);
        button2 = (Button) findViewById(R.id.wcalbtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentimetable();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openwaterintakecalculator();
            }
        });

        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openwelcomepage();
            }
        });
    }

    public void opentimetable(){
        Intent intent = new Intent(this, Timetable.class);
        startActivity(intent);
    }
    public void openwaterintakecalculator(){
        Intent intent = new Intent (this, WaterIntakeCalculator.class);
        startActivity(intent);
    }
    public void openwelcomepage(){
        Intent intent = new Intent (this, WelcomePage.class);
        startActivity(intent);
    }
}