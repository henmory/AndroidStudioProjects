package com.henmory.learbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OtherReceiver extends BroadcastReceiver {
    public OtherReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("other reciever receives message");
    }
}
