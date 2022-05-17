package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.Calculations.RevCalc;


public class ReviewCalculation extends AppCompatActivity {
    ImageView home , add , cart , expert , community , back;
    EditText month, revPerMonth;
    TextView  tot;
    int num1, num2;

    RevCalc rCalc = new RevCalc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_calculation);

        home = findViewById(R.id.homeT8);
        add = findViewById(R.id.addT8);
        cart = findViewById(R.id.cartT8);
        expert = findViewById(R.id.expertT8);
        community = findViewById(R.id.communityT8);
        back = findViewById(R.id.pBack);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewCalculation.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewCalculation.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewCalculation.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewCalculation.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewCalculation.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewCalculation.this , RatingReviewActivity.class);
            startActivity(intent);
        });
    }
    // a public method to get the input numbers
    public boolean getNumbers() {

        month = findViewById(R.id.revCal3);
        revPerMonth = findViewById(R.id.revCal2);

        tot = findViewById(R.id.revCal4);

        String s1 = month.getText().toString();
        String s2 = revPerMonth.getText().toString();

        // condition to check if box is not empty
        if ((s1.equals(null) && s2.equals(null))
                || (s1.equals("") && s2.equals(""))) {

            String result = "Plz Enter";
            tot.setText(result);

            return false;
        } else {
            // converting string to double.
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);

        }

        return true;
    }
    // a public method to perform addition
    public void calc(View v) {

        // get the input numbers
        if (getNumbers()) {
            double sum = rCalc.calculateTotalReview(num1 ,num2 ,0.7);
            tot.setText(Double.toString(sum));
        }
    }


}