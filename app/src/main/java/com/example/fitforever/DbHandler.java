package com.example.fitforever;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private Context context;


    private static final int VERSION= 1;
    private static final String DB_NAME= "MealPlan";
    private static final String TABLE_NAME= "MealPlan";

    //COLUMN NAMES
    private static final String ID="id";
    private static final String NAME="name";
    private static final String DESCRIPTION="description";
    private static final String MENUS_1="menus_1";
    //private static final String MENUS_2="menus_2";
    private static final String MENUS_3="menus_3";
    private static final String STARTED="started";
    private static final String FINISHED="finished";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION  );
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY ="CREATE TABLE " +TABLE_NAME+""+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME + " TEXT,"
                +DESCRIPTION + " TEXT,"
                +MENUS_1 +" TEXT,"
                +MENUS_3 +" TEXT,"
                +STARTED + " TEXT,"
                +FINISHED +" TEXT" +
                ");";

        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;

        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);

    }

    //add a single meal plan
    public  void addmealplan(Mealplanmodal mealplanmodal){

        SQLiteDatabase sqLiteDatabase= getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(NAME,mealplanmodal.getName());
        contentValues.put(DESCRIPTION,mealplanmodal.getDescription());
        contentValues.put(MENUS_1,mealplanmodal.getMenus_1());
        //contentValues.put(MENUS_2,mealplanmodal.getMenus_2());
        contentValues.put(MENUS_3,mealplanmodal.getMenus_3());
        contentValues.put(STARTED,mealplanmodal.getStarted());
        contentValues.put(FINISHED,mealplanmodal.getFinished());

        //save to table
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if(result== -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Meal Plan Added Successfully!",Toast.LENGTH_SHORT).show();
        }

        //close the database
        sqLiteDatabase.close();
    }

    //count mealplan table records
    public int countmealplan(){
        SQLiteDatabase db=getReadableDatabase();
        String query ="SELECT * FROM "+ TABLE_NAME;

        Cursor cursor=db.rawQuery(query,null);
        return cursor.getCount();
    }

    //get all meal plans to a list
    public List<Mealplanmodal> getallmealplans(){

        List<Mealplanmodal> mealplanmodals=new ArrayList();
        SQLiteDatabase db=getReadableDatabase();
        String query ="SELECT * FROM "+ TABLE_NAME;

        Cursor cursor=db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                //create new meal plan object
                Mealplanmodal mealplanmodal=new Mealplanmodal();

                mealplanmodal.setId(cursor.getInt(0));
                mealplanmodal.setName(cursor.getString(1));
                mealplanmodal.setDescription(cursor.getString(2));
                mealplanmodal.setMenus_1(cursor.getString(3));
                //mealplanmodal.setMenus_2(cursor.getString(4));
                mealplanmodal.setMenus_3(cursor.getString(4));
                mealplanmodal.setStarted(cursor.getLong(5));
                mealplanmodal.setFinished(cursor.getLong(6));

                mealplanmodals.add(mealplanmodal);
            }while (cursor.moveToNext());
        }
        return mealplanmodals;
    }

    public void  deletemealplan(int id){
        SQLiteDatabase db= getWritableDatabase();
        long result=db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});

        if(result== -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Meal Plan Deleted Successfully!",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    //get single meal plan
    public Mealplanmodal getSinglemealPlan(int id){
        SQLiteDatabase db= getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,NAME,DESCRIPTION,MENUS_1,
                        MENUS_3,STARTED,
                        FINISHED},ID + "= ?",new String[]{String.valueOf(id)},
                null,null,null);

        Mealplanmodal mealplanmodal;
        if(cursor !=  null){
            cursor.moveToFirst();

            mealplanmodal=new Mealplanmodal(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    //cursor.getString(4),
                    cursor.getString(4),
                    cursor.getLong(5),
                    cursor.getLong(6)
            );
            return mealplanmodal;
        }
        return null;
    }

    //update a single meal plan
    public int updateMealPlan(Mealplanmodal mealplanmodal){

        SQLiteDatabase db= getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(NAME,mealplanmodal.getName());
        contentValues.put(DESCRIPTION,mealplanmodal.getDescription());
        contentValues.put(MENUS_1,mealplanmodal.getMenus_1());
        //contentValues.put(MENUS_2,mealplanmodal.getMenus_2());
        contentValues.put(MENUS_3,mealplanmodal.getMenus_3());
        contentValues.put(STARTED,mealplanmodal.getStarted());
        contentValues.put(FINISHED,mealplanmodal.getFinished());

        int Status= db.update(TABLE_NAME,contentValues,ID+" =?",
                new String[]{String.valueOf(mealplanmodal.getId())});


        if(Status== -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Meal Plan Updated Successfully!",Toast.LENGTH_SHORT).show();
        }

        db.close();
        return Status;

    }

}


