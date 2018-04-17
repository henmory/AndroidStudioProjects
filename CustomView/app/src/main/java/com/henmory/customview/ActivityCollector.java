package com.henmory.customview;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dan on 16/6/6.
 */
public class ActivityCollector {

    private static List<Activity> activityList = new LinkedList<Activity>();

    public static void addActivity(Activity activity){
        if (activityList == null) {
            activityList = new LinkedList<>();
        }
        activityList.add(activity);
    }

    public static void finishActivity(Activity activity){
        if (activityList != null) {
            activityList.remove(activity);
        }
    }

    public static void finishAllActivity(){

        for(Activity activity:activityList){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
