package com.henmory.learncontext;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2 extends AppCompatActivity {

    private EditText editText;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        tv = (TextView) findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        tv.setText("共享的数据是：" + ((app)getApplicationContext()).getDataText());

        findViewById(R.id.but_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((app) getApplicationContext()).setDataText(editText.getText().toString());
                tv.setText("共享的数据是：" + editText.getText().toString());

            }
        });
        System.out.println("main2 create");

    }

}
