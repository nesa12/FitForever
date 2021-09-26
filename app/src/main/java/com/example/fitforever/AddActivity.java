package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.allyants.notifyme.NotifyMe;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    Calendar now = Calendar.getInstance();
    TimePickerDialog tpd;
    DatePickerDialog dpd;

    EditText name_input,time_input;
    Button add_button;
    ImageButton home;

    //validation_Reminder
    public boolean validateReminderName(){
        String ReminderName  = name_input.getText().toString();
        if(ReminderName.isEmpty()){
            name_input.setError("Please give a name for the Reminder!");
            return false;
        }else{
            name_input.setError(null);
            return true;
        }
    }

    public boolean validateReminderTime(){
        String ReminderTime  = time_input.getText().toString();
        if(ReminderTime.isEmpty()){
            time_input.setError("Please give a time for the Reminder!");
            return false;
        }else{
            time_input.setError(null);
            return true;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        Button btnNotify = findViewById(R.id.btnNotify);
        dpd = DatePickerDialog.newInstance(
                AddActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        tpd = TimePickerDialog.newInstance(
                AddActivity.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                false
        );

        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dpd.show(getFragmentManager(), "DatepickerDialog");
            }
        });

        home = findViewById(R.id.imageButton6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });

        name_input = findViewById(R.id.reminderName);
        time_input = findViewById(R.id.reminderTime);
        add_button = findViewById(R.id.add_button);

        /*backArr = (ImageButton) findViewById(R.id.BackArr);
        backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backToReminder(); }
        });*/

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateReminderName()){
                    return;
                }

                if (!validateReminderTime()){
                    return;
                }


                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addReminder(name_input.getText().toString().trim(), time_input.getText().toString().trim());
            }
        });

    }

    /*public  void backToReminder(){
        Intent in = new Intent(AddActivity.this,SetReminder.class);
        startActivity(in);
    }*/

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        now.set(Calendar.YEAR,year);
        now.set(Calendar.MONTH,monthOfYear);
        now.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        now.set(Calendar.HOUR_OF_DAY, hourOfDay);
        now.set(Calendar.MINUTE, minute);
        now.set(Calendar.SECOND, second);

        NotifyMe notifyMe = new NotifyMe.Builder(getApplicationContext())
                .title(name_input.getText().toString())
                .color(255,0,0,255)
                .led_color(255,255,255,255)
                .time(now)
                .addAction(new Intent(), "Snooze", false)
                .key("test")
                .addAction(new Intent(), "Dismiss", true, false)
                .addAction(new Intent(), "Done")
                .large_icon(R.mipmap.ic_launcher_round)
                .build();
    }

        public void backToHome () {
            Intent in = new Intent(AddActivity.this, WelcomePage.class);
            startActivity(in);
        }
    }

