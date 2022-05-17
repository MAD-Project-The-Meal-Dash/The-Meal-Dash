package com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ExpertDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "experts.db";

    public ExpertDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table experts(name TEXT primary key, email TEXT , carrier TEXT , works TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //ADDITION TO THE DATABASE
    public Boolean addInfo(String name , String email , String carrier , String works){
        //Grt the data repository in writeMode
        SQLiteDatabase db = this.getWritableDatabase();

        //Create a new map of values , where column names the keys
        ContentValues values = new ContentValues();
        values.put("name" , name);
        values.put("email" , email);
        values.put("carrier" , carrier);
        values.put("works" , works);
        long result = db.insert("experts", null, values);
        if(result==-1) return false;
        else
            return true;
    }
    //DELETE
    public Boolean deleteInfo(String name){
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "name" + " Like ?";

        String[] selectionArgs = { name };

        long result = db.delete("experts" , selection ,selectionArgs);
        if(result==-1) return false;
        else
            return true;
    }

    public ArrayList<ExpertModal> readExperts() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorExperts = db.rawQuery("SELECT * FROM " + "experts", null);

        // on below line we are creating a new array list.
        ArrayList<ExpertModal> expertModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorExperts.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                expertModalArrayList.add(new ExpertModal(cursorExperts.getString(0),
                        cursorExperts.getString(1),
                        cursorExperts.getString(2),
                        cursorExperts.getString(3)));
            } while (cursorExperts.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorExperts.close();
        return expertModalArrayList;
    }
    //UPDATE
    public Boolean updateInfo(String name , String email , String carrier , String works){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name" , name);
        contentValues.put("email" , email);
        contentValues.put("carrier" , carrier);
        contentValues.put("works" , works);

        String selection = "name" + " LIKE ?";
        String[] selectionArgs = {name};

        int count = db.update(
               "experts",
                contentValues,
                selection,
                selectionArgs
        );

        if(count==-1) return false;
        else
            return true;
    }
}

