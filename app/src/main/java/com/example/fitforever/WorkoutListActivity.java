package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitforever.Adapter.WorkoutAdapter;
import com.example.fitforever.Model.Workout;

import java.util.ArrayList;

public class WorkoutListActivity extends AppCompatActivity {

    ArrayList<Workout> workouts;
    RecyclerView workout_list;
    String type = "";
    Button view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);
        workout_list = findViewById(R.id.workout_list);
        view = findViewById(R.id.view_daily_workout);
        workouts = new ArrayList<>();

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        getData();

        WorkoutAdapter myAdapter = new WorkoutAdapter(this,workouts,type);
        workout_list.setLayoutManager(new LinearLayoutManager(this));
        workout_list.setAdapter(myAdapter);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutListActivity.this, DailyWorkoutsActivity.class);
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        if(type.equals("fullbody")){
            workouts.add(new Workout(1,"Push Ups","Have a strong grip on the floor. Make sure your neck and spine are aligned. Bring your hands towards your toes.",R.drawable.push_ups));
            workouts.add(new Workout(2,"Squat","Assume the squat stance. Screw your feet into the floor. Keep your chest up. Initiate the movement.",R.drawable.squat));
            workouts.add(new Workout(3,"Plank","Start with your body facing down on the floor and your toes curled under. Place your elbows directly underneath of your shoulders.",R.drawable.plank));
            workouts.add(new Workout(4,"Side Plank","Start in a traditional side plank position. Raise your top arm straight above you, or keep your top hand on your top hip.",R.drawable.side_plank));
            workouts.add(new Workout(5,"Lunge","Stand with feet hip-width apart. Take a large step forward with one leg. Keep the majority of your weight on your front foot.",R.drawable.lunge));
        }else if(type.equals("belly")){
            workouts.add(new Workout(6,"Plank","Start with your body facing down on the floor and your toes curled under. Place your elbows directly underneath of your shoulders.",R.drawable.plank));
            workouts.add(new Workout(7,"Crunch","Lie down on your back. Plant your feet on the floor, hip-width apart. Bend your knees and place your arms across your chest.",R.drawable.crunch));
            workouts.add(new Workout(8,"Hip lifts","Lie on back with both knees bent. Cross one ankle over the opposite knee. Move in and out of the stretch by rotating the hip in and out.",R.drawable.hip_lifts));
            workouts.add(new Workout(9,"Chair pose","Maintain a slight arch in your back. Squeeze your thighs as close together as possible. Bring your thighs as parallel to the floor as possible.",R.drawable.chair_pose));
            workouts.add(new Workout(10,"Flutter","Lie down on your back, facing up. Place both hands underneath your buttocks. Keep your lower back on the ground as you lift both legs up.",R.drawable.flutter));
        }
        else if(type.equals("legs")){
            workouts.add(new Workout(11,"Squat","Assume the squat stance. Screw your feet into the floor. Keep your chest up. Initiate the movement.",R.drawable.squat));
            workouts.add(new Workout(12,"Lunge","Stand with feet hip-width apart. Take a large step forward with one leg. Keep the majority of your weight on your front foot.",R.drawable.lunge));
            workouts.add(new Workout(13,"Leg lifts","Press lower back into the floor. While lowering legs, stop once you feel your back lifting off the floor.",R.drawable.leg_lifts));
            workouts.add(new Workout(14,"Chair pose","Maintain a slight arch in your back. Squeeze your thighs as close together as possible. Bring your thighs as parallel to the floor as possible.",R.drawable.chair_pose));
            workouts.add(new Workout(15,"Plank","Start with your body facing down on the floor and your toes curled under. Place your elbows directly underneath of your shoulders.",R.drawable.plank));
        }
    }
}