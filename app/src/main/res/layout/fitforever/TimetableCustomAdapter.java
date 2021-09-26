package com.example.fitforever;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimetableCustomAdapter extends RecyclerView.Adapter<TimetableCustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList ID, Day, Exercise_list, Time_Period;

    Animation translate_anim1;


    TimetableCustomAdapter(Activity activity, Context context, ArrayList ID, ArrayList Day, ArrayList Exercise_list, ArrayList Time_Period){
        this.activity = activity;
        this.context = context;
        this.ID = ID;
        this.Day = Day;
        this.Exercise_list = Exercise_list;
        this.Time_Period = Time_Period;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.timetable_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.ID_txt.setText(String.valueOf(ID.get(position)));
        holder.title_txt.setText(String.valueOf(Day.get(position)));
        holder.list_txt.setText(String.valueOf(Exercise_list.get(position)));
        holder.time_txt.setText(String.valueOf(Time_Period.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateTimetable.class);
                intent.putExtra("ID", String.valueOf(ID.get(position)));
                intent.putExtra("Day", String.valueOf(Day.get(position)));
                intent.putExtra("Exercise_list", String.valueOf(Exercise_list.get(position)));
                intent.putExtra("Time_Period", String.valueOf(Time_Period.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ID_txt, title_txt, list_txt, time_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ID_txt = itemView.findViewById(R.id.ID_txt);
            title_txt = itemView.findViewById(R.id.title_txt);
            list_txt = itemView.findViewById(R.id.list_txt);
            time_txt = itemView.findViewById(R.id.time_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //animation recyclerview
            translate_anim1 = AnimationUtils.loadAnimation(context, R.anim.transtate_anim1);
            mainLayout.setAnimation(translate_anim1);
        }
    }
}

