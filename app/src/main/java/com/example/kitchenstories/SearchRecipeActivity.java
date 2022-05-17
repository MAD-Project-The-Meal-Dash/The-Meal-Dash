package com.example.kitchenstories;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.database.RecipeDBHelper;
import com.database.RecipeModal;

import java.util.ArrayList;

public class SearchRecipeActivity extends AppCompatActivity {

    // creating variables for
    // our ui components.
    private RecyclerView profileRV;
    RecipeDBHelper recipeDBHelper;

    // variable for our adapter
    // class and array list
    private RecipeAdapter adapter;
    private ArrayList<RecipeModal> recipeModalArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipe);

        // initializing our variables.
        profileRV = findViewById(R.id.idSearchRecipe);

        // calling method to
        // build recycler view.
        buildRecyclerView();
    }

    // calling on create option menu
    // layout to inflate our menu file.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_recipe_list, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.idactionSearchRecipe);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<RecipeModal> filteredlist = new ArrayList<>();

        // running a for loop to compare elements.
        for (RecipeModal item : recipeModalArrayList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getName1().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }

    private void buildRecyclerView() {

        // below line we are creating a new array list
        recipeModalArrayList = new ArrayList<>();
        recipeDBHelper = new RecipeDBHelper(SearchRecipeActivity.this);

        // list from db handler class.
        recipeModalArrayList = recipeDBHelper.readRecipes();

//        // below line is to add data to our array list.
//        profileModalArrayList.add(new ProfileModal("Sahan", "0776135690" , "Sandaru" , "kumarasirisahan@gmail.com"));
//        profileModalArrayList.add(new ProfileModal("Thamali", "0770113437" , "Sweet Thamali" , "tnirmala@gmail.com"));
//        profileModalArrayList.add(new ProfileModal("Nethmi", "0776135450" , "Nethu" , "nethmi@gmail.com"));
//        profileModalArrayList.add(new ProfileModal("Amaya", "0779222162" , "Ama" , "amayasrimani@gmail.com"));
//        profileModalArrayList.add(new ProfileModal("Mithila", "0705935690" , "Wasthu" , "mithila@gmail.com"));

        // initializing our adapter class.
        adapter = new RecipeAdapter(recipeModalArrayList, SearchRecipeActivity.this);

        // adding layout manager to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        profileRV.setHasFixedSize(true);

        // setting layout manager
        // to our recycler view.
        profileRV.setLayoutManager(manager);

        // setting adapter to
        // our recycler view.
        profileRV.setAdapter(adapter);
    }
}