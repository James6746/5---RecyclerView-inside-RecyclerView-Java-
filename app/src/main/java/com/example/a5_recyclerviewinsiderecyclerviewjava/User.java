package com.example.a5_recyclerviewinsiderecyclerviewjava;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<User> subUserArrayList;

    public User(String name, ArrayList<User> subUserArrayList) {
        this.name = name;
        this.subUserArrayList = subUserArrayList;
    }

    public ArrayList<User> getSubUserArrayList() {
        return subUserArrayList;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
