package com.example.abhilashayadav.firebasebasics.Model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Abhilasha Yadav on 12/27/2017.
 */
@IgnoreExtraProperties
public class User {

    public String name;
    public String email;

    // Default constructor required for calls to
    // DataSnapshot.getValue(com.example.abhilashayadav.firebasebasics.Model.User.class)
    public User() {

    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}