package com.example.fitforever;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Timetable extends AppCompatActivity {
    RecyclerView recyclerView1;
    Button add3;

    TimetableDBHelper myDB;
    ArrayList<String> ID, Day, Exercise_list, Time_Period;
    TimetableCustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        recyclerView1 = findViewById(R.id.recycleView1);
        add3 = findViewById(R.id.add3);

        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Timetable.this, Adddetails.class);
                startActivity(intent);
            }
        });

        myDB = new TimetableDBHelper(Timetable.this);
        ID = new ArrayList<>();
        Day = new ArrayList<>();
        Exercise_list = new ArrayList<>();
        Time_Period = new ArrayList<>();

        //store data
        storeDataInArray();
        customAdapter = new TimetableCustomAdapter(Timetable.this,this, ID, Day, Exercise_list, Time_Period);
        recyclerView1.setAdapter(customAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(Timetable.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();

        }else{
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                Day.add(cursor.getString(1));
                Exercise_list.add(cursor.getString(2));
                Time_Period.add(cursor.getString(3));
            }
        }
    }



}