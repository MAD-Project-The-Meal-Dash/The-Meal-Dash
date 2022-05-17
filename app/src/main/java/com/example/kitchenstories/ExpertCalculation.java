package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.Calculations.ECalc;

public class ExpertCalculation extends AppCompatActivity {
    ImageView home , add , cart , expert , community , profile;
    EditText hours , voucher;
    TextView  tot;
    int num1, num2;

    ECalc eCalc = new ECalc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_calculation);

        home = findViewById(R.id.homeS6);
        add = findViewById(R.id.addS6);
        cart = findViewById(R.id.cartS6);
        expert = findViewById(R.id.expertS6);
        community = findViewById(R.id.communityS6);
        profile = findViewById(R.id.profileS6);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(ExpertCalculation.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(ExpertCalculation.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(ExpertCalculation.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(ExpertCalculation.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(ExpertCalculation.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(ExpertCalculation.this , CreateProfile.class);
            startActivity(intent);
        });
    }
    // a public method to get the input numbers
    public boolean getNumbers() {

        hours = findViewById(R.id.calEx1);

        voucher = findViewById(R.id.calEx3);

        tot = findViewById(R.id.calEx5);

        String s1 = hours.getText().toString();
        String s2 = voucher.getText().toString();

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
            double sum = eCalc.calculateTotal(num1 , num2  , 0.5 , 500);
            tot.setText(Double.toString(sum));
        }
    }


}