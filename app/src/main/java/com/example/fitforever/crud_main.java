package com.example.fitforever;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class crud_main extends AppCompatActivity {

    private ListView list1;
    private TextView textall;
    private ImageButton imageButton;
    Context context;
    private DbHandler dbHandler;
    private List<Mealplanmodal> mealplanmodals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_main);

        context=this;
        dbHandler=new DbHandler(context);
        list1 = findViewById(R.id.m_list1);
        textall = findViewById(R.id.m_mealplancount);
        imageButton=findViewById(R.id.m_imageButton);
        mealplanmodals=new ArrayList<>();

        mealplanmodals= dbHandler.getallmealplans();

        MealPlanAdapter adapter=new MealPlanAdapter(context, R.layout.plan_single,mealplanmodals);
        list1.setAdapter(adapter);

        //get mealplan count from table
        int countmealplan =dbHandler.countmealplan() ;
        textall.setText("You have "+countmealplan+" Meal Plans !");

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,mymealplan.class));
            }

        });

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Mealplanmodal mealplanmodal= mealplanmodals.get(position);

                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setTitle(mealplanmodal.getName());
//                builder.setMessage("message");

                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mealplanmodal.setFinished(System.currentTimeMillis());
                        dbHandler.updateMealPlan(mealplanmodal);

                        startActivity(new Intent(context,crud_main.class));

                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dbHandler.deletemealplan(mealplanmodal.getId());
                        startActivity(new Intent(context,crud_main.class));
                    }
                });

                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent=new Intent(context,EditmeealPlan.class);
                        intent.putExtra("id",String.valueOf(mealplanmodal.getId()));
                        startActivity(intent);
                    }
                });


                builder.show();
            }
        });
    }
}