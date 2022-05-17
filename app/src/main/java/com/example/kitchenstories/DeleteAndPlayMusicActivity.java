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
import com.database.ExpertDBHelper;

public class DeleteAndPlayMusicActivity extends AppCompatActivity {
    EditText name;
    Button delete , play;

    ImageView home , add , cart , expert , community;

    AlertDialog.Builder builder;

    //Import DB
    ExpertDBHelper DB;

    MediaPlayer music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_and_play_music);

        // Adding the music file to our
        // newly created object music
        music = MediaPlayer.create(this, R.raw.soundexpert);

        home = findViewById(R.id.homeS6);
        add = findViewById(R.id.addS6);
        cart = findViewById(R.id.cartS6);
        expert = findViewById(R.id.expertS6);
        community = findViewById(R.id.communityS6);

        name = findViewById(R.id.playEdit);
        delete = findViewById(R.id.playDelete);
        play = findViewById(R.id.playMusic);

        DB = new ExpertDBHelper(DeleteAndPlayMusicActivity.this);
        builder = new AlertDialog.Builder(this);

        //DELETION TO DATABASE
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();

                if(Name.equals(""))
                    Toast.makeText(DeleteAndPlayMusicActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

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
                                Boolean deletion = DB.deleteInfo(Name);
                                if (deletion==true) {
                                    Toast.makeText(DeleteAndPlayMusicActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(DeleteAndPlayMusicActivity.this, "Deleting failed", Toast.LENGTH_SHORT).show();
                                }
                                name.setText("");

                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Expert Deletion");
                alert.show();
            }
        });
        play.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteAndPlayMusicActivity.this , ListExpertsActivity.class);
            startActivity(intent);
        });

        Intent intent1 = getIntent();
        String message = intent1.getStringExtra(ExpertAdapter.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.playEdit);
        textView.setText(message);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteAndPlayMusicActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteAndPlayMusicActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteAndPlayMusicActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteAndPlayMusicActivity.this , MeetExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteAndPlayMusicActivity.this , RatingReviewActivity.class);
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
        music = MediaPlayer.create(this, R.raw.soundexpert);
    }

}