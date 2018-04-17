package com.henmory.learbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * author: henmory
 * time:  11/2/16
 * function:
 * description:
 */

public class new_breocast  extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "网络发生了改变", Toast.LENGTH_SHORT).show();
    }
}
