package com.example.bandaab.mvvmprac.viewmodel;

import android.databinding.BaseObservable;

import com.example.bandaab.mvvmprac.R;
import com.example.bandaab.mvvmprac.model.User;

/**
 * Created by bandaab on 2/19/18.
 */

public class UserModel extends BaseObservable{

    public String email;
    public String password;
    public String emailHint;
    public String passwordHint;

    public UserModel(User user) {
        this.emailHint = user.emailHint;
        this.passwordHint = user.passwordHint;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
//        notifyPropertyChanged(R.id.email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
//        notifyPropertyChanged(R.id.password);
    }

    public String getEmailHint() {
        return emailHint;
    }

    public void setEmailHint(String emailHint) {
        this.emailHint = emailHint;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }
}
