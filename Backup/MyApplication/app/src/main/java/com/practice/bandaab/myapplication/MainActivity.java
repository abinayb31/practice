package com.practice.bandaab.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm .beginTransaction();

        MainFragment searchFragment = new MainFragment();
        fragmentTransaction.replace(R.id.fragmentContainer, searchFragment);
        fragmentTransaction.commit();
    }
}
