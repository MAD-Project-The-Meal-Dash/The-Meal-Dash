package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.database.RecipeDBHelper;

public class DeleteWithPlayMusicActivity extends AppCompatActivity {
    EditText name1;
    Button deleteR , playR;

    ImageView home , add , cart , expert , community;

    AlertDialog.Builder builder;

    //Import DB
    RecipeDBHelper DBM;

    MediaPlayer music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_with_play_music);

        // Adding the music file to our
        // newly created object music
        music = MediaPlayer.create(this, R.raw.mysongdelete);

        home = findViewById(R.id.homeMD11);
        add = findViewById(R.id.addMD22);
        cart = findViewById(R.id.cartMD33);
        expert = findViewById(R.id.expertMD44);
        community = findViewById(R.id.communityMD55);

        name1 = findViewById(R.id.editTextTextPersonName);
        deleteR = findViewById(R.id.playDeleteRecipe);
        playR = findViewById(R.id.playMusicDeleteRecipe);

        DBM = new RecipeDBHelper(DeleteWithPlayMusicActivity.this);
        builder = new AlertDialog.Builder(this);

        //DELETION TO DATABASE
        deleteR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name1 = name1.getText().toString();

                if(Name1.equals(""))
                    Toast.makeText(DeleteWithPlayMusicActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to delete ?") .setTitle("Expert Deletion");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to delete ?")
                        .setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"Deletion Discarded",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Boolean deletion = DBM.deleteInfo(Name1);
                                if (deletion==true) {
                                    Toast.makeText(DeleteWithPlayMusicActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(DeleteWithPlayMusicActivity.this, "Deleting failed", Toast.LENGTH_SHORT).show();
                                }
                                name1.setText("");

                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Recipe Registration");
                alert.show();
            }
        });
        playR.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteWithPlayMusicActivity.this , RecipeListOfActivity.class);
            startActivity(intent);
        });

        Intent intent1 = getIntent();
        String message = intent1.getStringExtra(RecipeAdapter.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.editTextTextPersonName);
        textView.setText(message);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteWithPlayMusicActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteWithPlayMusicActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteWithPlayMusicActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteWithPlayMusicActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteWithPlayMusicActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

    }
    // Plaing the music
    public void musicplay(View v)
    {
        music.start();
    }

    // Pausing the music
    public void musicpause(View v)
    {
        music.pause();
    }

    // Stoping the music
    public void musicstop(View v)
    {
        music.stop();
        music = MediaPlayer.create(this, R.raw.mysongdelete);
    }

}