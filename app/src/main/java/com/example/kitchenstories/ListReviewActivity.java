package com.example.kitchenstories;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.database.WriteReviewDBHeler;
import com.database.ReviewModal;

import java.util.ArrayList;

public class ListReviewActivity extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    ArrayList<ReviewModal> reviewModalArrayList;
    WriteReviewDBHeler writeReviewDBHeler;
    ReviewAdapter reviewAdapter;
    RecyclerView  reviewRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_review);

        // initializing our all variables.
        reviewModalArrayList = new ArrayList<>();
        writeReviewDBHeler = new WriteReviewDBHeler(ListReviewActivity.this);

        // getting our course array
        // list from db handler class.
        reviewModalArrayList = writeReviewDBHeler.readReviews();

        // on below line passing our array lost to our adapter class.
        reviewAdapter = new ReviewAdapter(reviewModalArrayList, ListReviewActivity.this);
        reviewRV = findViewById(R.id.listreview);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListReviewActivity.this, RecyclerView.VERTICAL, false);
        reviewRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        reviewRV.setAdapter(reviewAdapter);
    }
}
