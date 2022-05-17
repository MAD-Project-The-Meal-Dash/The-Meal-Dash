package com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WriteReviewDBHeler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "reviews.db";

    public WriteReviewDBHeler(@Nullable Context context) {
        super(context, DATABASE_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table reviews(name TEXT primary key, title TEXT , comment TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //ADDITION TO THE DATABASE
    public Boolean addInfo(String name , String title , String comment){
        //Grt the data repository in writeMode
        SQLiteDatabase db = this.getWritableDatabase();

        //Create a new map of values , where column names the keys
        ContentValues values = new ContentValues();
        values.put("name" , name);
        values.put("title" , title);
        values.put("comment" , comment);
        long result = db.insert("reviews", null, values);
        if(result==-1) return false;
        else
            return true;
    }

    //DELETE
    public Boolean deleteInfo(String name){
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "name" + " Like ?";

        String[] selectionArgs = { name };

        long result = db.delete("reviews" , selection ,selectionArgs);
        if(result==-1) return false;
        else
            return true;
    }
    // we have created a new method for reading all the courses.
    public ArrayList<ReviewModal> readReviews() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorReviews = db.rawQuery("SELECT * FROM " + "reviews", null);

        // on below line we are creating a new array list.
        ArrayList<ReviewModal> reviewModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorReviews.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                reviewModalArrayList.add(new ReviewModal(cursorReviews.getString(0),
                        cursorReviews.getString(1),
                        cursorReviews.getString(2)));
            } while (cursorReviews.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorReviews.close();
        return reviewModalArrayList;
    }
    //UPDATE
    public Boolean updateInfo(String name , String title , String comment ){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name" , name);
        contentValues.put("title" , title);
        contentValues.put("comment" , comment);

        String selection = "name" + " LIKE ?";
        String[] selectionArgs = {name};

        int count = db.update(
                "reviews",
                contentValues,
                selection,
                selectionArgs
        );

        if(count==-1) return false;
        else
            return true;
    }
}