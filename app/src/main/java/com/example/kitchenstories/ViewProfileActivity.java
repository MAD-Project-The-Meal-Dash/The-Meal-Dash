package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.database.ExpertDBHelper;
import com.database.ProfileDBHelper;

public class ViewProfileActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "text1";
    public static final String EXTRA_MESSAGE1 = "text2";
    public static final String EXTRA_MESSAGE2 = "text3";
    public static final String EXTRA_MESSAGE3 = "text4";

    ImageView home , add , cart , expert , community , profile , list;
    TextView name , email , phone , username;
    Button delete , edit;

    AlertDialog.Builder builder;

    //Import DB
    ProfileDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        home = findViewById(R.id.homeS6);
        add = findViewById(R.id.addS6);
        cart = findViewById(R.id.cartS6);
        expert = findViewById(R.id.expertS6);
        community = findViewById(R.id.communityS6);
        profile = findViewById(R.id.profileS6);

        name = findViewById(R.id.prof1);
        email = findViewById(R.id.prof2);
        phone = findViewById(R.id.prof3);
        username = findViewById(R.id.prof4);
        list = findViewById(R.id.profileM0);
        delete = findViewById(R.id.deleteProf);
        edit = findViewById(R.id.editProf);

        DB = new ProfileDBHelper(ViewProfileActivity.this);
        builder = new AlertDialog.Builder(this);

        //DELETION TO DATABASE
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();

                if(Name.equals(""))
                    Toast.makeText(ViewProfileActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to delete ?") .setTitle("Profile Deletion");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to delete ?")
                        .setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"Deletion Discarded",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Boolean deletion = DB.deleteInfo(Name);
                                if (deletion==true) {
                                    Toast.makeText(ViewProfileActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ViewProfileActivity.this, "Deleting failed", Toast.LENGTH_SHORT).show();
                                }
                                name.setText("deleted");
                                email.setText("deleted");
                                phone.setText("deleted");
                                username.setText("deleted");

                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Profile Deletiom");
                alert.show();
            }
        });

        home.setOnClickListener(v -> {
            Intent intent = new Intent(ViewProfileActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(ViewProfileActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(ViewProfileActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(ViewProfileActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(ViewProfileActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(ViewProfileActivity.this , CreateProfile.class);
            startActivity(intent);
        });
        list.setOnClickListener(v -> {
            Intent intent = new Intent(ViewProfileActivity.this , SearchProfile.class);
            startActivity(intent);
        });
        edit.setOnClickListener(v -> {
            Intent intent = new Intent(ViewProfileActivity.this, EditProfileActivity.class);
            String message = name.getText().toString();
            intent.putExtra(EXTRA_MESSAGE , message);
            String message1 = email.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1 , message1);
            String message2 = phone.getText().toString();
            intent.putExtra(EXTRA_MESSAGE2 , message2);
            String message3 = username.getText().toString();
            intent.putExtra(EXTRA_MESSAGE3 , message3);
            startActivity(intent);
        });


        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(ProfileAdapter.EXTRA_MESSAGE);

        //Captures the layout's TextView and set the string as its text
        TextView prof1 = findViewById(R.id.prof1);
        prof1.setText(message);

        String message1 = intent.getStringExtra(ProfileAdapter.EXTRA_MESSAGE2);

        //Captures the layout's TextView and set the string as its text
        TextView prof2 = findViewById(R.id.prof2);
        prof2.setText(message1);

        String message2 = intent.getStringExtra(ProfileAdapter.EXTRA_MESSAGE3);

        //Captures the layout's TextView and set the string as its text
        TextView prof3 = findViewById(R.id.prof3);
        prof3.setText(message2);

        String message3 = intent.getStringExtra(ProfileAdapter.EXTRA_MESSAGE1);

        //Captures the layout's TextView and set the string as its text
        TextView prof4 = findViewById(R.id.prof4);
        prof4.setText(message3);
    }
}