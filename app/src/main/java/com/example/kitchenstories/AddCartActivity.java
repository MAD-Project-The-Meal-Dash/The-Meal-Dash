package com.example.kitchenstories;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.database.CartDBHelper;
import com.database.ExpertDBHelper;

import android.os.Bundle;

public class AddCartActivity extends AppCompatActivity {
    ImageView home , add , cart , expert , community ,back,menuu, profile,imageView;
    EditText name, price, quantity, itemno;
    Button save,view;

    private static final int CAMERA_REQUEST = 1888;

    AlertDialog.Builder builder;
    //Import DB
    CartDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);

        home = findViewById(R.id.homeC5);
        add = findViewById(R.id.addC5);
        cart = findViewById(R.id.cartC5);
        expert = findViewById(R.id.expertC5);
        community = findViewById(R.id.communityC5);
        back =findViewById(R.id.CCCback);

        //profile = findViewById(R.id.profilesC0);

        name = findViewById(R.id.Cname1);
        price = findViewById(R.id.editPrice);
        quantity = findViewById(R.id.Cqty1);
        itemno = findViewById(R.id.Item1);

        save = findViewById(R.id.btn_Add);
        view=findViewById(R.id.btn_View1);

        DB = new CartDBHelper(AddCartActivity.this);
        builder = new AlertDialog.Builder(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Price = price.getText().toString();
                String Quantity = quantity.getText().toString();
                String Itemno = itemno.getText().toString();

                if (Name.equals("") || Price.equals("") || Quantity.equals("") || Itemno.equals(""))
                    Toast.makeText(AddCartActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to Add new item ?").setTitle("Added");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Add new item ?")
                        .setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(), "Adding Discarded",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Boolean insert = DB.addInfo(Name, Price, Quantity, Itemno);
                                if (insert == true) {
                                    Toast.makeText(AddCartActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(AddCartActivity.this, "Adding failed", Toast.LENGTH_SHORT).show();
                                }
                                name.setText("");
                                price.setText("");
                                quantity.setText("");
                                itemno.setText("");

                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Add  to the cart ");
                alert.show();

            }

        });
        view.setOnClickListener(v -> {
            Intent intent = new Intent(AddCartActivity.this , ViewCartActivity.class);
            startActivity(intent);


        });
        home.setOnClickListener(v -> {
            Intent intent = new Intent(AddCartActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(AddCartActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(AddCartActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(AddCartActivity.this , DisplayExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(AddCartActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });
        back.setOnClickListener(v -> {
            Intent intent = new Intent(AddCartActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });
    }
}

