package com.henmory.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.henmory.androiddemo.R;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn = (Button) findViewById(R.id.get_preference);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("com.henmory.sharedpreference", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int count = sharedPreferences.getAll().size();
                if (count <= 0) {
                    editor.putBoolean("key1", true);
                    editor.putInt("key2", 2);
                    editor.putString("key3", "adfa");
                    editor.commit();
                } else {
                    String string = sharedPreferences.getString("key3", null);
                    System.out.println(string);
                    String str = sharedPreferences.getString("key4", null);
                    System.out.println(str);
                }
            }
        });
    }

}
