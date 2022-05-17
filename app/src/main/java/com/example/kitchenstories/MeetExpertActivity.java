package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MeetExpertActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "text1";
    public static final String EXTRA_MESSAGE1 = "text2";
    public static final String EXTRA_MESSAGE2 = "text3";
    public static final String EXTRA_MESSAGE3 = "text4";
    ImageView home , add , cart , expert , community , profile , addExpert , view1 , view2 , view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet_expert);

        home = findViewById(R.id.homeS6);
        add = findViewById(R.id.addS6);
        cart = findViewById(R.id.cartS6);
        expert = findViewById(R.id.expertS6);
        community = findViewById(R.id.communityS6);
        profile = findViewById(R.id.profileS6);
        addExpert = findViewById(R.id.addExpert);

        view1 = findViewById(R.id.profile1);
        view2 = findViewById(R.id.profile2);
        view3 = findViewById(R.id.profile3);


        home.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , CreateProfile.class);
            startActivity(intent);
        });

        addExpert.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , AddExpertActivity.class);
            startActivity(intent);
        });
        view1.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , DisplayExpertActivity.class);
            intent.putExtra("image", R.drawable.chathurika);
            TextView textView = findViewById(R.id.expert1);
            String message = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE , message);
            TextView textView1 = findViewById(R.id.expert2);
            String message1 = textView1.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1 , message1);
            String message2 = "Senior Chef";
            String message3 = "Hilton Hotel";
            intent.putExtra(EXTRA_MESSAGE2 , message2);
            intent.putExtra(EXTRA_MESSAGE3 , message3);

            startActivity(intent);
        });
        view2.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , DisplayExpertActivity.class);
            intent.putExtra("image", R.drawable.kapila);
            TextView textView = findViewById(R.id.expert3);
            String message = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE , message);
            TextView textView1 = findViewById(R.id.expert4);
            String message1 = textView1.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1 , message1);
            String message2 = "Senior Chef";
            String message3 = "Galadari Hotel";
            intent.putExtra(EXTRA_MESSAGE2 , message2);
            intent.putExtra(EXTRA_MESSAGE3 , message3);

            startActivity(intent);
        });
        view3.setOnClickListener(v -> {
            Intent intent = new Intent(MeetExpertActivity.this , DisplayExpertActivity.class);
            intent.putExtra("image", R.drawable.pabilis);
            TextView textView = findViewById(R.id.expert5);
            String message = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE , message);
            TextView textView1 = findViewById(R.id.expert6);
            String message1 = textView1.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1 , message1);
            String message2 = "Junior Chef";
            String message3 = "Kingsbery Hotel";
            intent.putExtra(EXTRA_MESSAGE2 , message2);
            intent.putExtra(EXTRA_MESSAGE3 , message3);

            startActivity(intent);
        });
    }
}