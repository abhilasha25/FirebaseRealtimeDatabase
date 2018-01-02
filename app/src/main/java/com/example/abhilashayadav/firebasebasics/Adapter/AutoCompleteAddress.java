package com.example.abhilashayadav.firebasebasics.Adapter;

import java.util.ArrayList;

/**
 * Created by Abhilasha Yadav on 12/28/2017.
 */

class AutoCompleteAddress {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(ArrayList<String> usernames) {
        this.usernames = usernames;
    }

    private  String  token ;
    private ArrayList<String> usernames = new ArrayList<>();
}
