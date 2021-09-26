package com.example.fitforever;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList reminder_id, reminder_name, reminder_time;

    CustomAdapter(Activity activity, Context context, ArrayList reminder_id, ArrayList reminder_name, ArrayList reminder_time){
        this.activity = activity;
        this.context = context;
        this.reminder_id = reminder_id;
        this.reminder_name = reminder_name;
        this.reminder_time = reminder_time;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_reminder, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.reminder_id_txt.setText(String.valueOf(reminder_id.get(position)));
        holder.reminder_name_txt.setText(String.valueOf(reminder_name.get(position)));
        holder.reminder_time_txt.setText(String.valueOf(reminder_time.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("reminder_id", String.valueOf(reminder_id.get(position)));
                intent.putExtra("reminder_name", String.valueOf(reminder_name.get(position)));
                intent.putExtra("reminder_time", String.valueOf(reminder_time.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reminder_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView reminder_id_txt, reminder_name_txt, reminder_time_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            reminder_id_txt = itemView.findViewById(R.id.reminder_id_txt);
            reminder_name_txt= itemView.findViewById(R.id.reminder_name_txt);
            reminder_time_txt = itemView.findViewById(R.id.reminder_time_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

