package com.example.bandaab.basicconcepts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by bandaab on 1/15/18.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String str = intent.getStringExtra("BroadcastExtra");
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
}
