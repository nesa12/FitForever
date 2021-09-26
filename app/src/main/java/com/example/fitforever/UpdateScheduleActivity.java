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

public class UpdateScheduleActivity extends AppCompatActivity {
    Spinner reps_count,sets_count;
    Button update_btn,delete_btn;
    TextView workout_name,workout_id;
    String id;
    Schedule schedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_schedule);

        sets_count = findViewById(R.id.sets_count);
        reps_count = findViewById(R.id.reps_count);
        workout_name = findViewById(R.id.workout_name);
        workout_id = findViewById(R.id.workout_id);
        update_btn = findViewById(R.id.update);
        delete_btn = findViewById(R.id.delete);

        Intent intent = getIntent();
        id = String.valueOf(intent.getIntExtra("id",0));

        WorkoutDBHelper helper = new WorkoutDBHelper(this);
        schedule = helper.getSchedule(id);
        workout_name.setText(schedule.getWorkout_name());
        workout_id.setText(schedule.getWorkout_id());


        String[] reps = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
        String[] sets = new String[]{"1", "2", "3"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, reps);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sets);

        reps_count.setAdapter(adapter1);
        sets_count.setAdapter(adapter2);

        reps_count.setSelection(Integer.parseInt(schedule.getReps())-1);
        sets_count.setSelection(Integer.parseInt(schedule.getSets())-1);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schedule.setReps(reps_count.getSelectedItem().toString());
                schedule.setSets(sets_count.getSelectedItem().toString());
                if(helper.updateSchedule(schedule)){
                    Toast.makeText(UpdateScheduleActivity.this,"Successfully Updated",Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }else{
                    Toast.makeText(UpdateScheduleActivity.this,"Something wrong happened",Toast.LENGTH_SHORT).show();
                }
            }
        });
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(helper.deleteSchedule(String.valueOf(schedule.getId()))){
                    Toast.makeText(UpdateScheduleActivity.this,"Successfully Deleted",Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }else{
                    Toast.makeText(UpdateScheduleActivity.this,"Something wrong happened",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}