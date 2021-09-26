package com.example.fitforever;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mymealplan extends AppCompatActivity {

    private EditText name,description,menus_1,menus_3;
    private TextView addmealtext2;
    private Button addmealplan2;
    private DbHandler dbHandler;
    private Context context;

    public boolean validatename(){
        String usermealplanname = name.getText().toString();
        if(usermealplanname.isEmpty()){
            name.setError("Meal Plan Name Can't Be Empty");
            return false;

        }else {
            name.setError(null);
            return true;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymealplan);

        name=findViewById(R.id.m_mealplanname);
        description=findViewById(R.id.m_editTextTextPersonName);
        menus_3=findViewById(R.id.m_menuedit3);
        menus_1=findViewById(R.id.m_menuedit1);
        addmealtext2=findViewById(R.id.m_addmealtext2);
        addmealplan2=findViewById(R.id.m_addmealplan2);

        context=this;

        dbHandler=new DbHandler(context);

        addmealplan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validatename()){
                    return;
                }

                String usermealplanname = name.getText().toString();
                String usermenuedit1 =menus_1.getText().toString();
                //String usermenuedit2 = menus_2.getText().toString();
                String usermenuedit3 = menus_3.getText().toString();

                String usereditTextTextPersonName = description.getText().toString();
                long started= System.currentTimeMillis();

                Mealplanmodal mealplanmodal = new Mealplanmodal(usermealplanname,
                        usereditTextTextPersonName,
                        usermenuedit1,usermenuedit3,
                        started,0 );

                dbHandler.addmealplan(mealplanmodal);

                startActivity(new Intent(context,crud_main.class));



            }
        });


    }

}