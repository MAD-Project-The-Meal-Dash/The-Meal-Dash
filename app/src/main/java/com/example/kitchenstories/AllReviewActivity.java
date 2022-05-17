package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class AllReviewActivity extends AppCompatActivity {
    ImageView home , add , cart , expert , community , back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_review);

        home = findViewById(R.id.homeT8);
        add = findViewById(R.id.addT8);
        cart = findViewById(R.id.cartT8);
        expert = findViewById(R.id.expertT8);
        community = findViewById(R.id.communityT8);
        back = findViewById(R.id.pBack);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(AllReviewActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(AllReviewActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(AllReviewActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(AllReviewActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(AllReviewActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent(AllReviewActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });
    }
}
