package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UpdateWeight extends AppCompatActivity {
    ListView listView1;
    EditText etCurrentWeight, etGoalWeight;
    Button btnSave,btnUpdate;
    ImageButton backArr;
    ImageButton home;

    ArrayList<String> weight = new ArrayList<String>();
    ArrayAdapter myAdapter1;

    Integer indexVal;
    String item;

    //validation
    public boolean validateCurrentWeight(){
        String strCurrentWeight  = etCurrentWeight.getText().toString();
        if(strCurrentWeight.isEmpty()){
            etCurrentWeight.setError("Set your Current Weight!");
            return false;
        }else if(strCurrentWeight.length()>=4){
            etCurrentWeight.setError("Your  Current Weight should be a valid number!");
            etCurrentWeight.requestFocus();
            return false;
        }else{
            etCurrentWeight.setError(null);
            return true;
        }
    }

    public boolean validateGoalWeight(){
        String strGoalWeight  = etGoalWeight.getText().toString();
        if(strGoalWeight.isEmpty()){
            etGoalWeight.setError("Set your Goal Weight!");
            return false;
        }else if(strGoalWeight.length()>=4){
            etGoalWeight.setError("Your  Goal Weight should be a valid number!");
            etGoalWeight.requestFocus();
            return false;
        }else{
            etGoalWeight.setError(null);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_weight);

        listView1 = (ListView) findViewById(R.id.updateWeightList);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        etCurrentWeight = (EditText) findViewById(R.id.edtcurrentweight);
        etGoalWeight = (EditText) findViewById(R.id.edtgoalweight);
        backArr = (ImageButton) findViewById(R.id.BackArr);

        myAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, weight);

        listView1.setAdapter(myAdapter1);

        //Save(Add)
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateCurrentWeight()){
                    return;
                }

                if (!validateGoalWeight()){
                    return;
                }

                String strCurrentWeight = "Current Weight : " + etCurrentWeight.getText().toString();
                String strGoalWeight = "Goal Weight : " + etGoalWeight.getText().toString();

                weight.add(strCurrentWeight);
                weight.add(strGoalWeight);

                myAdapter1.notifyDataSetChanged();

            }
        });

        //select item
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + " has been selected";
                indexVal = i;
                Toast.makeText(UpdateWeight.this, item, Toast.LENGTH_SHORT).show();
            }
        });

        //Update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strCurrentWeight = etCurrentWeight.getText().toString();
                String strGoalWeight = etGoalWeight.getText().toString();

                weight.set(indexVal,strCurrentWeight);
                weight.set(indexVal,strGoalWeight);

                etCurrentWeight.setText("");
                etGoalWeight.setText("");

                myAdapter1.notifyDataSetChanged();
            }
        });

        backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backToMyProfile(); }
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
        Intent in = new Intent(UpdateWeight.this,WelcomePage.class);
        startActivity(in);
    }

    public  void backToMyProfile(){
        Intent in = new Intent(UpdateWeight.this,MyProfile.class);
        startActivity(in);
    }
}
