package com.henmory.learncontentprovider;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;
import java.net.URL;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn = (Button) findViewById(R.id.btn_get_content);
        editText = (EditText)findViewById(R.id.content);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
    }

    void test(){


        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS)) {
            //has permission, do operation directly
            read();
        } else {
            //do not have permission

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        0);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        read();
    }

    void read(){
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri,null,null,null,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            System.out.println("name = " + name + "; phone = " + phone);

        }
        String projection[] = {"display_name","data1", "data5"};
        cursor = resolver.query(uri, projection,null,null,null);
        System.out.println(cursor.getColumnCount());
        System.out.println(cursor.getCount());
        while (cursor.moveToNext()){
            System.out.println(cursor.getString(cursor.getColumnIndex("data1")));
        }


    }
}
