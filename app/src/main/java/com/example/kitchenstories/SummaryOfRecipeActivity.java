package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.Calculations.MCalc;

public class SummaryOfRecipeActivity extends AppCompatActivity {

    ImageView home , add , cart , expert , community ,refresh;
    EditText Tdays , TRecipe  ;
    TextView total;
    int num1 , num2;

    MCalc mCalc = new MCalc();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_of_recipe);

        home = findViewById(R.id.homeMD);
        add = findViewById(R.id.addMD);
        cart = findViewById(R.id.cartMD);
        expert = findViewById(R.id.expertMD);
        community = findViewById(R.id.communityMD);
        refresh = findViewById(R.id.addC5);


        TRecipe = findViewById(R.id.idTotalRecipe);
        Tdays = findViewById(R.id.idTotalRecipePrice);
        total = findViewById(R.id.idTotalPrice);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryOfRecipeActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryOfRecipeActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryOfRecipeActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryOfRecipeActivity.this , DisplayExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryOfRecipeActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        refresh.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryOfRecipeActivity.this , SummaryOfRecipeActivity.class);
            startActivity(intent);
        });

    }
    public boolean getNumbers() {



        TRecipe = findViewById(R.id.idTotalRecipe);

        Tdays = findViewById(R.id.idTotalRecipePrice);

        String s1 = TRecipe.getText().toString();
        String s2 = Tdays.getText().toString();

        // condition to check if box is not empty
        if ((s1.equals(null) && s2.equals(null))
                || (s1.equals("") && s2.equals(""))) {

            String result = "Plz Enter";
            total.setText(result);

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
            double sum = mCalc.Calculatesummary(num1 ,num2 ,600.0);
            total.setText(Double.toString(sum));
        }
    }
}