package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayExpertActivity extends AppCompatActivity {
    ImageView home , add , cart , expert , community , profile , addExpert , imageView;
    Button hire;
    int imagevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_expert);

        home = findViewById(R.id.homeS3);
        add = findViewById(R.id.addS3);
        cart = findViewById(R.id.cartS6);
        expert = findViewById(R.id.expertS6);
        community = findViewById(R.id.communityS6);
        profile = findViewById(R.id.profileS3);
        addExpert = findViewById(R.id.addExpert1);
        hire = findViewById(R.id.btnRegister);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(DisplayExpertActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(DisplayExpertActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(DisplayExpertActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(DisplayExpertActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(DisplayExpertActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(DisplayExpertActivity.this , CreateProfile.class);
            startActivity(intent);
        });

        addExpert.setOnClickListener(v -> {
            Intent intent = new Intent(DisplayExpertActivity.this , AddExpertActivity.class);
            startActivity(intent);
        });

        hire.setOnClickListener(v -> {
            Intent intent = new Intent(DisplayExpertActivity.this , ExpertCalculation.class);
            startActivity(intent);
        });

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MeetExpertActivity.EXTRA_MESSAGE);

        //Captures the layout's TextView and set the string as its text
        TextView dexpert1 = findViewById(R.id.dexpert1);
        dexpert1.setText(message);

        String message1 = intent.getStringExtra(MeetExpertActivity.EXTRA_MESSAGE1);

        //Captures the layout's TextView and set the string as its text
        TextView dexpert2 = findViewById(R.id.dexpert2);
        dexpert2.setText(message1);

        String message2 = intent.getStringExtra(MeetExpertActivity.EXTRA_MESSAGE2);

        //Captures the layout's TextView and set the string as its text
        TextView dexpert3 = findViewById(R.id.dexpert3);
        dexpert3.setText(message2);

        String message3 = intent.getStringExtra(MeetExpertActivity.EXTRA_MESSAGE3);

        //Captures the layout's TextView and set the string as its text
        TextView dexpert4 = findViewById(R.id.dexpert4);
        dexpert4.setText(message3);

        // initialise the layout
        imageView = findViewById(R.id.isr);

        // check if any value sent from previous activity
        Bundle bundle = getIntent().getExtras();

        // if bundle is not null then get the image value
        if (bundle != null) {
            imagevalue = bundle.getInt("image");
        }
        imageView.setImageResource(imagevalue);
    }


}