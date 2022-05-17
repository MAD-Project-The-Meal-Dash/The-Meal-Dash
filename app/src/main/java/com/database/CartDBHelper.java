package com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CartDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "shoppingCart.db";

    public CartDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table shoppingCart(name TEXT primary key, price TEXT , quantity TEXT , itemno TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //ADDITION TO THE DATABASE
    public Boolean addInfo(String name , String price , String quantity , String itemno){
        //Grt the data repository in writeMode
        SQLiteDatabase db = this.getWritableDatabase();

        //Create a new map of values , where column names the keys
        ContentValues values = new ContentValues();
        values.put("name" , name);
        values.put("price" , price);
        values.put("quantity" , quantity);
        values.put("itemno" , itemno);
        long result = db.insert("shoppingCart", null, values);
        if(result==-1) return false;
        else
            return true;
    }
    //DISPLAY
//    public List readAllInfo(){
//        SQLiteDatabase db = getReadableDatabase();
//
//        String[] projection ={
//                ExpertMaster.Experts._ID,
//                ExpertMaster.Experts.NAME,
//                ExpertMaster.Experts.EMAIL,
//                ExpertMaster.Experts.CARRIER,
//                ExpertMaster.Experts.WORKS_AT,
//        };
//
//        String sortOrder = ExpertMaster.Experts.NAME + "DESC";
//
//        Cursor cursor = db.query(
//                ExpertMaster.Experts.TABLE_NAME, //Add experts to query
//                projection,                     //the columns to return
//                null,                   //the columns for the WHERE clause
//                null,               //the values for the WHERE clause
//                null,                  //don't group the rows
//                null,                   //don't filter by row groups
//                sortOrder                      //the sort order
//        );
//        List name = new ArrayList<>();
//        List email = new ArrayList<>();
//        List carrier = new ArrayList<>();
//        List works = new ArrayList<>();
//
//        while (cursor.moveToNext()){
//            String Name = cursor.getString(cursor.getColumnIndexOrThrow(ExpertMaster.Experts.NAME));
//            String Email = cursor.getString(cursor.getColumnIndexOrThrow(ExpertMaster.Experts.EMAIL));
//            String Carrier = cursor.getString(cursor.getColumnIndexOrThrow(ExpertMaster.Experts.CARRIER));
//            String Works = cursor.getString(cursor.getColumnIndexOrThrow(ExpertMaster.Experts.WORKS_AT));
//            name.add(Name);
//            email.add(Email);
//            carrier.add(Carrier);
//            works.add(Works);
//        }
//        cursor.close();
//        return name;
//    }
//DELETE
    public Boolean deleteInfo(String name){
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "name" + " Like ?";

        String[] selectionArgs = { name };

        long result = db.delete("shoppingCart" , selection ,selectionArgs);
        if(result==-1) return false;
        else
            return true;
    }
    // we have created a new method for reading all the courses.
    public ArrayList<CartModal> readCarts() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCarts = db.rawQuery("SELECT * FROM " + "shoppingCart", null);

        // on below line we are creating a new array list.
        ArrayList<CartModal> cartModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCarts.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                cartModalArrayList.add(new CartModal (cursorCarts.getString(0),
                        cursorCarts.getString(1),
                        cursorCarts.getString(2),
                        cursorCarts.getString(3)));
            } while (cursorCarts.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCarts.close();
        return cartModalArrayList;
    }
    //UPDATE
//UPDATE
    public Boolean updateInfo(String name , String price , String quantity , String itemno){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name" , name);
        contentValues.put("price" , price);
        contentValues.put("quantity" , quantity);
        contentValues.put("itemno" , itemno);

        String selection = "name" + " LIKE ?";
        String[] selectionArgs = {name};

        int count = db.update(
                "shoppingCart",
                contentValues,
                selection,
                selectionArgs
        );

        if(count==-1) return false;
        else
            return true;
    }
}


