package com.example.fitforever;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TimetableDBHelper extends SQLiteOpenHelper {
    private Context context;

    private static final String Database_Name = "Timetable.DB";
    private static final String Table_Name = "Timetable";
    private static final String col_ID = "ID";
    private static final String col_DAY = "Day";
    private static final String col_ExerciseList ="Exercise_list";
    private static final String col_TimePeriod ="Time_Period";

    TimetableDBHelper(@Nullable Context context){
        super(context, Database_Name, null, 1);
        this.context = context;
    }

    //
    @Override
    public void onCreate (SQLiteDatabase db) {
        String query = "CREATE TABLE " + Table_Name +
                " (" + col_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                col_DAY + " TEXT, " +
                col_ExerciseList + " TEXT, " +
                col_TimePeriod + " INTEGER);";


        db.execSQL(query);


    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);

        onCreate(db);
    }

    //insert
    void insertData(String title, String list, int time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_DAY, title);
        contentValues.put(col_ExerciseList, list);
        contentValues.put(col_TimePeriod, time);

        long result =db.insert(Table_Name, null, contentValues);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + Table_Name;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }




    void updateData(String rowID, String Day, String Exercise_list, String Time_Period){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_DAY, Day);
        contentValues.put(col_ExerciseList, Exercise_list);
        contentValues.put(col_TimePeriod, Time_Period);

        long result = db.update(Table_Name, contentValues, "ID=?", new String[]{rowID});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String rowID){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(Table_Name, "ID=?",new String[]{rowID});
        if(result == -1){
            Toast.makeText(context, "Not deleted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }
    }
}
