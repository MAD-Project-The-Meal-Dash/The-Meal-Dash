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

import com.database.CartDBHelper;
import com.database.ExpertDBHelper;

public class DeleteCartActivity extends AppCompatActivity {
    ImageView home , add , cart , expert , community ,menuu, profile,imageView;
    EditText name;
    Button delete,  listall,play,pause,stop,go;

    //ImageView home , add , cart , expert , community;

    AlertDialog.Builder builder;

    //Import DB
    CartDBHelper DB;

    MediaPlayer music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_cart);

        // Adding the music file to our
        // newly created object music
        music = MediaPlayer.create(this, R.raw.mlccart);

        home = findViewById(R.id.homeC5);
        add = findViewById(R.id.addC5);
        cart = findViewById(R.id.cartC5);
        expert = findViewById(R.id.expertC5);
        community = findViewById(R.id.communityC5);

        name = findViewById(R.id.MLCdeletename);
        delete = findViewById(R.id.btn_MLCddelete);
        listall = findViewById(R.id.MLClistall);
        play =findViewById(R.id.ChCartplay);
        pause=findViewById(R.id.ChCartpause);
        stop=findViewById(R.id.ChCartstop);
        go=findViewById(R.id.GoMLCd);

        DB = new CartDBHelper(DeleteCartActivity.this);
        builder = new AlertDialog.Builder(this);

        //DELETION TO DATABASE
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();

                if (Name.equals(""))
                    Toast.makeText(DeleteCartActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage("Do you want to delete ?").setTitle("Item Deletion");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to delete ?")
                        .setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(), "Deletion Discarded",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Boolean deletion = DB.deleteInfo(Name);
                                if (deletion == true) {
                                    Toast.makeText(DeleteCartActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(DeleteCartActivity.this, "Deleting failed", Toast.LENGTH_SHORT).show();
                                }
                                name.setText("");

                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Cart Registration");
                alert.show();
            }
        });

        home.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteCartActivity.this , KitchenStoriesActivity.class);
            startActivity(intent);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteCartActivity.this , AddRecipeActivity.class);
            startActivity(intent);
        });

        cart.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteCartActivity.this , FavouriteActivity.class);
            startActivity(intent);
        });

        expert.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteCartActivity.this , DisplayExpertActivity.class);
            startActivity(intent);
        });

        community.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteCartActivity.this , RatingReviewActivity.class);
            startActivity(intent);
        });

        listall.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteCartActivity.this, ViewCartActivity.class);
            startActivity(intent);
        });
        go.setOnClickListener(v -> {
            Intent intent = new Intent(DeleteCartActivity.this, Payment.class);
            startActivity(intent);
        });

        Intent intent1 = getIntent();
        String message = intent1.getStringExtra(CartAdapter.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.MLCdeletename);
        textView.setText(message);
    }


        /*home.setOnClickListener(v -> {
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

    }*/
    // Playing the music
   public void play(View v)
    {
        music.start();
    }

    // Pausing the music
    public void  pause(View v)
    {
        music.pause();
    }

    // Stoping the music
    public void stop(View v)
    {

        music.stop();
        music = MediaPlayer.create(this, R.raw.mlccart);
    }

}