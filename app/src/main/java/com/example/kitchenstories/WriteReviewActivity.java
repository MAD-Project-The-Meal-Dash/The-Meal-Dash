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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.database.WriteReviewDBHeler;

public class WriteReviewActivity extends AppCompatActivity {
    EditText name , title , comment;
    Button save, ViewList;
    ImageView home , add , cart , expert , community , back, imageView, search, cal;

    private static final int CAMERA_REQUEST = 1888;

    AlertDialog.Builder builder;

    //Import DB
    WriteReviewDBHeler DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        home = findViewById(R.id.homeT8);
        add = findViewById(R.id.addT8);
        cart = findViewById(R.id.cartT8);
        expert = findViewById(R.id.expertT8);
        community = findViewById(R.id.communityT8);
        back = findViewById(R.id.pBack);
        search = findViewById(R.id.revSearch);
        cal = findViewById(R.id.revCal);



        name = findViewById(R.id.customerName);
        title = findViewById(R.id.reviewTitle);
        comment = findViewById(R.id.customerComment);

        save = findViewById(R.id.submitReview);
        ViewList = findViewById(R.id.listViewebutton);

        DB = new WriteReviewDBHeler(WriteReviewActivity.this);
        builder = new AlertDialog.Builder(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Title = title.getText().toString();
                String Comment = comment.getText().toString();


                if(Name.equals("")||Title.equals("")||Comment.equals(""))
                    Toast.makeText(WriteReviewActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to Write Review ?") .setTitle("Adding Review");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Write Review ?")
                        .setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"Review Discarded",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Boolean insert = DB.addInfo(Name, Title, Comment);
                                if (insert==true) {
                                    Toast.makeText(WriteReviewActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(WriteReviewActivity.this, "Adding failed", Toast.LENGTH_SHORT).show();
                                }
                                name.setText("");
                                title.setText("");
                                comment.setText("");


                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Adding Review");
                alert.show();

            }

        });

        home.setOnClickListener(v -> {
            Intent intent = new Intent(WriteReviewActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(WriteReviewActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(WriteReviewActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(WriteReviewActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(WriteReviewActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent(WriteReviewActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        ViewList.setOnClickListener(v -> {
            Intent intent = new Intent(WriteReviewActivity.this , ListReviewActivity.class);
            startActivity(intent);
        });

        search.setOnClickListener(v -> {
            Intent intent = new Intent(WriteReviewActivity.this , SearchReviewActivity.class);
            startActivity(intent);
        });

        cal.setOnClickListener(v -> {
            Intent intent = new Intent(WriteReviewActivity.this , ReviewCalculation.class);
            startActivity(intent);
        });


        imageView = findViewById((R.id.imageCam));
        Button photoButtonR = findViewById(R.id.reviewButton);

        photoButtonR.setOnClickListener(v -> {
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