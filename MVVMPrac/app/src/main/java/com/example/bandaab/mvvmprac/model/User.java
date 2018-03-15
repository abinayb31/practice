package com.example.bandaab.mvvmprac.model;

/**
 * Created by bandaab on 2/19/18.
 */

public class User {
    public String email;
    public String password;
    public String emailHint;
    public String passwordHint;

    public User(String emailHint, String passwordHint){
        this.emailHint = emailHint;
        this.passwordHint = passwordHint;
    }
}
