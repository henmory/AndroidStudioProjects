package com.henmory.learnservice;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;

public class MyService extends Service {

    private boolean serviceRunning = false;
    private String data = "这是默认数据";

    public MyService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       // throw new UnsupportedOperationException("Not yet implemented");
        System.out.println("service onBind");
        return  new Binder();
    }

    public class Binder extends android.os.Binder{
        public void setData(String dt){
            data = dt;
        }

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("service on start command");
        data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("service create");
        serviceRunning = true;
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (serviceRunning){

                    System.out.println(data);

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("service onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        serviceRunning = false;
        System.out.println("service destroy");
    }


}
