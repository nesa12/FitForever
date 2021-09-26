package com.example.fitforever;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Protein_Calculator extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_calculator);

        // Defining onclick listener for finding the result
        View.OnClickListener listener = new View.OnClickListener() {

            Button button;

            @Override
            public void onClick(View v) {
                Spinner spr = (Spinner) findViewById(R.id.m_sprOperator);
                EditText edtNumber1 = ( EditText) findViewById(R.id.m_editTextTextPersonName4);
                EditText edtResult = ( EditText) findViewById(R.id.m_textView41);


                String selectedItem = (String) spr.getSelectedItem();

                String str1 = edtNumber1.getText().toString();
                if(TextUtils.isEmpty(str1)){
                    edtNumber1.setError("Please enter your Lean Body Mass(LBM)");
                    edtNumber1.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(str1)){
                    edtNumber1.setError("Please enter your activity type");
                    edtNumber1.requestFocus();
                    return;
                }

                if(selectedItem.trim().equals("Generally Physically Inactive")){
                    float result = (float) (Float.parseFloat(edtNumber1.getText().toString())  * 0.5);
                    edtResult.setText(Float.toString(result));
                }else if(selectedItem.trim().equals("Light activity")){
                    float result = (float) (Float.parseFloat(edtNumber1.getText().toString())  * 0.6);
                    edtResult.setText(Float.toString(result));
                }else if(selectedItem.trim().equals("Moderate")){
                    float result = (float) (Float.parseFloat(edtNumber1.getText().toString())  * 0.7);
                    edtResult.setText(Float.toString(result));
                }else if(selectedItem.trim().equals("Active")){
                    float result = (float) (Float.parseFloat(edtNumber1.getText().toString())  * 0.8);
                    edtResult.setText(Float.toString(result));
                }else if(selectedItem.trim().equals("Athlete")){
                    float result = (float) (Float.parseFloat(edtNumber1.getText().toString())  * 1);
                    edtResult.setText(Float.toString(result));
                }
            }
        };


        // Getting reference of the button btnResult
        Button btn = (Button) findViewById(R.id.m_button8);
        Button button = (Button) findViewById(R.id.m_button10);
        // Setting onclick listener
        btn.setOnClickListener(listener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Lbm_table.class);
                startActivity(intent);
            }
        });

    }



    protected float calProtein(float lms, float type1){
        return lms*(type1);
    }
}


