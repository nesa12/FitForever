package com.example.fitforever.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitforever.Model.Schedule;
import com.example.fitforever.R;
import com.example.fitforever.UpdateScheduleActivity;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {
    private Context mContext;
    private List<Schedule> mData;

    public ScheduleAdapter(Context mContext, ArrayList<Schedule> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.schedule_item, parent, false);
        return new ScheduleViewHolder(view, mContext, mData);
    }

    @Override
    public void onBindViewHolder(@NonNull final ScheduleViewHolder ViewHolder, final int position) {

        ViewHolder.name.setText(mData.get(position).getWorkout_name());
        ViewHolder.id.setText(mData.get(position).getId()+"");
        ViewHolder.reps.setText(mData.get(position).getReps());
        ViewHolder.sets.setText(mData.get(position).getSets());
        ViewHolder.type.setText(mData.get(position).getType());

        ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, UpdateScheduleActivity.class);
                intent.putExtra("id",mData.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder{

        TextView name,type,reps,sets,id;
        public ScheduleViewHolder(@NonNull View itemView, final Context context, final List<Schedule> item) {
            super(itemView);
            name = itemView.findViewById(R.id.workout_txt);
            type = itemView.findViewById(R.id.type_txt);
            reps = itemView.findViewById(R.id.reps_txt);
            sets = itemView.findViewById(R.id.sets_txt);
            id = itemView.findViewById(R.id.id_txt);

        }
    }
}
