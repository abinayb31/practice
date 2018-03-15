package com.example.bandaab.mvvmprac;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.bandaab.mvvmprac.commands.userLogin;
import com.example.bandaab.mvvmprac.databinding.ActivityMainBinding;
import com.example.bandaab.mvvmprac.model.User;
import com.example.bandaab.mvvmprac.viewmodel.NewsModel;
import com.example.bandaab.mvvmprac.viewmodel.UserModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding activityMainBinding;
    private NewsModel newsModel;
    private ArrayList<NewsModel> newsList;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        UserModel userModel = new UserModel(new User("Email", "Password"));
//        activityMainBinding.setUser(userModel);
//
//        activityMainBinding.setUserLoginEvent(new userLogin() {
//            @Override
//            public void onClicklogin() {
//                Toast.makeText(MainActivity.this,activityMainBinding.getUser().getEmail(), Toast.LENGTH_SHORT).show();
//            }
//        });

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        newsModel = new NewsModel();
        newsList = newsModel.getArrayList();
        newsAdapter = new NewsAdapter(this, newsList);
        activityMainBinding.newslistView.setAdapter(newsAdapter);

    }
}
