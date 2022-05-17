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
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.database.CartDBHelper;

public class EditCartActivity extends AppCompatActivity {
    EditText name , price , quantity , itemno;
    Button confirmsave , edit;
    //ImageView home , add , cart , expert , community , profile , imageView;
   // private static final int CAMERA_REQUEST = 1888;

    AlertDialog.Builder builder;

    //Import DB
    CartDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cart);

        /*home = findViewById(R.id.homeS6);
        add = findViewById(R.id.addS6);
        cart = findViewById(R.id.cartS6);
        expert = findViewById(R.id.expertS6);
        community = findViewById(R.id.communityS6);
        profile = findViewById(R.id.profileS6);*/

        name = findViewById(R.id.eeditFoodName);
        price = findViewById(R.id.eeditPrice);
        quantity = findViewById(R.id.eeditQuantity);
        itemno = findViewById(R.id.eeditItemno);

        confirmsave = findViewById(R.id.eeditConfirm);
        edit = findViewById(R.id.eeditList);

        DB = new CartDBHelper(EditCartActivity.this);
        builder = new AlertDialog.Builder(this);

        confirmsave.setOnClickListener(new View.OnClickListener() { //ADDITION TO DATABASE
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Price = price.getText().toString();
                String Quantity = quantity.getText().toString();
                String Itemno = itemno.getText().toString();

                if(Name.equals("")||Price.equals("")||Quantity.equals("")||Itemno.equals(""))
                    Toast.makeText(EditCartActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to edit ?") .setTitle("Add to cart");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to edit ?")
                        .setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"Editing Discarded",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Boolean update = DB.updateInfo(Name, Price, Quantity, Itemno);
                                if (update==true) {
                                    Toast.makeText(EditCartActivity.this, "Edited successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(EditCartActivity.this, "Editing failed", Toast.LENGTH_SHORT).show();
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
                alert.setTitle(" add to cart");
                alert.show();

            }

        });

        edit.setOnClickListener(v -> {
            Intent intent = new Intent(EditCartActivity.this , ViewCartActivity.class);
            startActivity(intent);
        });

      //Get the Intent that started this activity and extract the string
       Intent intent1 = getIntent();
        String message = intent1.getStringExtra(CartAdapter.EXTRA_MESSAGE);

        //Captures the layout's TextView and set the string as its text
        TextView text1 = findViewById(R.id.eeditFoodName);
        text1.setText(message);

        String message1 = intent1.getStringExtra(CartAdapter.EXTRA_MESSAGE1);

        //Captures the layout's TextView and set the string as its text
        TextView text2 = findViewById(R.id.eeditPrice);
        text2.setText(message1);

        String message2 = intent1.getStringExtra(CartAdapter.EXTRA_MESSAGE2);

        //Captures the layout's TextView and set the string as its text
        TextView text3 = findViewById(R.id.eeditQuantity);
        text3.setText(message2);

        String message3 = intent1.getStringExtra(CartAdapter.EXTRA_MESSAGE3);

        //Captures the layout's TextView and set the string as its text
        TextView text4 = findViewById(R.id.eeditItemno);
        text4.setText(message3);

      /*  home.setOnClickListener(v -> {
            Intent intent = new Intent(EditExpertActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });*/

       /* add.setOnClickListener(v -> {
            Intent intent = new Intent(EditExpertActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(EditExpertActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(EditExpertActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(EditExpertActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(EditExpertActivity.this , CreateProfile.class);
            startActivity(intent);
        });*/

       /* imageView = findViewById((R.id.editcameraImage));
        Button photoButton = findViewById(R.id.TakePhoto);

        photoButton.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent , CAMERA_REQUEST);
        });

        //DATABASE INTERACTION GOES HERE-------------------------------------------------------


    }*/
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_REQUEST){
            assert data != null;
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);*/
        }
    }
