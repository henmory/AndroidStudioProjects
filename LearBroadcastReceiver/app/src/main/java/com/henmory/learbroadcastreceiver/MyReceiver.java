package com.henmory.learbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public  final  String ACTION = "com.henmory.learbroadcastreceiver.intent.myseerver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

//        System.out.println("接收到的消息是：" + intent.getStringExtra("data"));
        System.out.println("myseceiver receive message");
        abortBroadcast();
    }
}
