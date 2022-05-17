package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.database.ExpertDBHelper;
import com.database.ProfileDBHelper;
import com.database.ProfileModal;

import java.util.List;

public class CreateProfile extends AppCompatActivity {

    ImageView home , add , cart , expert , community , profile;
    EditText name , email , phone , username;
    Button create;
    ImageButton search;

    AlertDialog.Builder builder;

    //Import DB
    ProfileDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        home = findViewById(R.id.homeS6);
        add = findViewById(R.id.addS6);
        cart = findViewById(R.id.cartS6);
        expert = findViewById(R.id.expertS6);
        community = findViewById(R.id.communityS6);
        profile = findViewById(R.id.profileS6);

        name = findViewById(R.id.profName);
        email = findViewById(R.id.profEmail);
        phone = findViewById(R.id.profPhone);
        username = findViewById(R.id.profUsername);
        create = findViewById(R.id.profCreateBtn);
        search = findViewById(R.id.profileSearchBtn);

        DB = new ProfileDBHelper(CreateProfile.this);
        builder = new AlertDialog.Builder(this);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this , CreateProfile.class);
            startActivity(intent);
        });
        create.setOnClickListener(v -> {
            String Name = name.getText().toString();
            String Email = email.getText().toString();
            String Phone = phone.getText().toString();
            String Username = username.getText().toString();

            if(Name.equals("")||Email.equals("")||Phone.equals("")||Username.equals(""))
                Toast.makeText(CreateProfile.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

            //Uncomment the below code to Set the message and title from the strings.xml file
            builder.setMessage("Do you want to create ?") .setTitle("Profile Creation");

            //Setting message manually and performing action on button click
            builder.setMessage("Do you want to create ?")
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
                            Boolean insert = DB.addInfo(Name, Email, Phone, Username);
                            if (insert==true) {
                                Toast.makeText(CreateProfile.this, "Added successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(CreateProfile.this, "Adding failed", Toast.LENGTH_SHORT).show();
                            }
                            name.setText("");
                            email.setText("");
                            phone.setText("");
                            username.setText("");

                            dialog.cancel();

                        }
                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Profile Creation");
            alert.show();

        });

        search.setOnClickListener(v -> {
                Intent intent = new Intent(CreateProfile.this , SearchProfile.class);
                startActivity(intent);
        });

    }
}