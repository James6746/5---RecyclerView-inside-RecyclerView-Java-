package com.example.a5_recyclerviewinsiderecyclerviewjava.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5_recyclerviewinsiderecyclerviewjava.R;
import com.example.a5_recyclerviewinsiderecyclerviewjava.User;

import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

public class SubUserAdapter extends RecyclerView.Adapter<SubUserAdapter.SubUserViewHolder>{
    private Context context;
    private final ArrayList<User> userArrayList;

    public SubUserAdapter( Context context, ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SubUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sub_user, parent, false);
        return new SubUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubUserViewHolder holder, int position) {
        holder.userName.setText(userArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    static class SubUserViewHolder extends RecyclerView.ViewHolder {
        TextView userName = itemView.findViewById(R.id.item_name);

        public SubUserViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
