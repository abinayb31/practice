package com.mc10.bandaab.notificationtest;

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
        String str = intent.getStringExtra("NotificationExtra");
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
}
