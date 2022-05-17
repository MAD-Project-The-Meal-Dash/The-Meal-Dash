package com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RecipeDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "recipes.db";

    public RecipeDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table recipes(name1 TEXT primary key, name2 TEXT , name3 TEXT , name4 TEXT , name5 TEXT , name6 TEXT , name7 TEXT , name8 TEXT , name9 TEXT , name10 TEXT , name11 TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //ADDITION TO THE DATABASE
    public Boolean addInfo(String name1 , String name2 , String name3 , String name4 , String name5 , String name6 , String name7 , String name8 , String name9 , String name10 , String name11){
        //Grt the data repository in writeMode
        SQLiteDatabase db = this.getWritableDatabase();

        //Create a new map of values , where column names the keys
        ContentValues values = new ContentValues();
        values.put("name1" , name1);
        values.put("name2" , name2);
        values.put("name3" , name3);
        values.put("name4" , name4);
        values.put("name5" , name5);
        values.put("name6" , name6);
        values.put("name7" , name7);
        values.put("name8" , name8);
        values.put("name9" , name9);
        values.put("name10" , name10);
        values.put("name11" , name11);
        long result = db.insert("recipes", null, values);
        if(result==-1) return false;
        else
            return true;
    }
    //DELETE
    public Boolean deleteInfo(String name1){
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "name1" + " Like ?";

        String[] selectionArgs = { name1 };

        long result = db.delete("recipes" , selection ,selectionArgs);
        if(result==-1) return false;
        else
            return true;
    }
    // we have created a new method for reading all the courses.
    public ArrayList<RecipeModal> readRecipes() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorRecipes = db.rawQuery("SELECT * FROM " + "recipes", null);

        // on below line we are creating a new array list.
        ArrayList<RecipeModal> recipeModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorRecipes.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                recipeModalArrayList.add(new RecipeModal(cursorRecipes.getString(0),
                        cursorRecipes.getString(1),
                        cursorRecipes.getString(2),
                        cursorRecipes.getString(3),
                        cursorRecipes.getString(4),
                        cursorRecipes.getString(5),
                        cursorRecipes.getString(6),
                        cursorRecipes.getString(7),
                        cursorRecipes.getString(8),
                        cursorRecipes.getString(9),
                        cursorRecipes.getString(10)));
            } while (cursorRecipes.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorRecipes.close();
        return recipeModalArrayList;
    }
    //UPDATE
    public Boolean updateInfo(String name1 , String name2 , String name3 , String name4 , String name5 , String name6 , String name7 , String name8 , String name9 , String name10 , String name11){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name1" , name1);
        contentValues.put("name2" , name2);
        contentValues.put("name3" , name3);
        contentValues.put("name4" , name4);
        contentValues.put("name5" , name5);
        contentValues.put("name6" , name6);
        contentValues.put("name7" , name7);
        contentValues.put("name8" , name8);
        contentValues.put("name9" , name9);
        contentValues.put("name10" , name10);
        contentValues.put("name11" , name11);

        String selection = "name1" + " LIKE ?";
        String[] selectionArgs = {name1};

        int count = db.update(
                "recipes",
                contentValues,
                selection,
                selectionArgs
        );

        if(count==-1) return false;
        else
            return true;
    }
}


