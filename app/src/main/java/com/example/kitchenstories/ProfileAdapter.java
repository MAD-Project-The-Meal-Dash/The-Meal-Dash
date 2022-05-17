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
import java.util.ArrayList;
import com.database.ProfileModal;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    public static final String EXTRA_MESSAGE = "text1";
    public static final String EXTRA_MESSAGE1 = "text2";
    public static final String EXTRA_MESSAGE2 = "text3";
    public static final String EXTRA_MESSAGE3 = "text4";

    // creating a variable for array list and context.
    private ArrayList<ProfileModal> profileModalArrayList;
    Context context;

    // creating a constructor for our variables.
    public ProfileAdapter(ArrayList<ProfileModal> profileModalArrayList, Context context) {
        this.profileModalArrayList = profileModalArrayList;
        this.context = context;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<ProfileModal> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        profileModalArrayList = filterllist;
        // below line is to notify our adapter 
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        ProfileModal modal = profileModalArrayList.get(position);
        holder.name.setText(modal.getName());
        holder.email.setText(modal.getEmail());
        holder.phone.setText(modal.getPhone());
        holder.username.setText(modal.getUsername());

    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return profileModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        // creating variables for our views.
        private TextView name, email , phone , username;
        Button view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our views with their ids.
            name = itemView.findViewById(R.id.idTVName);
            email = itemView.findViewById(R.id.idTVEmail);
            phone = itemView.findViewById(R.id.idTVPhone);
            username = itemView.findViewById(R.id.idTVUsername);
            view = itemView.findViewById(R.id.profileRVBtn);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ViewProfileActivity.class);
            String message = name.getText().toString();
            intent.putExtra(EXTRA_MESSAGE , message);
            String message1 = email.getText().toString();
            intent.putExtra(EXTRA_MESSAGE1 , message1);
            String message2 = phone.getText().toString();
            intent.putExtra(EXTRA_MESSAGE2 , message2);
            String message3 = username.getText().toString();
            intent.putExtra(EXTRA_MESSAGE3 , message3);
            context.startActivity(intent);
        }
    }
}