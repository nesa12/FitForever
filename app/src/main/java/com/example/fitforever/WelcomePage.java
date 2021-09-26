package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomePage extends AppCompatActivity {
    TextView txtMsg;
    String msg;
    Button MyProfilebtn, MealPlanbtn, Workoutbtn, TimeTablebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        MyProfilebtn = (Button) findViewById(R.id.myprofilebtn);
        MyProfilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("print_button");
                openMyProfile();
            }
        });

        MealPlanbtn = (Button) findViewById(R.id.mealplanbtn);
        MealPlanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMealPlan();
            }
        });

        Workoutbtn = (Button) findViewById(R.id.workoutbtn);
        Workoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkout();
            }
        });

        TimeTablebtn = (Button) findViewById(R.id.timetablebtn);
        TimeTablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openTimeTable();
                openTimeTable();
            }
        });


        txtMsg=findViewById(R.id.topBar1);
        Intent i = getIntent();
        msg = i.getStringExtra("USERNAME");
        txtMsg.setText("WELCOME " +msg.toString() + "!!!");

        Toast.makeText(this,"HELLO "+msg.toString(),Toast.LENGTH_LONG).show();

    }


    public void openTimeTable(){
//        Intent in = new Intent(WelcomePage.this,WelcomeToTimetablePage.class);
//        startActivity(in);
    }

//    public void  openMyProfile(){
//        Intent in = new Intent(WelcomePage.this,MyProfile.class);
//        startActivity(in);
//    }


    public void  openMyProfile(){
        Intent in = new Intent(WelcomePage.this,MyProfile.class);
       startActivity(in);
    }


    public void  openMealPlan(){
        Intent in = new Intent(WelcomePage.this,Meal_Plan_Main.class);
        startActivity(in);
    }

    public void  openWorkout(){
//        Intent in = new Intent(WelcomePage.this,MainWorkoutActivity.class);
//        startActivity(in);
    }

   /*public void  openTimeTable(){
        Intent in = new Intent(WelcomePage.this,WelcomeToTimetablePage.class);
        startActivity(in);
    }*/

}