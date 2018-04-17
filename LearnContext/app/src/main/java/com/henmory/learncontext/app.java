package com.henmory.learncontext;

import android.app.Application;

/**
 * Created by dan on 16/2/29.
 */

public class app extends Application {

    private String dataText = "default";

    public void setDataText(String dataText) {
        this.dataText = dataText;
    }

    public String getDataText() {
        return dataText;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("app on create");
    }
}
