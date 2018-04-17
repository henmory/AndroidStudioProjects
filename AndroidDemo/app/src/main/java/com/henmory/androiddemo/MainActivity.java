package com.henmory.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/**
 *  @author henmory
 *  @date 11/14/16
 *  @description:  测试的主分支，无论写什么测试demo，只需要建立响应的文件夹，然后开启相应的activity即可
 *
 *  @param
 *
 *  @return
*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startActivity(new Intent(this, com.henmory.sharedpreference.MainActivity.class));
//        startActivity(new Intent(this, com.henmory.fileoperation.Main2Activity.class));
//        startActivity(new Intent(this, com.henmory.gesture.Main4Activity.class));
//        startActivity(new Intent(this, com.henmory.navigationdraw.Main6Activity.class));
        startActivity(new Intent(this, com.henmory.bootswitch.Main7Activity.class));
        finish();
    }
}
