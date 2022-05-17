package com.example.kitchenstories;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.database.RecipeDBHelper;


public class AddRecipeActivity extends AppCompatActivity {
    ImageView home , add , cart , expert , community , imageView,goback ;
    EditText name1 , name2 , name3 , name4 , name5 , name6 , name7 , name8 , name9 , name10 , name11;
    Button saveAdd , ButtonListRecipe;
    TextView m;
    ImageButton search;
    private static final int CAMERA_REQUEST = 1888;

    AlertDialog.Builder builderM;

    //Import DB
    RecipeDBHelper DBM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        home = findViewById(R.id.homeMD);
        add = findViewById(R.id.addMD);
        cart = findViewById(R.id.cartMD);
        expert = findViewById(R.id.expertMD);
        community = findViewById(R.id.communityMD);
        goback = findViewById(R.id.imageViewgoprof);

        name1 = findViewById(R.id.ingr1);
        name2 = findViewById(R.id.ingr2);
        name3 = findViewById(R.id.ingr3);
        name4 = findViewById(R.id.ingr4);
        name5 = findViewById(R.id.ingr5);
        name6 = findViewById(R.id.ingr6);
        name7 = findViewById(R.id.ingr7);
        name8 = findViewById(R.id.ingr8);
        name9 = findViewById(R.id.ingr9);
        name10 = findViewById(R.id.ingr10);
        name11 = findViewById(R.id.ingr11);

        saveAdd = findViewById(R.id.saveRecipe);
        ButtonListRecipe =findViewById(R.id.buttonListRecipe);
        search = findViewById(R.id.idFindlistValue);

        DBM = new RecipeDBHelper(AddRecipeActivity.this);
        builderM = new AlertDialog.Builder(this);

        saveAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name1 = name1.getText().toString();
                String Name2 = name2.getText().toString();
                String Name3 = name3.getText().toString();
                String Name4 = name4.getText().toString();
                String Name5 = name5.getText().toString();
                String Name6 = name6.getText().toString();
                String Name7 = name7.getText().toString();
                String Name8 = name8.getText().toString();
                String Name9 = name9.getText().toString();
                String Name10 = name10.getText().toString();
                String Name11 = name11.getText().toString();

                if(Name1.equals("")||Name2.equals("")||Name3.equals("")||Name4.equals("")||Name5.equals("")||Name6.equals("")||Name7.equals("")||Name8.equals("")||Name9.equals("")||Name10.equals("")||Name11.equals(""))
                    Toast.makeText(AddRecipeActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builderM.setMessage("Do you want to Add recipe ?") .setTitle("Add Recipes");

                //Setting message manually and performing action on button click
                builderM.setMessage("Do you want to Add recipe ?")
                        .setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"Recipe Discarded",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Boolean insert = DBM.addInfo(Name1, Name2, Name3, Name4, Name5,Name6, Name7, Name8, Name9, Name10, Name11);
                                if (insert==true) {
                                    Toast.makeText(AddRecipeActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(AddRecipeActivity.this, "Adding failed", Toast.LENGTH_SHORT).show();
                                }
                                name1.setText("");
                                name2.setText("");
                                name3.setText("");
                                name4.setText("");
                                name5.setText("");
                                name6.setText("");
                                name7.setText("");
                                name8.setText("");
                                name9.setText("");
                                name10.setText("");
                                name11.setText("");

                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builderM.create();
                //Setting the title manually
                alert.setTitle("Add Recipes");
                alert.show();

            }

        });


        home.setOnClickListener(v -> {
            Intent intent = new Intent(AddRecipeActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(AddRecipeActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(AddRecipeActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(AddRecipeActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });
        ButtonListRecipe.setOnClickListener(v -> {
            Intent intent = new Intent(AddRecipeActivity.this , RecipeListOfActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(AddRecipeActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        search.setOnClickListener(v -> {
            Intent intent = new Intent(AddRecipeActivity.this , SearchRecipeActivity.class);
            startActivity(intent);
        });

        goback.setOnClickListener(v -> {
            Intent intent = new Intent(AddRecipeActivity.this , CreateProfile.class);
            startActivity(intent);
        });

        imageView = findViewById((R.id.takephotoM));
        TextView photoText = findViewById(R.id.clipPhotoM);

        photoText.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent , CAMERA_REQUEST);
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_REQUEST){
            assert data != null;
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}