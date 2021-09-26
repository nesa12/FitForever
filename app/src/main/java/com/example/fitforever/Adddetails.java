package com.example.fitforever;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Adddetails extends AppCompatActivity {

    EditText day1, txtlist, time7;
    Button add;

    public boolean validation(){
        String Day = day1.getText().toString();
        if(Day.isEmpty()){
            day1.setError("Field can't be Empty");
            return false;
        }else {
            day1.setError(null);
            return true;
        }

    }
    public boolean validation1(){
        String Exercise_list = txtlist.getText().toString();
        if(Exercise_list.isEmpty()){
            txtlist.setError("Field can't be Empty");
            return false;
        }else {
            txtlist.setError(null);
            return true;
        }
    }

    public boolean validation2(){
        String Time_Period = time7.getText().toString();
        if(Time_Period.isEmpty()){
            time7.setError("Field can't be Empty");
            return false;
        }else {
            time7.setError(null);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddetails);

        day1 = findViewById(R.id.day1);
        txtlist = findViewById(R.id.txtlist);
        time7 = findViewById(R.id.time7);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
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

                TimetableDBHelper myDB = new TimetableDBHelper(Adddetails.this);
                myDB.insertData(day1.getText().toString().trim(), txtlist.getText().toString().trim(), Integer.valueOf(time7.getText().toString().trim()));

            }
        });

    }
}