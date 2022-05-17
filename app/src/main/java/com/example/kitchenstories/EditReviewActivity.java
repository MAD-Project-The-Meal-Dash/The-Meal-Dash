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

import com.database.WriteReviewDBHeler;

public class EditReviewActivity extends AppCompatActivity {
    EditText name , title , comment;
    Button save , edit;
    ImageView home , add , cart , expert , community , back, imageView;
    private static final int CAMERA_REQUEST = 1888;

    AlertDialog.Builder builder;

    //Import DB
    WriteReviewDBHeler DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_review);

        home = findViewById(R.id.homeT8);
        add = findViewById(R.id.addT8);
        cart = findViewById(R.id.cartT8);
        expert = findViewById(R.id.expertT8);
        community = findViewById(R.id.communityT8);
        back = findViewById(R.id.pBack);

        name = findViewById(R.id.customerName2);
        title = findViewById(R.id.reviewTitle2);
        comment = findViewById(R.id.customerComment2);


        save = findViewById(R.id.submitReview2);
        edit = findViewById(R.id.viewAllrev);

        DB = new WriteReviewDBHeler(EditReviewActivity.this);
        builder = new AlertDialog.Builder(this);

        save.setOnClickListener(new View.OnClickListener() { //ADDITION TO DATABASE
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Title = title.getText().toString();
                String Comment = comment.getText().toString();

                if(Name.equals("")||Title.equals("")||Comment.equals(""))
                    Toast.makeText(EditReviewActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to edit ?") .setTitle("Adding Review");

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
                                Boolean update = DB.updateInfo(Name, Title, Comment);
                                if (update==true) {
                                    Toast.makeText(EditReviewActivity.this, "Edited successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(EditReviewActivity.this, "Editing failed", Toast.LENGTH_SHORT).show();
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

        edit.setOnClickListener(v -> {
            Intent intent = new Intent(EditReviewActivity.this , ListReviewActivity.class);
            startActivity(intent);
        });

        //Get the Intent that started this activity and extract the string
        Intent intent1 = getIntent();
        String message = intent1.getStringExtra(ReviewAdapter.EXTRA_MESSAGE);

        //Captures the layout's TextView and set the string as its text
        TextView review1 = findViewById(R.id.customerName2);
        review1.setText(message);

        String message1 = intent1.getStringExtra(ReviewAdapter.EXTRA_MESSAGE1);

        //Captures the layout's TextView and set the string as its text
        TextView review2 = findViewById(R.id.reviewTitle2);
        review2.setText(message1);

        String message2 = intent1.getStringExtra(ReviewAdapter.EXTRA_MESSAGE2);

        //Captures the layout's TextView and set the string as its text
        TextView review3 = findViewById(R.id.customerComment2);
        review3.setText(message2);



        home.setOnClickListener(v -> {
            Intent intent = new Intent(EditReviewActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(EditReviewActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(EditReviewActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(EditReviewActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(EditReviewActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent(EditReviewActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        imageView = findViewById((R.id.imageCam2));
        Button photoButton = findViewById(R.id.reviewButton2);

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