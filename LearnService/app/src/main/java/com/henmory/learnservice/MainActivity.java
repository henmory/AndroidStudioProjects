package com.henmory.learnservice;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private  Intent intent;
    private  Intent intent1;
    private  Intent intent2;
    private  Intent intent3;
    private  EditText editext;
    private  MyService.Binder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        intent1 = new Intent(MainActivity.this, MyIntentService.class);
        intent1.putExtra("para","service1");
        startService(intent1);
        intent2 = new Intent(MainActivity.this, MyIntentService.class);
        intent2.putExtra("para","service2");
        startService(intent2);
        intent3 = new Intent(MainActivity.this, MyIntentService.class);
        intent3.putExtra("para","service3");
        startService(intent3);
        findViewById(R.id.btn_startService).setOnClickListener(this);
        findViewById(R.id.btn_stopService).setOnClickListener(this);
        findViewById(R.id.btn_bindService).setOnClickListener(this);
        findViewById(R.id.btn_unbindService).setOnClickListener(this);
        findViewById(R.id.btn_synaData).setOnClickListener(this);
        editext = (EditText) findViewById(R.id.edt_text);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_startService:
                intent.putExtra("data", editext.getText().toString());
                startService(intent);
                break;
            case R.id.btn_stopService:
                stopService(intent);
                break;
            case R.id.btn_bindService:
                bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbindService:
                unbindService(this);
                break;
            case R.id.btn_synaData:
                binder.setData(editext.getText().toString());
                break;
        }

    }
    //Activity与Service连接成功时回调该方法
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("service connencted");
        //服务被绑定成功后被执行
        binder = (MyService.Binder) service;
    }
    //Activity与Service断开连接时回调该方法
    @Override
    public void onServiceDisconnected(ComponentName name) {
        //服务线程被杀死的时候
    }
}
