package com.henmory.gesture;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.henmory.androiddemo.R;
import com.henmory.fileoperation.Main2Activity;

public class Main4Activity extends AppCompatActivity {


    private MyGestureDetectorListener myGestureDetector;
    private MyGestureDetectorListener1 myGestureDetector1;
    private GestureDetector mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        myGestureDetector = new MyGestureDetectorListener();
//        mDetector = new GestureDetector(this, myGestureDetector);
        myGestureDetector1 = new MyGestureDetectorListener1();
        mDetector = new GestureDetector(this, myGestureDetector1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }

    public class MyGestureDetectorListener1 extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() < e2.getX()){
                System.out.println("右滑");
                startActivity(new Intent(Main4Activity.this, Main2Activity.class));
            }else{
                System.out.println("左滑");
            }
            return true;
        }
    }
}
