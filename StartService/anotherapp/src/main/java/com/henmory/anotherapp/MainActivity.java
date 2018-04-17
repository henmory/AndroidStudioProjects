package com.henmory.anotherapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.henmory.startservice.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Intent intentService;
    private IMyAidlInterface binder = null;
    private EditText editText;
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
        editText = (EditText) findViewById(R.id.editText);
        findViewById(R.id.btn_startService).setOnClickListener(this);
        findViewById(R.id.btn_stopService).setOnClickListener(this);
        findViewById(R.id.btn_bindService).setOnClickListener(this);
        findViewById(R.id.btn_unbindService).setOnClickListener(this);
        findViewById(R.id.btn_syns).setOnClickListener(this);

        intentService = new Intent();
        intentService.setComponent(new ComponentName("com.henmory.startservice", "com.henmory.startservice.MyService"));

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
        switch(v.getId()){
            case R.id.btn_startService:
                startService(intentService);
                break;
            case R.id.btn_stopService:
                stopService(intentService);
                break;
            case R.id.btn_bindService:
                bindService(intentService, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbindService:
                unbindService(this);
                break;
            case R.id.btn_syns:
                try {
                    binder.setData(editText.getText().toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("service bind");
        System.out.println(service);
        binder = IMyAidlInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("service unbind");
    }
}
