package com.example.fitforever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditmeealPlan extends AppCompatActivity {

    private EditText editmealplanname,editmenuedit3,editmenuedit1,editeditTextTextPersonName;
    private TextView editaddmealtext2;
    private Button editaddmealplan2;
    private DbHandler dbHandler;
    private Context context;
    private long updateDate;

    public boolean validateeditmealplanname(){
        String editmealplannameText = editmealplanname.getText().toString();
        if(editmealplannameText.isEmpty()){
            editmealplanname.setError("Meal Plan Name Can't Be Empty");
            return false;

        }else {
            editmealplanname.setError(null);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editmeeal_plan);

        context=this;
        dbHandler=new DbHandler(context);

        editmealplanname=findViewById(R.id.m_editmealplanname);
        editeditTextTextPersonName=findViewById(R.id.m_editeditTextTextPersonName);
        editmenuedit3=findViewById(R.id.m_editmenuedit3);
        editmenuedit1=findViewById(R.id.m_editmenuedit1);
        editaddmealtext2=findViewById(R.id.m_editaddmealtext2);
        editaddmealplan2=findViewById(R.id.m_editaddmealplan2);

        final String id= getIntent().getStringExtra("id");

//        System.out.println(id);
        Mealplanmodal mealplanmodal= dbHandler.getSinglemealPlan(Integer.parseInt(id));

        editmealplanname.setText(mealplanmodal.getName());
        editeditTextTextPersonName.setText(mealplanmodal.getDescription());
        editmenuedit1.setText(mealplanmodal.getMenus_1());
        //editmenuedit2.setText(mealplanmodal.getMenus_2());
        editmenuedit3.setText(mealplanmodal.getMenus_3());

        editaddmealplan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validateeditmealplanname()){
                    return;
                }

                String editmealplannameText = editmealplanname.getText().toString();
                String editeditTextTextPersonNameText = editeditTextTextPersonName.getText().toString();
                String editmenuedit1Text = editmenuedit1.getText().toString();
                //String editmenuedit2Text = editmenuedit2.getText().toString();
                String editmenuedit3Text = editmenuedit3.getText().toString();
                updateDate=System.currentTimeMillis();


                Mealplanmodal mealplanmodal =new Mealplanmodal(Integer.parseInt(id),
                        editmealplannameText,editeditTextTextPersonNameText,editmenuedit1Text,
                        editmenuedit3Text,updateDate,0);


                int state= dbHandler.updateMealPlan(mealplanmodal);

                System.out.println(state);

                startActivity(new Intent(context,crud_main.class));


            }
        });

    }
}