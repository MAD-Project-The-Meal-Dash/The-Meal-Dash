package com.example.kitchenstories;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.database.CartModal;

import java.util.ArrayList;

/*public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    public static final String EXTRA_MESSAGE = "text1";
    public static final String EXTRA_MESSAGE1 = "text2";
    public static final String EXTRA_MESSAGE2 = "text3";
    public static final String EXTRA_MESSAGE3 = "text4";*/



    public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
        public static final String EXTRA_MESSAGE = "text1";
        public static final String EXTRA_MESSAGE1 = "text2";
        public static final String EXTRA_MESSAGE2 = "text3";
        public static final String EXTRA_MESSAGE3 = "text4";
    // variable for our array list and context
    ArrayList<CartModal> cartModalArrayList;
    Context context;

    // constructor
    public CartAdapter(ArrayList<CartModal> cartModalArrayList, Context context) {
        this.cartModalArrayList = cartModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        CartModal modal = cartModalArrayList.get(position);
        holder.name.setText(modal.getName());
        holder.price.setText(modal.getPrice());
        holder.quantity.setText(modal.getQuantity());
        holder.itemno.setText(modal.getItemno());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return cartModalArrayList.size();
    }

    public   class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // creating variables for our text views.
        TextView name, price, quantity, itemno;
        Button editCart ,deleteCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            name = itemView.findViewById(R.id.ccart1);
            price = itemView.findViewById(R.id.ccart2);
            quantity = itemView.findViewById(R.id.ccart3);
            itemno = itemView.findViewById(R.id.ccart4);
            editCart = itemView.findViewById(R.id.MLCeedit1);
            deleteCart = itemView.findViewById(R.id.MLCDelete);

            editCart.setOnClickListener(v->{
                Intent intent=new Intent(context,EditCartActivity.class);
                String message=name.getText().toString();
                intent.putExtra(EXTRA_MESSAGE,message);
                String message1=price.getText().toString();
                intent.putExtra(EXTRA_MESSAGE1,message1);
                String message2=quantity.getText().toString();
                intent.putExtra(EXTRA_MESSAGE2,message2);
                String message3=itemno.getText().toString();
                intent.putExtra(EXTRA_MESSAGE3,message3);
                context.startActivity(intent);

            });
            deleteCart.setOnClickListener(this);


        }
        @Override
        public void onClick(View v){
            Intent intent=new Intent(context,DeleteCartActivity.class);
            String message=name.getText().toString();
            intent.putExtra(EXTRA_MESSAGE,message);
            context.startActivity(intent);
        }
    }
}