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

import com.database.ExpertDBHelper;

public class AddExpertActivity extends AppCompatActivity {
    EditText name , email , carrier , works;
    Button save , list;
    ImageView home , add , cart , expert , community , profile , imageView;
    private static final int CAMERA_REQUEST = 1888;

    AlertDialog.Builder builder;

    //Import DB
    ExpertDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expert);

        home = findViewById(R.id.homeS6);
        add = findViewById(R.id.addS6);
        cart = findViewById(R.id.cartS6);
        expert = findViewById(R.id.expertS6);
        community = findViewById(R.id.communityS6);
        profile = findViewById(R.id.profileS6);

        name = findViewById(R.id.editexpertName);
        email = findViewById(R.id.editexpertEmail);
        carrier = findViewById(R.id.editexpertCarrier);
        works = findViewById(R.id.editexpertWorks);
        list = findViewById(R.id.listExpertBtn);

        save = findViewById(R.id.saveExpert);

        DB = new ExpertDBHelper(AddExpertActivity.this);
        builder = new AlertDialog.Builder(this);

        save.setOnClickListener(new View.OnClickListener() { //ADDITION TO DATABASE
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Carrier = carrier.getText().toString();
                String Works = works.getText().toString();

                if(Name.equals("")||Email.equals("")||Carrier.equals("")||Works.equals(""))
                    Toast.makeText(AddExpertActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to register ?") .setTitle("Expert Registration");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to register ?")
                        .setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"Registration Discarded",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Boolean insert = DB.addInfo(Name, Email, Carrier, Works);
                                if (insert==true) {
                                    Toast.makeText(AddExpertActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(AddExpertActivity.this, "Adding failed", Toast.LENGTH_SHORT).show();
                                }
                                name.setText("");
                                email.setText("");
                                carrier.setText("");
                                works.setText("");

                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Expert Registration");
                alert.show();

            }

        });

        home.setOnClickListener(v -> {
            Intent intent = new Intent(AddExpertActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(AddExpertActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(AddExpertActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(AddExpertActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(AddExpertActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(AddExpertActivity.this , CreateProfile.class);
            startActivity(intent);
        });

        list.setOnClickListener(v -> {
            Intent intent = new Intent(AddExpertActivity.this , ListExpertsActivity.class);
            startActivity(intent);
        });

        imageView = findViewById((R.id.editcameraImage));
        Button photoButton = findViewById(R.id.buttonCamera);

        photoButton.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent , CAMERA_REQUEST);
        });

        //DATABASE INTERACTION GOES HERE-------------------------------------------------------


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_REQUEST){
            assert data != null;
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}