package com.example.fitforever;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    EditText name_input,time_input;
    Button update_button,delete_button;
    ImageButton home;
    //ImageButton backArr;

    String reminder_id, reminder_name, reminder_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_reminder);

        /*backArr = (ImageButton) findViewById(R.id.BackArr);
        backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backToReminder(); }
        });*/


        name_input = findViewById(R.id.reminderName2);
        time_input = findViewById(R.id.reminderTime2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                reminder_name = name_input.getText().toString().trim();
                reminder_time = time_input.getText().toString().trim();
                myDB.updateData(reminder_id, reminder_name, reminder_time);
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

        home = findViewById(R.id.imageButton6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });


    }

    public void backToHome(){
        Intent in = new Intent(UpdateActivity.this,WelcomePage.class);
        startActivity(in);
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("reminder_id") && getIntent().hasExtra("reminder_name") && getIntent().hasExtra("reminder_time")){
            //Getting Data from Intent
            reminder_id = getIntent().getStringExtra("reminder_id");
            reminder_name = getIntent().getStringExtra("reminder_name");
            reminder_time = getIntent().getStringExtra("reminder_time");

            //Setting Intent Data
            name_input.setText(reminder_name);
            time_input.setText(reminder_time);

        }else{
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + reminder_name + " ?");
        builder.setMessage("Are you sure you want to delete " + reminder_name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(reminder_id);
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

    /*public  void backToReminder(){
        Intent in = new Intent(UpdateActivity.this,SetReminder.class);
        startActivity(in);
    }*/
}
