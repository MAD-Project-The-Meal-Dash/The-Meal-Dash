package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RatingReviewActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "text1";
    public static final String EXTRA_MESSAGE1 = "text2";
    public static final String EXTRA_MESSAGE2 = "text3";
    ImageView home , add , cart , expert , community, profile , appSupport , writeReview, view1;
    TextView writeRev, appSup, seeAllList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_review);

        home = findViewById(R.id.homeT8);
        add = findViewById(R.id.addT8);
        cart = findViewById(R.id.cartT8);
        expert = findViewById(R.id.expertT8);
        community = findViewById(R.id.communityT8);
        profile = findViewById(R.id.profileT8);
        appSupport = findViewById(R.id.appSup);
        writeReview = findViewById(R.id.write);
        view1 = findViewById(R.id.picT1);
        writeRev = findViewById(R.id.writeR);
        appSup = findViewById(R.id.appS);
        seeAllList = findViewById(R.id.seeAll);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , CreateProfile.class);
            startActivity(intent);
        });

        appSupport.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , AppSupportActivity.class);
            startActivity(intent);
        });

        writeReview.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , WriteReviewActivity.class);
            startActivity(intent);
        });

        appSup.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , AppSupportActivity.class);
            startActivity(intent);
        });

        writeRev.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , WriteReviewActivity.class);
            startActivity(intent);
        });

        seeAllList.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , ListReviewActivity.class);
            startActivity(intent);
        });

        view1.setOnClickListener(v -> {
            Intent intent = new Intent(RatingReviewActivity.this , CustomerDetailsViewActivity.class);
            intent.putExtra("image", R.drawable.cus1);
            TextView textView = findViewById(R.id.cusName);
            String message = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE , message);
            TextView textView1 = findViewById(R.id.revTitle);
            String message1 = textView1.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1 , message1);
            TextView textView2 = findViewById(R.id.cusComment);
            String message2 = textView2.getText().toString();
            intent.putExtra(EXTRA_MESSAGE2 , message2);
            startActivity(intent);
        });


    }
}