package com.henmory.fileoperation;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.henmory.androiddemo.R;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class Main2Activity extends AppCompatActivity {

    Button btn_open;//字节的方式读取
    Button btn_open_char;//字符的方式读取（unicode）
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_open = (Button) findViewById(R.id.btn_file_operation);
        btn_open_char = (Button) findViewById(R.id.btn_file_operation_char);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fileInputStream;
                try {
                    fileInputStream = openFileInput("test");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    try {
                        String string = "hello world";
                        FileOutputStream fileOutputStream = openFileOutput("test",MODE_PRIVATE | MODE_APPEND);
                        fileOutputStream.write(string.getBytes());
                        System.out.println("file create successfully");
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                        return;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        return;
                    }
                    try {
                        fileInputStream = openFileInput("test");
                        System.out.println("file open successfully");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        return;
                    }
                }
                System.out.println("file is found");
                byte[] buffer = new byte[1024];
                try {
                    int ret = fileInputStream.read(buffer);
                    if (0 <= ret){
                        String string = new String(buffer, 0, ret);
                        System.out.println(string);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_open_char.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BufferedReader bufferedReader = null;
                BufferedWriter bufferedWriter = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(getFilesDir() + "/test_char")));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    try {
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getFilesDir() + "/test_char")));
                        String string = "hello world";
                        bufferedWriter.write(string);
                        System.out.println("write data successfully");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        return;
                    }
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(getFilesDir() + "/test_char")));
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                        return;
                    }
                }finally {
                    try {
                        if(null != bufferedWriter)
                            bufferedWriter.close();
                        System.out.println("finally called 1");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("open file successfully");
                char[] string = new char[1024];
                try {
                    int ret = bufferedReader.read(string);
                    if (ret > 0){
                        String string1 = new String(string, 0, ret);
                        System.out.println(string1);
                    }
                    System.out.println(ret);

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if (null != bufferedReader)
                            bufferedReader.close();
                        if (null != bufferedWriter)
                            bufferedWriter.close();
                        System.out.println("finally called 2");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
