package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomerDetailsViewActivity extends AppCompatActivity {
    ImageView home , add , cart , expert , community , back , imageView;
    int imagevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details_view);

        home = findViewById(R.id.homeT8);
        add = findViewById(R.id.addT8);
        cart = findViewById(R.id.cartT8);
        expert = findViewById(R.id.expertT8);
        community = findViewById(R.id.communityT8);
        back = findViewById(R.id.pBack);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(CustomerDetailsViewActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(CustomerDetailsViewActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(CustomerDetailsViewActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(CustomerDetailsViewActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(CustomerDetailsViewActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent(CustomerDetailsViewActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(RatingReviewActivity.EXTRA_MESSAGE);

        //Captures the layout's TextView and set the string as its text
        TextView pCusName = findViewById(R.id.pCusName);
        pCusName.setText(message);

        String message1 = intent.getStringExtra(RatingReviewActivity.EXTRA_MESSAGE1);

        //Captures the layout's TextView and set the string as its text
        TextView PrevTitle = findViewById(R.id.PrevTitle);
        PrevTitle.setText(message1);

        String message2 = intent.getStringExtra(RatingReviewActivity.EXTRA_MESSAGE2);

        //Captures the layout's TextView and set the string as its text
        TextView pCusComment = findViewById(R.id.pCusComment);
        pCusComment.setText(message2);

        // initialise the layout
        imageView = findViewById(R.id.pCusPic);

        // check if any value sent from previous activity
        Bundle bundle = getIntent().getExtras();

        // if bundle is not null then get the image value
        if (bundle != null) {
            imagevalue = bundle.getInt("image");
        }
        imageView.setImageResource(imagevalue);
    }


}