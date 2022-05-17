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

import com.database.ReviewModal;
import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    public static final String EXTRA_MESSAGE = "text1";
    public static final String EXTRA_MESSAGE1 = "text2";
    public static final String EXTRA_MESSAGE2 = "text3";



    // variable for our array list and context
    ArrayList<ReviewModal> reviewModalArrayList;
    Context context;

    // constructor
    public ReviewAdapter(ArrayList<ReviewModal> reviewModalArrayList, Context context) {
        this.reviewModalArrayList = reviewModalArrayList;
        this.context = context;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<ReviewModal> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        reviewModalArrayList = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_rv_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        ReviewModal modal = reviewModalArrayList.get(position);
        holder.name.setText(modal.getName());
        holder.title.setText(modal.getTitle());
        holder.comment.setText(modal.getComment());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return reviewModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        // creating variables for our text views.
        TextView name, title, comment;
        Button edit, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            name = itemView.findViewById(R.id.cname);
            title = itemView.findViewById(R.id.rtitle);
            comment = itemView.findViewById(R.id.rcomment);
            edit = itemView.findViewById(R.id.editBtn);
            delete = itemView.findViewById(R.id.deleteBtn);

            edit.setOnClickListener(v -> {
                Intent intent = new Intent(context, EditReviewActivity.class);
                String message = name.getText().toString();
                intent.putExtra(EXTRA_MESSAGE , message);
                String message1 = title.getText().toString();
                intent.putExtra(EXTRA_MESSAGE1 , message1);
                String message2 = comment.getText().toString();
                intent.putExtra(EXTRA_MESSAGE2 , message2);
                context.startActivity(intent);
            });
            delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ReviewDeleteActivity.class);
            String message = name.getText().toString();
            intent.putExtra(EXTRA_MESSAGE , message);
            context.startActivity(intent);
        }
    }
}


