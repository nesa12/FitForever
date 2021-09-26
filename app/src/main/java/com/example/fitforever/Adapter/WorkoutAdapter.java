package com.example.fitforever.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitforever.Model.Workout;
import com.example.fitforever.R;
import com.example.fitforever.ScheduleActivity;

import java.util.ArrayList;
import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {
    private Context mContext;
    private List<Workout> mData;
    String type;

    public WorkoutAdapter(Context mContext, ArrayList<Workout> mData,String type) {
        this.mContext = mContext;
        this.mData = mData;
        this.type = type;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.workout_item, parent, false);
        return new WorkoutViewHolder(view, mContext, mData);
    }

    @Override
    public void onBindViewHolder(@NonNull final WorkoutViewHolder ViewHolder, final int position) {

        ViewHolder.name.setText(mData.get(position).getName());
        ViewHolder.description.setText(mData.get(position).getDescription());
        ViewHolder.image.setImageResource(mData.get(position).getImage());

        ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ScheduleActivity.class);
                intent.putExtra("name",mData.get(position).getName());
                intent.putExtra("id",mData.get(position).getId());
                intent.putExtra("type",type);
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class WorkoutViewHolder extends RecyclerView.ViewHolder{

        TextView name,description;
        ImageView image;
        public WorkoutViewHolder(@NonNull View itemView, final Context context, final List<Workout> item) {
            super(itemView);
            name = itemView.findViewById(R.id.workout_name);
            description = itemView.findViewById(R.id.workout_note);
            image = itemView.findViewById(R.id.workout_image);

        }
    }
}
