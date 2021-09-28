package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitforever.DB.WorkoutDBHelper;
import com.example.fitforever.Model.Schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity {

    Spinner reps_count,sets_count;
    Button add_btn;
    TextView workout_name;
    String id,name,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        sets_count = findViewById(R.id.sets_count);
        reps_count = findViewById(R.id.reps_count);
        workout_name = findViewById(R.id.workout_name);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        id = String.valueOf(intent.getIntExtra("id",0));
        type = intent.getStringExtra("type");

        workout_name.setText(name);

        add_btn = findViewById(R.id.add);
        String[] reps = new String[]{"Select the Reps Count","1","2","3","4","5","6","7","8","9","10","11","12"};
        String[] sets = new String[]{"Select the Sets Count","1", "2", "3"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, reps);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sets);

        reps_count.setAdapter(adapter1);
        sets_count.setAdapter(adapter2);


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(reps_count.getSelectedItemPosition() == 0){
                    Toast.makeText(ScheduleActivity.this,"Please Select Reps Count",Toast.LENGTH_SHORT).show();
                }else if(sets_count.getSelectedItemPosition() == 0){
                    Toast.makeText(ScheduleActivity.this,"Please Select Sets Count",Toast.LENGTH_SHORT).show();
                }else{
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    String current_date = dateFormat.format(date);
                    Schedule schedule = new Schedule();
                    schedule.setWorkout_id(id);
                    schedule.setWorkout_name(name);
                    schedule.setReps(reps_count.getSelectedItem().toString());
                    schedule.setSets(sets_count.getSelectedItem().toString());
                    schedule.setType(type);
                    schedule.setDate(current_date);

                    WorkoutDBHelper helper = new WorkoutDBHelper(ScheduleActivity.this);
                    if(helper.add_schedule(schedule)){
                        Toast.makeText(ScheduleActivity.this,"Successfully added",Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }else{
                        Toast.makeText(ScheduleActivity.this,"Something wrong happened",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}