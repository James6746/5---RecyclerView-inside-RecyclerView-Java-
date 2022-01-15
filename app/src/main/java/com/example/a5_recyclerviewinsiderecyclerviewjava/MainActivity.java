package com.example.a5_recyclerviewinsiderecyclerviewjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a5_recyclerviewinsiderecyclerviewjava.Adapters.UserAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> userArrayList;
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        recyclerView = findViewById(R.id.recyclerView);
        userArrayList = new ArrayList<>();
        userAdapter = new UserAdapter(this, userArrayList);

        for(int i = 0; i < 50; i++){
            if(i == 5 || i == 15 || i == 25){
                userArrayList.add(new User("Matthew Redman", createList()));
            } else {
                userArrayList.add(new User("James"));
            }

        }

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(userAdapter);
    }

    private ArrayList<User> createList(){
        ArrayList<User> subUserArrayList = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            subUserArrayList.add(new User("Matthew Redman"));
        }
        return subUserArrayList;

    }
}