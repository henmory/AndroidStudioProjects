package com.henmory.learnservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by dan on 16/6/7.
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String value = intent.getStringExtra("para");
        if (value.equals("service1")){
            System.out.println("service1 start");
        }else if (value.equals("service2")){
            System.out.println("service2 start");
        }else if (value.equals("service3")){
            System.out.println("service3 start");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        return super.onBind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        System.out.println("onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestory");
        super.onDestroy();
    }
}
