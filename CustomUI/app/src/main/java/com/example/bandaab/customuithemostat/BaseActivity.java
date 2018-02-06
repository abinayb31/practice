package com.example.bandaab.customuithemostat;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

/**
 * Created by bandaab on 1/10/18.
 */

public class BaseActivity extends Activity{

    CustomDrawableView mCustomDrawableView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }
}
