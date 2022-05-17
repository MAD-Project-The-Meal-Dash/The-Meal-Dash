package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class KitchenStoriesActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "FoodName";
    public static final String EXTRA_MESSAGE1 = "caption";
    public static final String EXTRA_MESSAGE2 = "rec1";
    public static final String EXTRA_MESSAGE3 = "rec2";
    public static final String EXTRA_MESSAGE4 = "rec3";
    public static final String EXTRA_MESSAGE5 = "rec4";
    public static final String EXTRA_MESSAGE6 = "rec5";
    public static final String EXTRA_MESSAGE7 = "create1";
    public static final String EXTRA_MESSAGE8 = "create2";
    public static final String EXTRA_MESSAGE9 = "create3";
    public static final String EXTRA_MESSAGE10 = "create4";
    public static final String EXTRA_MESSAGE11 = "create5";
    public static final String EXTRA_MESSAGE12 = "create6";
    public static final String EXTRA_MESSAGE13 = "create7";
    public static final String EXTRA_MESSAGE14 = "create8";
    public static final String EXTRA_MESSAGE15 = "create9";




    ImageView home , add , cart , expert , community , profile ,pastaMD , KebabMD , GarlicMD, ThanduriMD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_stories);

        home = findViewById(R.id.homeM0);
        add = findViewById(R.id.addM0);
        cart = findViewById(R.id.homeS6);
        expert = findViewById(R.id.addS6);
        community = findViewById(R.id.communityM0);

        KebabMD = findViewById(R.id.KebabMD);
        GarlicMD = findViewById(R.id.GarlicMD);
        ThanduriMD = findViewById(R.id.ThanduriMD);
        profile = findViewById(R.id.profileM0);
        pastaMD = findViewById(R.id.pastaMD);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this , CreateProfile.class);
            startActivity(intent);
        });

        KebabMD.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this, CategoryActivity.class);
            intent.putExtra("image", R.drawable.picone);
            TextView textView = findViewById(R.id.FoodName1);
            String message = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            TextView textView1 = findViewById(R.id.FoodName1);
            String message1 = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1, message1);
            String message2 = ("Bacon");
            intent.putExtra(EXTRA_MESSAGE2, message2);
            String message3 = ("Garlic");
            intent.putExtra(EXTRA_MESSAGE3, message3);
            String message4 = ("Onion");
            intent.putExtra(EXTRA_MESSAGE4, message4);
            String message5 = ("Beef or lamb");
            intent.putExtra(EXTRA_MESSAGE5, message5);
            String message6 = ("NON-PORK SUBSTITUTES");
            intent.putExtra(EXTRA_MESSAGE6, message6);
            String message7 = ("rapeseed oil");
            intent.putExtra(EXTRA_MESSAGE7, message7);
            String message8 = ("lean lamb mince");
            intent.putExtra(EXTRA_MESSAGE8, message8);
            String message9 = ("garlic cloves");
            intent.putExtra(EXTRA_MESSAGE9, message9);
            String message10 = ("crushed");
            intent.putExtra(EXTRA_MESSAGE10, message10);
            String message11 = ("ground cumin");
            intent.putExtra(EXTRA_MESSAGE11, message11);
            String message12 = (" ground coriander");
            intent.putExtra(EXTRA_MESSAGE12, message12);
            String message13 = ("onion powder");
            intent.putExtra(EXTRA_MESSAGE13, message13);
            String message14 = ("smoked paprika");
            intent.putExtra(EXTRA_MESSAGE14, message14);
            String message15 = ("sea salt");
            intent.putExtra(EXTRA_MESSAGE15, message15);
            startActivity(intent);

        });
        ThanduriMD.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this, CategoryActivity.class);
            intent.putExtra("image", R.drawable.picfour);
            TextView textView = findViewById(R.id.FoodName4);
            String message = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            TextView textView1 = findViewById(R.id.FoodName4);
            String message1 = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1, message1);
            String message2 = ("vegetable oil");
            intent.putExtra(EXTRA_MESSAGE2, message2);
            String message3 = ("ground coriander");
            intent.putExtra(EXTRA_MESSAGE3, message3);
            String message4 = ("ground cumin");
            intent.putExtra(EXTRA_MESSAGE4, message4);
            String message5 = ("cayenne");
            intent.putExtra(EXTRA_MESSAGE5, message5);
            String message6 = ("garam masala");
            intent.putExtra(EXTRA_MESSAGE6, message6);
            String message7 = ("Heat the spices in oil");
            intent.putExtra(EXTRA_MESSAGE7, message7);
            String message8 = ("Whisk spices into yogurt");
            intent.putExtra(EXTRA_MESSAGE8, message8);
            String message9 = ("Cut deep");
            intent.putExtra(EXTRA_MESSAGE9, message9);
            String message10 = ("slashes into chicken");
            intent.putExtra(EXTRA_MESSAGE10, message10);
            String message11 = ("coat with marinade");
            intent.putExtra(EXTRA_MESSAGE11, message11);
            String message12 = ("Prepare grill");
            intent.putExtra(EXTRA_MESSAGE12, message12);
            String message13 = ("Shake off excess marinade");
            intent.putExtra(EXTRA_MESSAGE13, message13);
            String message14 = ("Move to cool side of grill");
            intent.putExtra(EXTRA_MESSAGE14, message14);
            String message15 = ("cover and cook");
            intent.putExtra(EXTRA_MESSAGE15, message15);
            startActivity(intent);

        });
        pastaMD.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this, CategoryActivity.class);
            intent.putExtra("image", R.drawable.picthree);
            TextView textView = findViewById(R.id.FoodName3);
            String message = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            TextView textView1 = findViewById(R.id.FoodName3);
            String message1 = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1, message1);
            String message2 = ("Legume  Pasta");
            intent.putExtra(EXTRA_MESSAGE2, message2);
            String message3 = ("Sometimes eggs");
            intent.putExtra(EXTRA_MESSAGE3, message3);
            String message4 = ("Drum wheat flour");
            intent.putExtra(EXTRA_MESSAGE4, message4);
            String message5 = ("Butter");
            intent.putExtra(EXTRA_MESSAGE5, message5);
            String message6 = ("Rice flour Pasta");
            intent.putExtra(EXTRA_MESSAGE6, message6);
            String message7 = ("Boil Water");
            intent.putExtra(EXTRA_MESSAGE7, message7);
            String message8 = ("Add Salt");
            intent.putExtra(EXTRA_MESSAGE8, message8);
            String message9 = ("Add The Pasta");
            intent.putExtra(EXTRA_MESSAGE9, message9);
            String message10 = ("Stir");
            intent.putExtra(EXTRA_MESSAGE10, message10);
            String message11 = ("Taste the Pasta");
            intent.putExtra(EXTRA_MESSAGE11, message11);
            String message12 = ("Drain");
            intent.putExtra(EXTRA_MESSAGE12, message12);
            String message13 = ("Removing Ravioli");
            intent.putExtra(EXTRA_MESSAGE13, message13);
            String message14 = ("Stir in the Sauce");
            intent.putExtra(EXTRA_MESSAGE14, message14);
            String message15 = ("Add Pasta Water");
            intent.putExtra(EXTRA_MESSAGE15, message15);

            startActivity(intent);

        });
        GarlicMD.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenStoriesActivity.this, CategoryActivity.class);
            intent.putExtra("image", R.drawable.pictwo);
            TextView textView = findViewById(R.id.FoodName2);
            String message = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            TextView textView1 = findViewById(R.id.FoodName2);
            String message1 = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1, message1);
            String message2 = ("skinless chicken thighs");
            intent.putExtra(EXTRA_MESSAGE2, message2);
            String message3 = ("teaspoon salt");
            intent.putExtra(EXTRA_MESSAGE3, message3);
            String message4 = ("teaspoon pepper");
            intent.putExtra(EXTRA_MESSAGE4, message4);
            String message5 = ("tablespoon olive oil");
            intent.putExtra(EXTRA_MESSAGE5, message5);
            String message6 = ("garlic cloves,peeled and halved");
            intent.putExtra(EXTRA_MESSAGE6, message6);
            String message7 = ("Crush It");
            intent.putExtra(EXTRA_MESSAGE7, message7);
            String message8 = ("Spread It");
            intent.putExtra(EXTRA_MESSAGE8, message8);
            String message9 = ("Roast It");
            intent.putExtra(EXTRA_MESSAGE9, message9);
            String message10 = ("Let It Be");
            intent.putExtra(EXTRA_MESSAGE10, message10);
            String message11 = ("Blend It");
            intent.putExtra(EXTRA_MESSAGE11, message11);
            String message12 = ("Boil It");
            intent.putExtra(EXTRA_MESSAGE12, message12);
            String message13 = ("Diversify It");
            intent.putExtra(EXTRA_MESSAGE13, message13);
            String message14 = ("Smell It");
            intent.putExtra(EXTRA_MESSAGE14, message14);
            String message15 = ("Combine It");
            intent.putExtra(EXTRA_MESSAGE15, message15);
            startActivity(intent);

        });
    }

}