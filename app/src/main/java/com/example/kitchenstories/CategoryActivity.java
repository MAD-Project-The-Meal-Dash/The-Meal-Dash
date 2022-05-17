package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {
    ImageView summery ;
    ImageView home , add , cart , expert , community , imageView,goback;
    int imagevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        home = findViewById(R.id.homeMD1);
        add = findViewById(R.id.addMD1);
        cart = findViewById(R.id.chartMD1);
        expert = findViewById(R.id.expertMD1);
        community = findViewById(R.id.communityMD1);
        summery = findViewById(R.id.summeryMD);
        goback = findViewById(R.id.idimageViewback);

        summery.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this , SummaryOfRecipeActivity.class);
            startActivity(intent);
        });

        home.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        goback.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this , CreateProfile.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        String message = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE);
        TextView changeImg = findViewById(R.id.changeImg);
        changeImg.setText(message);


        String message1 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE1);
        TextView captionP = findViewById(R.id.captionP);
        captionP.setText(message1);

        String message2 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE2);
        TextView PastaRec1 = findViewById(R.id.PastaRec1);
        PastaRec1.setText(message2);

        String message3 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE3);
        TextView PastaRec2 = findViewById(R.id.PastaRec2);
        PastaRec2.setText(message3);

        String message4 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE4);
        TextView PastaRec3 = findViewById(R.id.PastaRec3);
        PastaRec3.setText(message4);

        String message5 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE5);
        TextView PastaRec4 = findViewById(R.id.PastaRec4);
        PastaRec4.setText(message5);

        String message6 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE6);
        TextView PastaRec5 = findViewById(R.id.PastaRec5);
        PastaRec5.setText(message6);


        String message7 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE7);
        TextView Create1 = findViewById(R.id.Create1);
        Create1.setText(message7);
        String message8 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE8);
        TextView Create2 = findViewById(R.id.Create2);
        Create2.setText(message8);
        String message9 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE9);
        TextView Create3 = findViewById(R.id.Create3);
        Create3.setText(message9);
        String message10 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE10);
        TextView Create4 = findViewById(R.id.Create4);
        Create4.setText(message10);
        String message11 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE11);
        TextView Create5 = findViewById(R.id.Create5);
        Create5.setText(message11);
        String message12 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE12);
        TextView Create6 = findViewById(R.id.Create6);
        Create6.setText(message12);
        String message13 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE13);
        TextView Create7 = findViewById(R.id.Create7);
        Create7.setText(message13);
        String message14 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE14);
        TextView Create8 = findViewById(R.id.Create8);
        Create8.setText(message14);
        String message15 = intent.getStringExtra(KitchenStoriesActivity.EXTRA_MESSAGE15);
        TextView Create9 = findViewById(R.id.Create9);
        Create9.setText(message15);

        // initialise the layout
        imageView = findViewById(R.id.kebabi);

        // check if any value sent from previous activity
        Bundle bundle = getIntent().getExtras();

        // if bundle is not null then get the image value
        if (bundle != null) {
            imagevalue = bundle.getInt("image");
        }
        imageView.setImageResource(imagevalue);
    }
}