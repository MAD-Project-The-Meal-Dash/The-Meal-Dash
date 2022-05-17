package com.example.kitchenstories;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.database.ExpertDBHelper;
import com.database.ExpertModal;
import java.util.ArrayList;

public class ListExpertsActivity extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    ArrayList<ExpertModal> expertModalArrayList;
    ExpertDBHelper expertDBHelper;
    ExpertAdapter expertAdapter;
    RecyclerView  expertsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_experts);

        // initializing our all variables.
        expertModalArrayList = new ArrayList<>();
        expertDBHelper = new ExpertDBHelper(ListExpertsActivity.this);

        // getting our course array
        // list from db handler class.
        expertModalArrayList = expertDBHelper.readExperts();

        // on below line passing our array lost to our adapter class.
        expertAdapter = new ExpertAdapter(expertModalArrayList, ListExpertsActivity.this);
        expertsRV = findViewById(R.id.listexperts);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListExpertsActivity.this, RecyclerView.VERTICAL, false);
        expertsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        expertsRV.setAdapter(expertAdapter);
    }
}
