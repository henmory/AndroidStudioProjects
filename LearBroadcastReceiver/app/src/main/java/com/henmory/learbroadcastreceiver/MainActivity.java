package com.henmory.learbroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public MyReceiver receiver = null;
    new_breocast new_breocast = new new_breocast();

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
        findViewById(R.id.btn_sendMsg).setOnClickListener(this);
        findViewById(R.id.btn_reg).setOnClickListener(this);
        findViewById(R.id.btn_unreg).setOnClickListener(this);
        IntentFilter intentFilter  = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(new_breocast, intentFilter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sendMsg:
                if (null != receiver){
                    Intent i = new Intent("com.henmory.learbroadcastreceiver.intent.myseerver");
                    i.putExtra("data", "我发送的消息");
//                    sendBroadcast(i);
                    sendOrderedBroadcast(i, null);
                }

                break;
            case R.id.btn_reg:
                if(null == receiver){
                    receiver = new MyReceiver();
                    registerReceiver(receiver, new IntentFilter(receiver.ACTION));
                    System.out.println("注册成功");
                }
                break;
            case R.id.btn_unreg:
                if (null != receiver){
                    unregisterReceiver(receiver);
                    receiver = null;
                    System.out.println("解除成功");

                }
                break;

        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(new_breocast);
        super.onDestroy();
    }
}
