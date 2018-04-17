package com.henmory.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    private String data = "服务的数据";
    private boolean isRunning = false;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return  new IMyAidlInterface.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public void setData(String dt) throws RemoteException {
                data = dt;
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("service create");
        isRunning = true;

        new Thread(){
            @Override
            public void run() {
                super.run();
                while (isRunning){
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
    public void onDestroy() {
        super.onDestroy();
        System.out.println("sercvice destroy");
        isRunning = false;
    }
}
