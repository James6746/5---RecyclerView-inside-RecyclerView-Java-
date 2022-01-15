package com.example.a5_recyclerviewinsiderecyclerviewjava.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5_recyclerviewinsiderecyclerviewjava.R;
import com.example.a5_recyclerviewinsiderecyclerviewjava.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    private final ArrayList<User> userArrayList;
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_LIST = 1;


    public UserAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @Override
    public int getItemViewType(int position) {
        if (userArrayList.get(position).getSubUserArrayList() != null) return TYPE_LIST;
        return TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user, parent, false);
            return new UserViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
            return new UserListViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = userArrayList.get(position);

        if (holder instanceof UserViewHolder) {
            ((UserViewHolder) holder).userName.setText(user.getName());
        } else if (holder instanceof UserListViewHolder) {
            RecyclerView recyclerView = ((UserListViewHolder) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, false));

            refreshSubAdapter(recyclerView, user.getSubUserArrayList());
        }


    }

    private void refreshSubAdapter(RecyclerView recyclerView, ArrayList<User> userArrayList) {
        SubUserAdapter adapter = new SubUserAdapter(context, userArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView userName = itemView.findViewById(R.id.item_name);
    }

    static class UserListViewHolder extends RecyclerView.ViewHolder {
        public UserListViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        RecyclerView recyclerView = itemView.findViewById(R.id.recyclerView);
    }
}
