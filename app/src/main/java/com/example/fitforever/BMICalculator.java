package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculator extends AppCompatActivity {
    EditText etHeight,etWeight;
    TextView resultText;
    Button bmicalculatebtn,bmiTablebtn;
    //ImageButton backArr;
    ImageButton home;


    String calculation, BMIresult;

    //validation
    public boolean validateWeight(){
        String S1  = etWeight.getText().toString();
        if(S1.isEmpty()){
            etWeight.setError("Your Weight is required!");
            return false;
        }else if(S1.length()>=4){
            etWeight.setError("Your Weight should be a valid number!");
            etWeight.requestFocus();
            return false;
        }else{
            etWeight.setError(null);
            return true;
        }
    }

    public boolean validateHeight(){
        String S2  = etHeight.getText().toString();
        if(S2.isEmpty()){
            etHeight.setError("Your Height is required!");
            return false;
        }else if(S2.length()>=4){
            etHeight.setError("Your Height should be a valid number!");
            etHeight.requestFocus();
            return false;
        }else{
            etHeight.setError(null);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i_calculator);

        etHeight = findViewById(R.id.edtHeight);
        etWeight = findViewById(R.id.edtWeight);
        resultText = findViewById(R.id.result);


        bmicalculatebtn = (Button) findViewById(R.id.btnCalcBMI);
       /*bmicalculatebtn.setOnClickListener((view) ->{
           float weight,height;
           float bmiVal = calBMI(Float.parseFloat(etWeight.getText().toString()),Float.parseFloat(etHeight.getText().toString()));
           resultText.setText(String.valueOf(bmiVal));
        });*/

        bmiTablebtn = (Button) findViewById(R.id.bmiTable);
        bmiTablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBMIResult();
                /*Intent intent = new Intent(BMICalculator.this,WelcomePage.class);
                intent.putExtra("BMIResult",resultText.getText().toString());
                startActivity(intent);*/
            }
        });

        home = findViewById(R.id.imageButton6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });


        //backArr = (ImageButton) findViewById(R.id.BackArr);
        /*backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backToMyProfile(); }
        });*/

    }

    public void backToHome(){
        Intent in = new Intent(BMICalculator.this,WelcomePage.class);
        startActivity(in);
    }

    /*public  void backToMyProfile(){
        Intent in = new Intent(BMICalculator.this,MyProfile.class);
        startActivity(in);
    }*/

    //calculation
    public void calculateBMI(View view){
        if (!validateWeight()){
            return;
        }

        if (!validateHeight()){
            return;
        }

        String S1 = etWeight.getText().toString();
        String S2 = etHeight.getText().toString();

        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2)/100;

        float bmi = weightValue/(heightValue * heightValue);

        if (bmi < 18.5){
            BMIresult = "UnderWeight";
        }
        else if(bmi>= 18.5 && bmi<=25){
            BMIresult = "Normal";
        }
        else if(bmi>25 && bmi<= 30){
            BMIresult = "OverWeight";
        }
        else if(bmi>30 && bmi<= 35){
            BMIresult = "Pre-Obese";
        }
        else{
            BMIresult = "Obese";
        }

        calculation = "Your Body Mass Index is: \n\t" + bmi + " \n Your Body State is: \n \t" + BMIresult;

        resultText.setText(calculation);

    }


    public void  openBMIResult(){
        Intent in = new Intent(BMICalculator.this,BMIResult.class);
        startActivity(in);
    }

    //Test case bmi
    protected float calBMI(float weight, float height){
        return weight/((height/100)*(height/100));
    }

}
