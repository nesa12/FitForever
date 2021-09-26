package com.example.fitforever;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class WaterIntakeCalculator extends AppCompatActivity {


        EditText tbodyweigt, minofex;
        TextView calresult;
        Button watercalculator;
        String calculation;

        public boolean validateweight(){
            String weight = tbodyweigt.getText().toString();
            if(weight.isEmpty()){
                tbodyweigt.setError("Your weight is required!");
                return false;
            }else {
                tbodyweigt.setError(null);
                return true;
            }
        }

        public boolean validatetime(){
            String time = minofex.getText().toString();
            if(time.isEmpty()){
                minofex.setError("Your weight is required!");
                return false;
            }else {
                minofex.setError(null);
                return true;
            }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_waterintakecalculator);

            tbodyweigt = findViewById(R.id.tbodyweigt);
            minofex = findViewById(R.id.minofex);
            calresult = findViewById(R.id.calresult);
            watercalculator = findViewById(R.id.watercalculator);
            watercalculator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!validateweight()){
                        return;
                    }

                    if(!validatetime()){
                        return;
                    }

                    String s1 = tbodyweigt.getText().toString();
                    String s2 = minofex.getText().toString();

                    double bodyweight = Double.parseDouble(s1);
                    double minutes = Double.parseDouble(s2);

                    double water1 = bodyweight * (0.0434656256777272);
                    double water2 = (minutes/30) * (0.354882);

                    double wateramount = water1 + water2;

                    calculation = "Your Daily Water Intake Is: \n\n" + wateramount + "  Liters";

                    calresult.setText(calculation);
                }
            });




        }

    }