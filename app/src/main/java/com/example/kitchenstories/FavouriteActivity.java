package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FavouriteActivity extends AppCompatActivity {
    ImageView home , add , cart , expert , community ,menuu, profile,imageView;
    int imagevalue;
    Button ADD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        home = findViewById(R.id.homeC5);
        add = findViewById(R.id.addC5);
        cart = findViewById(R.id.cartC5);
        expert = findViewById(R.id.expertC5);
        community = findViewById(R.id.communityC5);
 
        //profile = findViewById(R.id.profilesC0);
        ADD=findViewById(R.id.c2_button1);
     
        //c5_imageView1=findViewById(R.id.findViewById(R.id.menuu1C2);
 


 

        home.setOnClickListener(v -> {
            Intent intent = new Intent(FavouriteActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(FavouriteActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(FavouriteActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(FavouriteActivity.this , DisplayExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(FavouriteActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        ADD.setOnClickListener(v -> {
            Intent intent = new Intent(FavouriteActivity.this , AddCartActivity.class);
            startActivity(intent);
        });

        /*profile.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this , CreateProfile.class);
            startActivity(intent);
        });*/


       /* Intent intent = getIntent();
        String message = intent.getStringExtra(TopFoodsActivity.EXTRA_MESSAGE);
        TextView FYFname1 = findViewById(R.id.FYFname1);
        FYFname1.setText(message);


        String message1 = intent.getStringExtra(TopFoodsActivity.EXTRA_MESSAGE1);
        TextView TFprice1 = findViewById(R.id.TFprice1);
        TFprice1.setText(message1);
        imageView = findViewById(R.id.imageView98);
// check if any value sent from previous activity
        Bundle bundle = getIntent().getExtras();
// if bundle is not null then get the image value
        if (bundle != null) {
            imagevalue = bundle.getInt("image");
        }
        imageView.setImageResource(imagevalue);*/






    }
}
