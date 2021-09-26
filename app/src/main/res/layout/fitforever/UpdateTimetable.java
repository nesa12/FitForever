package com.example.fitforever;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateTimetable extends AppCompatActivity {

    EditText day4, txtlist2, time3;
    Button update, Delete;

    String ID, Day, Exercise_list, Time_Period;

    public boolean validation(){
        String Day = day4.getText().toString();
        if(Day.isEmpty()){
            day4.setError("Field can't be Empty");
            return false;
        }else {
            day4.setError(null);
            return true;
        }

    }
    public boolean validation1(){
        String Exercise_list = txtlist2.getText().toString();
        if(Exercise_list.isEmpty()){
            txtlist2.setError("Field can't be Empty");
            return false;
        }else {
            txtlist2.setError(null);
            return true;
        }
    }

    public boolean validation2(){
        String Time_Period = time3.getText().toString();
        if(Time_Period.isEmpty()){
            time3.setError("Field can't be Empty");
            return false;
        }else {
            time3.setError(null);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatetimetable);


        day4 = findViewById(R.id.day4);
        txtlist2 = findViewById(R.id.txtlist2);
        time3 = findViewById(R.id.time3);
        update = findViewById(R.id.updatetable);
        Delete = findViewById(R.id.Delete);

        getAndSetIntentData();

        //set action bar title after getandsetIntenydata method
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setTitle(Day);
        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validation()){
                    return;
                }

                if(!validation1()){
                    return;
                }

                if(!validation2()){
                    return;
                }

                TimetableDBHelper myDB = new TimetableDBHelper(UpdateTimetable.this);
                Day = day4.getText().toString().trim();
                Exercise_list = txtlist2.getText().toString().trim();
                Time_Period = time3.getText().toString().trim();
                myDB.updateData(ID, Day, Exercise_list, Time_Period);

            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("ID") && getIntent().hasExtra("Day") && getIntent().hasExtra("Exercise_list")
                && getIntent().hasExtra("Time_Period")){

            //Getting data from intent
            ID = getIntent().getStringExtra("ID");
            Day = getIntent().getStringExtra("Day");
            Exercise_list = getIntent().getStringExtra("Exercise_list");
            Time_Period = getIntent().getStringExtra("Time_Period");

            //Setting intent data
            day4.setText(Day);
            txtlist2.setText(Exercise_list);
            time3.setText(Time_Period);

        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + Day + "?");
        builder.setMessage("Are you sure you want to delete " + Day + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TimetableDBHelper myDB = new TimetableDBHelper(UpdateTimetable.this);
                myDB.deleteOneRow(ID);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }



}