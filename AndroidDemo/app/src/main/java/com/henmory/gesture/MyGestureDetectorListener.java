package com.henmory.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * author: henmory
 * time:  11/21/16
 * function:
 * description:
 */

public class MyGestureDetectorListener implements GestureDetector.OnGestureListener {

    @Override
    public boolean onDown(MotionEvent e) {
        System.out.println("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        System.out.println("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        System.out.println("onSingleTap");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        System.out.println("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        System.out.println("onLOngPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        System.out.println("onFling");
        return false;
    }
}
