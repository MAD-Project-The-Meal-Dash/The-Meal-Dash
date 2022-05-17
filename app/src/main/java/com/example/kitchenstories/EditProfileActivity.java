package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.database.ProfileDBHelper;

public class EditProfileActivity extends AppCompatActivity {
    ImageView home , add , cart , expert , community , profile;
    EditText name , email , phone , username;
    Button update , list;

    AlertDialog.Builder builder;

    //Import DB
    ProfileDBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        home = findViewById(R.id.homeS6);
        add = findViewById(R.id.addS6);
        cart = findViewById(R.id.cartS6);
        expert = findViewById(R.id.expertS6);
        community = findViewById(R.id.communityS6);
        profile = findViewById(R.id.profileS6);

        name = findViewById(R.id.eProf1);
        email = findViewById(R.id.eProf2);
        phone = findViewById(R.id.eProf3);
        username = findViewById(R.id.eProf4);
        update = findViewById(R.id.eSave);
        list = findViewById(R.id.eList);

        DB = new ProfileDBHelper(EditProfileActivity.this);
        builder = new AlertDialog.Builder(this);

        update.setOnClickListener(new View.OnClickListener() { //ADDITION TO DATABASE
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Phone = phone.getText().toString();
                String Username = username.getText().toString();

                if(Name.equals("")||Email.equals("")||Phone.equals("")||Username.equals(""))
                    Toast.makeText(EditProfileActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to edit ?") .setTitle("Profile Registration");

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
                                Boolean update = DB.updateInfo(Name, Email, Phone, Username);
                                if (update==true) {
                                    Toast.makeText(EditProfileActivity.this, "Edited successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(EditProfileActivity.this, "Editing failed", Toast.LENGTH_SHORT).show();
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
                alert.setTitle("Profile Registration");
                alert.show();

            }

        });


        home.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileActivity.this , CreateProfile.class);
            startActivity(intent);
        });
        list.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileActivity.this , SearchProfile.class);
            startActivity(intent);
        });

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(ViewProfileActivity.EXTRA_MESSAGE);

        //Captures the layout's TextView and set the string as its text
        TextView prof1 = findViewById(R.id.eProf1);
        prof1.setText(message);

        String message1 = intent.getStringExtra(ViewProfileActivity.EXTRA_MESSAGE1);

        //Captures the layout's TextView and set the string as its text
        TextView prof2 = findViewById(R.id.eProf2);
        prof2.setText(message1);

        String message2 = intent.getStringExtra(ViewProfileActivity.EXTRA_MESSAGE2);

        //Captures the layout's TextView and set the string as its text
        TextView prof3 = findViewById(R.id.eProf3);
        prof3.setText(message2);

        String message3 = intent.getStringExtra(ViewProfileActivity.EXTRA_MESSAGE3);

        //Captures the layout's TextView and set the string as its text
        TextView prof4 = findViewById(R.id.eProf4);
        prof4.setText(message3);
    }
}