package com.example.kitchenstories;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.database.RecipeDBHelper;
import com.database.RecipeModal;
import java.util.ArrayList;

public class RecipeListOfActivity extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    ArrayList<RecipeModal> recipeModalArrayList;
    RecipeDBHelper recipeDBHelper;
    RecipeAdapter recipeAdapter;
    RecyclerView  recipesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list_of);

        // initializing our all variables.
        recipeModalArrayList = new ArrayList<>();
        recipeDBHelper = new RecipeDBHelper(RecipeListOfActivity.this);

        // getting our course array
        // list from db handler class.
        recipeModalArrayList = recipeDBHelper.readRecipes();

        // on below line passing our array lost to our adapter class.
        recipeAdapter = new RecipeAdapter(recipeModalArrayList, RecipeListOfActivity.this);
        recipesRV = findViewById(R.id.listrecipes);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecipeListOfActivity.this, RecyclerView.VERTICAL, false);
        recipesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        recipesRV.setAdapter(recipeAdapter);
    }
}
