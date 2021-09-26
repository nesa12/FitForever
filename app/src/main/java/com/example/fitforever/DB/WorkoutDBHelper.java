package com.example.fitforever.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fitforever.Model.Schedule;

import java.util.ArrayList;

public class WorkoutDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "FitForever.db";
    public static final String TABLE_01_NAME = "Schedule";
    public static final String TABLE_01_COLUMN_ID = "id";
    public static final String TABLE_01_COLUMN_WORKOUT_ID = "workout_id";
    public static final String TABLE_01_COLUMN_WORKOUT_NAME = "workout_name";
    public static final String TABLE_01_COLUMN_DATE = "date";
    public static final String TABLE_01_COLUMN_REPS = "reps";
    public static final String TABLE_01_COLUMN_SETS = "sets";
    public static final String TABLE_01_COLUMN_TYPE = "type";


    public WorkoutDBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table Schedule " +
                        "(id integer primary key, workout_id text,workout_name text,date text,reps text, sets text, type text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS Schedule");
        onCreate(db);
    }

    public boolean add_schedule (Schedule schedule) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        System.out.println(schedule.getReps()+"Reps");
        System.out.println(schedule.getSets()+"Sets");
        System.out.println(schedule.getType()+"Type");
        contentValues.put(TABLE_01_COLUMN_WORKOUT_ID, schedule.getWorkout_id());
        contentValues.put(TABLE_01_COLUMN_WORKOUT_NAME, schedule.getWorkout_name());
        contentValues.put(TABLE_01_COLUMN_DATE, schedule.getDate());
        contentValues.put(TABLE_01_COLUMN_SETS, schedule.getSets());
        contentValues.put(TABLE_01_COLUMN_REPS, schedule.getReps());
        contentValues.put(TABLE_01_COLUMN_TYPE, schedule.getType());

        long id = db.insert(TABLE_01_NAME, null, contentValues);
        System.out.println(id);
        if(id == -1){
            return false;
        }else {
            return true;
        }
    }


    public Schedule getSchedule(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result =  db.rawQuery( "select * from Schedule where id = '"+id+"'", null );
        if (result.getCount() > 0) {
            result.moveToFirst();
            Schedule schedule = new Schedule();
            schedule.setId(result.getInt(result.getColumnIndex(TABLE_01_COLUMN_ID)));
            schedule.setWorkout_id(result.getString(result.getColumnIndex(TABLE_01_COLUMN_WORKOUT_ID)));
            schedule.setWorkout_name(result.getString(result.getColumnIndex(TABLE_01_COLUMN_WORKOUT_NAME)));
            schedule.setDate(result.getString(result.getColumnIndex(TABLE_01_COLUMN_DATE)));
            schedule.setReps(result.getString(result.getColumnIndex(TABLE_01_COLUMN_REPS)));
            schedule.setSets(result.getString(result.getColumnIndex(TABLE_01_COLUMN_SETS)));
            schedule.setType(result.getString(result.getColumnIndex(TABLE_01_COLUMN_TYPE)));
            return schedule;
        }
        return null;
    }

    public boolean updateSchedule (Schedule schedule) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_01_COLUMN_SETS, schedule.getSets());
        contentValues.put(TABLE_01_COLUMN_REPS, schedule.getReps());
        System.out.println(schedule.getReps());
        System.out.println(schedule.getSets());
        System.out.println(schedule.getId());

        long result = db.update(TABLE_01_NAME, contentValues, "id = "+schedule.getId(), null );
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean deleteSchedule (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("Schedule",
                "id = ? ",
                new String[] { id });
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public ArrayList<Schedule> getSchedules(String date,String type) {
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();

        SQLiteDatabase db = this.getReadableDatabase();
        System.out.println("select * from Schedule WHERE DATE(date) = '"+date+"' AND type ='"+type+"'");
        Cursor result =  db.rawQuery( "select * from Schedule WHERE type ='"+type+"' AND date = '"+date+"'", null );
        result.moveToFirst();

        while(result.isAfterLast() == false){
            Schedule schedule = new Schedule();
            schedule.setId(result.getInt(result.getColumnIndex(TABLE_01_COLUMN_ID)));
            schedule.setWorkout_id(result.getString(result.getColumnIndex(TABLE_01_COLUMN_WORKOUT_ID)));
            schedule.setWorkout_name(result.getString(result.getColumnIndex(TABLE_01_COLUMN_WORKOUT_NAME)));
            schedule.setDate(result.getString(result.getColumnIndex(TABLE_01_COLUMN_DATE)));
            schedule.setReps(result.getString(result.getColumnIndex(TABLE_01_COLUMN_REPS)));
            schedule.setSets(result.getString(result.getColumnIndex(TABLE_01_COLUMN_SETS)));
            schedule.setType(result.getString(result.getColumnIndex(TABLE_01_COLUMN_TYPE)));
            schedules.add(schedule);
            result.moveToNext();
        }
        return schedules;
    }
}