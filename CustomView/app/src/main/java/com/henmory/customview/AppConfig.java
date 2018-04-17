package com.henmory.customview;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;


/**
 * Created by dan on 16/6/6.
 */
public class AppConfig {

    private Context context;
    public static boolean isExitApp = false;
    public static Handler handler = null;

    AppConfig(Context context){
        this.context = context;
    }

    public static void createHandler(){
        if (handler == null) {
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    isExitApp = false;
                    super.handleMessage(msg);
                }
            };
        }
    }

    public static void enterApp(Context context){
        createHandler();
    }

    public static void exitApp(Context context){
        ActivityCollector.finishAllActivity();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.killBackgroundProcesses(context.getPackageName());
        System.exit(0);
    }
}
