package com.example.fitforever;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class MealPlanAdapter extends ArrayAdapter<Mealplanmodal> {

    private Context context;
    private int resource;
    List<Mealplanmodal> mealplanmodals;

    MealPlanAdapter(Context context,int resource, List<Mealplanmodal> mealplanmodals){
        super(context,resource,mealplanmodals);
        this.context=context;
        this.resource=resource;
        this.mealplanmodals=mealplanmodals;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(resource,parent,false);

        TextView name=row.findViewById(R.id.m_name);
        TextView menus_1=row.findViewById(R.id.m_menus_1);
        TextView menus_3=row.findViewById(R.id.m_menus_3);
        TextView description=row.findViewById(R.id.m_description);
        ImageView onGoing= row.findViewById(R.id.m_onGoing);

        Mealplanmodal mealplanmodal=mealplanmodals.get(position);

        name.setText(mealplanmodal.getName());
        menus_1.setText(mealplanmodal.getMenus_1());
        menus_3.setText(mealplanmodal.getMenus_3());
        description.setText(mealplanmodal.getDescription());
        onGoing.setVisibility(row.INVISIBLE);

        if(mealplanmodal.getFinished() >0){
            onGoing.setVisibility(View.VISIBLE);
        }
        return row;


//        return super.getView(position, convertView, parent);
    }
}
