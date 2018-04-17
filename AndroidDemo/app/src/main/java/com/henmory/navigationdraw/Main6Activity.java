package com.henmory.navigationdraw;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.henmory.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

public class Main6Activity extends AppCompatActivity {


    private TextView tvTitle;//标题
    private Toolbar toolbar;//工具栏
    private List<String> settingItemList;//侧边栏项
    private ListView lv_navigation;
    private ActionBarDrawerToggle drawerToggle; //为actionbar设置的事件监听器
    private DrawerLayout mDrawerLayout; //真个布局

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amap);
        initNavigation();
        initSettingSlip();
    }

    //初始化设置边侧栏
    void initSettingSlip(){
        //drawer设置
        lv_navigation = (ListView) findViewById(R.id.drawer_setting);
//        settingItemList = new ArrayList<>();
//        settingItemList.add(new SettingItem(R.drawable.account_icon, "设置"));//设置内容
//        SettingItemAdapter adapter = new SettingItemAdapter(settingItemList,AmapActivity.this, R.layout.setting_item);
//        lv_navigation.setAdapter(adapter);

        lv_navigation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position);
            }
        });
    }

    void bindView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout); //整个布局的id
    }

    void initNavigation(){

        bindView();//绑定视图
        setSupportActionBar(toolbar);//工具栏设置
//        toolbar.setNavigationIcon(R.drawable.account_icon);//设置工具栏图标
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //设置标题点击事件
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //标题栏图标设置
        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, 0, 1){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(drawerToggle);//设置监听
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();//使得箭头和三道杠图案和抽屉拉和保持一致
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }






}
