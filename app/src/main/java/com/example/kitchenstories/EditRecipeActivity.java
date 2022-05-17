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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.database.RecipeDBHelper;

public class EditRecipeActivity extends AppCompatActivity {
    EditText name1 , name2 , name3 , name4 , name5 , name6 , name7 , name8 , name9 , name10 , name11 ;
    Button saveM1 , editM1;
    ImageView home , add , cart , expert , community , imageView ,goback;
    TextView r;
    private static final int CAMERA_REQUEST = 1888;

    AlertDialog.Builder builder;

    //Import DB
    RecipeDBHelper DBM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);

        home = findViewById(R.id.homeMD1);
        add = findViewById(R.id.addMD1);
        cart = findViewById(R.id.chartMD1);
        expert = findViewById(R.id.expertMD1);
        community = findViewById(R.id.communityMD1);
        goback = findViewById(R.id.imageViewgoprof);

        name1 = findViewById(R.id.editTextRecipe1);
        name2 = findViewById(R.id.editTextRecipe2);
        name3 = findViewById(R.id.editTextRecipe3);
        name4 = findViewById(R.id.editTextRecipe4);
        name5 = findViewById(R.id.editTextRecipe5);
        name6 = findViewById(R.id.editTextRecipe6);
        name7 = findViewById(R.id.editTextRecipe7);
        name8 = findViewById(R.id.editTextRecipe8);
        name9 = findViewById(R.id.editTextRecipe9);
        name10 = findViewById(R.id.editTextRecipe10);
        name11 = findViewById(R.id.editTextRecipe11);

        saveM1 = findViewById(R.id.saveEditRecepe);
        editM1 = findViewById(R.id.goBackList);

        DBM = new RecipeDBHelper(EditRecipeActivity.this);
        builder = new AlertDialog.Builder(this);

        saveM1.setOnClickListener(new View.OnClickListener() { //ADDITION TO DATABASE
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
                    Toast.makeText(EditRecipeActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to edit ?") .setTitle("Expert Registration");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to edit ?")
                        .setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"Editing Discarded",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Boolean update = DBM.updateInfo(Name1, Name2, Name3, Name4, Name5, Name6, Name7, Name8, Name9, Name10, Name11);
                                if (update==true) {
                                    Toast.makeText(EditRecipeActivity.this, "Edited successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(EditRecipeActivity.this, "Editing failed", Toast.LENGTH_SHORT).show();
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
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Expert Registration");
                alert.show();

            }

        });
        editM1.setOnClickListener(v -> {
            Intent intent = new Intent(EditRecipeActivity.this , RecipeListOfActivity.class);
            startActivity(intent);
        });


        //Get the Intent that started this activity and extract the string
        Intent intent1 = getIntent();
        String message = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE);

        //Captures the layout's TextView and set the string as its text
        TextView text01 = findViewById(R.id.editTextRecipe1);
        text01.setText(message);

        String message1 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE1);

        //Captures the layout's TextView and set the string as its text
        TextView text02 = findViewById(R.id.editTextRecipe2);
        text02.setText(message1);

        String message2 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE2);

        //Captures the layout's TextView and set the string as its text
        TextView text03 = findViewById(R.id.editTextRecipe3);
        text03.setText(message2);

        String message3 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE3);

        //Captures the layout's TextView and set the string as its text
        TextView text04 = findViewById(R.id.editTextRecipe4);
        text04.setText(message3);

        String message4 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE4);

        //Captures the layout's TextView and set the string as its text
        TextView text05 = findViewById(R.id.editTextRecipe5);
        text05.setText(message4);

        String message5 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE5);

        //Captures the layout's TextView and set the string as its text
        TextView text06 = findViewById(R.id.editTextRecipe6);
        text06.setText(message5);

        String message6 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE6);

        //Captures the layout's TextView and set the string as its text
        TextView text07 = findViewById(R.id.editTextRecipe7);
        text07.setText(message6);

        String message7 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE7);

        //Captures the layout's TextView and set the string as its text
        TextView text08 = findViewById(R.id.editTextRecipe8);
        text08.setText(message7);

        String message8 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE8);

        //Captures the layout's TextView and set the string as its text
        TextView text09 = findViewById(R.id.editTextRecipe9);
        text09.setText(message8);

        String message9 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE9);

        //Captures the layout's TextView and set the string as its text
        TextView text010 = findViewById(R.id.editTextRecipe10);
        text010.setText(message9);

        String message10 = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE10);

        //Captures the layout's TextView and set the string as its text
        TextView text011 = findViewById(R.id.editTextRecipe11);
        text011.setText(message10);


        home.setOnClickListener(v -> {
            Intent intent = new Intent(EditRecipeActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(EditRecipeActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(EditRecipeActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(EditRecipeActivity.this , DisplayExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(EditRecipeActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        goback.setOnClickListener(v -> {
            Intent intent = new Intent(EditRecipeActivity.this , CreateProfile.class);
            startActivity(intent);
        });

        imageView = findViewById((R.id.editImageViewRecipe));
        TextView photoButton = findViewById(R.id.takeEditPhtoRecipe);

        photoButton.setOnClickListener(v -> {
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
