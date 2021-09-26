package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitforever.Adapter.ScheduleAdapter;
import com.example.fitforever.DB.WorkoutDBHelper;
import com.example.fitforever.Model.Schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DailyWorkoutsActivity extends AppCompatActivity {

    RecyclerView daily_list;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_workouts);
        daily_list = findViewById(R.id.daily_list);

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        getData();

    }

    private void getData() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String current_date = dateFormat.format(date);
        WorkoutDBHelper helper = new WorkoutDBHelper(this);
        ArrayList<Schedule> workouts = helper.getSchedules(current_date,type);
        System.out.println(workouts.toString());
        ScheduleAdapter myAdapter = new ScheduleAdapter(this,workouts);
        daily_list.setLayoutManager(new LinearLayoutManager(this));
        daily_list.setAdapter(myAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }
}