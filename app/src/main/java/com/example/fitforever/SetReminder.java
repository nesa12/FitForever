package com.example.fitforever;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SetReminder extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton home;
    //ImageButton backArr;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> reminder_id,  reminder_name, reminder_time;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);

        /*backArr = (ImageButton) findViewById(R.id.BackArr);
        backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backToMyProfile(); }
        });*/

        home = findViewById(R.id.imageButton6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetReminder.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(SetReminder.this);
        reminder_id = new ArrayList<>();
        reminder_name = new ArrayList<>();
        reminder_time = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(SetReminder.this,this, reminder_id, reminder_name, reminder_time);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(SetReminder.this));

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                reminder_id.add(cursor.getString(0));
                reminder_name.add(cursor.getString(1));
                reminder_time.add(cursor.getString(2));

            }
        }
    }

    public void backToHome(){
        Intent in = new Intent(SetReminder.this,WelcomePage.class);
        startActivity(in);
    }

    /*public  void backToMyProfile(){
        Intent in = new Intent(SetReminder.this,MyProfile.class);
        startActivity(in);
    }*/

    /*public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.delete_all){
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
            MyDatabaseHelper myDB = new MyDatabaseHelper(this);
            myDB.deleteAllData();
        }
        return  super.onOptionsItemSelected(item);
    }*/

}
