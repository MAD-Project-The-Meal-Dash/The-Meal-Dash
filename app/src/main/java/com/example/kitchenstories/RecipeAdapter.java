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

import com.database.RecipeModal;
import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    public static final String EXTRA_MESSAGE = "text01";
    public static final String EXTRA_MESSAGE1 = "text02";
    public static final String EXTRA_MESSAGE2 = "text03";
    public static final String EXTRA_MESSAGE3 = "text04";
    public static final String EXTRA_MESSAGE4 = "text05";
    public static final String EXTRA_MESSAGE5 = "text06";
    public static final String EXTRA_MESSAGE6 = "text07";
    public static final String EXTRA_MESSAGE7 = "text08";
    public static final String EXTRA_MESSAGE8 = "text09";
    public static final String EXTRA_MESSAGE9 = "text010";
    public static final String EXTRA_MESSAGE10 = "text011";

    // variable for our array list and context
    ArrayList<RecipeModal> recipeModalArrayList;
    Context context;

    // constructor
    public RecipeAdapter(ArrayList<RecipeModal> recipeModalArrayList, Context context) {
        this.recipeModalArrayList = recipeModalArrayList;
        this.context = context;
    }
    // method for filtering our recyclerview items.
    public void filterList(ArrayList<RecipeModal> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        recipeModalArrayList = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        RecipeModal modal = recipeModalArrayList.get(position);
        holder.name1.setText(modal.getName1());
        holder.name2.setText(modal.getName2());
        holder.name3.setText(modal.getName3());
        holder.name4.setText(modal.getName4());
        holder.name5.setText(modal.getName5());
        holder.name6.setText(modal.getName6());
        holder.name7.setText(modal.getName7());
        holder.name8.setText(modal.getName8());
        holder.name9.setText(modal.getName9());
        holder.name10.setText(modal.getName10());
        holder.name11.setText(modal.getName11());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return recipeModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{

        // creating variables for our text views.
        TextView name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11;
        Button editM , deleteM;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            name1 = itemView.findViewById(R.id.Miname1);
            name2 = itemView.findViewById(R.id.Miname2);
            name3 = itemView.findViewById(R.id.Miname3);
            name4 = itemView.findViewById(R.id.Miname4);
            name5 = itemView.findViewById(R.id.Miname5);
            name6 = itemView.findViewById(R.id.Miname6);
            name7 = itemView.findViewById(R.id.Miname7);
            name8 = itemView.findViewById(R.id.Miname8);
            name9 = itemView.findViewById(R.id.Miname9);
            name10 = itemView.findViewById(R.id.Miname10);
            name11 = itemView.findViewById(R.id.Miname11);
            editM = itemView.findViewById(R.id.buttonRecipeEditMi);
            deleteM = itemView.findViewById(R.id.buttonRecipeDelete);

            editM.setOnClickListener(v -> {
                Intent intent = new Intent(context, EditRecipeActivity.class);
                String message = name1.getText().toString();
                intent.putExtra(EXTRA_MESSAGE , message);
                String message1 = name2.getText().toString();
                intent.putExtra(EXTRA_MESSAGE1 , message1);
                String message2 = name3.getText().toString();
                intent.putExtra(EXTRA_MESSAGE2 , message2);
                String message3 = name4.getText().toString();
                intent.putExtra(EXTRA_MESSAGE3 , message3);
                String message4 = name5.getText().toString();
                intent.putExtra(EXTRA_MESSAGE4 , message4);
                String message5 = name6.getText().toString();
                intent.putExtra(EXTRA_MESSAGE5 , message5);
                String message6 = name7.getText().toString();
                intent.putExtra(EXTRA_MESSAGE6 , message6);
                String message7 = name8.getText().toString();
                intent.putExtra(EXTRA_MESSAGE7 , message7);
                String message8 = name9.getText().toString();
                intent.putExtra(EXTRA_MESSAGE8 , message8);
                String message9 = name10.getText().toString();
                intent.putExtra(EXTRA_MESSAGE9 , message9);
                String message10 = name11.getText().toString();
                intent.putExtra(EXTRA_MESSAGE10 , message10);
                context.startActivity(intent);
            });
            deleteM.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DeleteWithPlayMusicActivity.class);
            String message = name1.getText().toString();
            intent.putExtra(EXTRA_MESSAGE , message);
            context.startActivity(intent);
        }
    }


}