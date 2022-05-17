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

import com.database.ExpertModal;
import java.util.ArrayList;


public class ExpertAdapter extends RecyclerView.Adapter<ExpertAdapter.ViewHolder> {
    public static final String EXTRA_MESSAGE = "text1";
    public static final String EXTRA_MESSAGE1 = "text2";
    public static final String EXTRA_MESSAGE2 = "text3";
    public static final String EXTRA_MESSAGE3 = "text4";

    // variable for our array list and context
    ArrayList<ExpertModal> expertModalArrayList;
    Context context;

    // constructor
    public ExpertAdapter(ArrayList<ExpertModal> expertModalArrayList, Context context) {
        this.expertModalArrayList = expertModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expert_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data 
        // to our views of recycler view item.
        ExpertModal modal = expertModalArrayList.get(position);
        holder.name.setText(modal.getName());
        holder.email.setText(modal.getEmail());
        holder.carrier.setText(modal.getCarrier());
        holder.works.setText(modal.getWorks());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return expertModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // creating variables for our text views.
        TextView name, email, carrier, works;
        Button edit , delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            name = itemView.findViewById(R.id.exname);
            email = itemView.findViewById(R.id.exemail);
            carrier = itemView.findViewById(R.id.playedit);
            works = itemView.findViewById(R.id.exworks);
            edit = itemView.findViewById(R.id.listEditExpert);
            delete = itemView.findViewById(R.id.listDeleteExpert);

            edit.setOnClickListener(v -> {
                Intent intent = new Intent(context, EditExpertActivity.class);
                String message = name.getText().toString();
                intent.putExtra(EXTRA_MESSAGE , message);
                String message1 = email.getText().toString();
                intent.putExtra(EXTRA_MESSAGE1 , message1);
                String message2 = carrier.getText().toString();
                intent.putExtra(EXTRA_MESSAGE2 , message2);
                String message3 = works.getText().toString();
                intent.putExtra(EXTRA_MESSAGE3 , message3);
                context.startActivity(intent);
            });
            delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DeleteAndPlayMusicActivity.class);
            String message = name.getText().toString();
            intent.putExtra(EXTRA_MESSAGE , message);
            context.startActivity(intent);
        }
    }
}