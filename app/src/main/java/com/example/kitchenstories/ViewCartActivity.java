package com.example.kitchenstories;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.database.CartDBHelper;
import com.database.CartModal;

import java.util.ArrayList;

public class ViewCartActivity extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    ArrayList<CartModal> cartModalArrayList;
    CartDBHelper cartDBHelper ;
    CartAdapter cartAdapter;
    RecyclerView  cartsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        // initializing our all variables.
        cartModalArrayList = new ArrayList<>();
        cartDBHelper = new CartDBHelper(ViewCartActivity.this);

        // getting our course array
        // list from db handler class.
        cartModalArrayList = cartDBHelper.readCarts();

        // on below line passing our array lost to our adapter class.
        cartAdapter = new CartAdapter(cartModalArrayList, ViewCartActivity.this);
        cartsRV = findViewById(R.id.Listcart);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCartActivity.this, RecyclerView.VERTICAL, false);
        cartsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        cartsRV.setAdapter(cartAdapter);
    }
}
