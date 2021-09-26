package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitforever.DB.WorkoutDBHelper;


public class MainWorkoutActivity extends AppCompatActivity {

    TextView fullBody_btn,belly_btn,legs_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_workout);

        fullBody_btn = findViewById(R.id.fullbody_btn);
        belly_btn = findViewById(R.id.belly_btn);
        legs_btn = findViewById(R.id.legs_btn);

        WorkoutDBHelper helper = new WorkoutDBHelper(MainWorkoutActivity.this);
        fullBody_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWorkoutActivity.this, WorkoutListActivity.class);
                intent.putExtra("type","fullbody");
                startActivity(intent);
            }
        });
        belly_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWorkoutActivity.this, WorkoutListActivity.class);
                intent.putExtra("type","belly");
                startActivity(intent);
            }
        });
        legs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWorkoutActivity.this, WorkoutListActivity.class);
                intent.putExtra("type","legs");
                startActivity(intent);
            }
        });
    }


}