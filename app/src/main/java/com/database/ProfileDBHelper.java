package com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class ProfileDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "profile.db";

    public ProfileDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table profile(name TEXT primary key, email TEXT , phone TEXT , username TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //ADDITION TO THE DATABASE
    public Boolean addInfo(String name , String email , String phone , String username){
        //Grt the data repository in writeMode
        SQLiteDatabase db = this.getWritableDatabase();

        //Create a new map of values , where column names the keys
        ContentValues values = new ContentValues();
        values.put("name" , name);
        values.put("email" , email);
        values.put("phone" , phone);
        values.put("username" , username);
        long result = db.insert("profile", null, values);
        if(result==-1) return false;
        else
            return true;
    }

    public ArrayList<ProfileModal> readProfiles() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorProfiles = db.rawQuery("SELECT * FROM " + "profile", null);

        // on below line we are creating a new array list.
        ArrayList<ProfileModal> profileModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorProfiles.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                profileModalArrayList.add(new ProfileModal(cursorProfiles.getString(0),
                        cursorProfiles.getString(1),
                        cursorProfiles.getString(2),
                        cursorProfiles.getString(3)));
            } while (cursorProfiles.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorProfiles.close();
        return profileModalArrayList;
    }

    //DELETE
    public Boolean deleteInfo(String name){
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "name" + " Like ?";

        String[] selectionArgs = { name };

        long result = db.delete("profile" , selection ,selectionArgs);
        if(result==-1) return false;
        else
            return true;
    }
    //UPDATE
    public Boolean updateInfo(String name , String email , String phone , String username){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name" , name);
        contentValues.put("email" , email);
        contentValues.put("phone" , phone);
        contentValues.put("username" , username);

        String selection = "name" + " LIKE ?";
        String[] selectionArgs = {name};

        int count = db.update(
                "profile",
                contentValues,
                selection,
                selectionArgs
        );

        if(count==-1) return false;
        else
            return true;
    }

}
