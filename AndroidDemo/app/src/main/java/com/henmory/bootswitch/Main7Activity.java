package com.henmory.bootswitch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.henmory.androiddemo.R;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
public class Main7Activity extends AppCompatActivity {

        /** Called when the activity is first created. */
        private ViewPager mViewPager;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main7);
            mViewPager = (ViewPager)findViewById(R.id.viewpager);

            //将要分页显示的View装入数组中
            LayoutInflater mLi = LayoutInflater.from(this);
            View view1 = mLi.inflate(R.layout.activity_boot_1, null);
            View view2 = mLi.inflate(R.layout.activity_boot_2, null);

            //每个页面的Title数据
            final ArrayList<View> views = new ArrayList<View>();
            views.add(view1);
            views.add(view2);

            //填充ViewPager的数据适配器
            PagerAdapter mPagerAdapter = new PagerAdapter() {

                @Override
                public boolean isViewFromObject(View arg0, Object arg1) {
                    return arg0 == arg1;
                }

                @Override
                public int getCount() {
                    return views.size();
                }

                @Override
                public void destroyItem(View container, int position, Object object) {
                    ((ViewPager)container).removeView(views.get(position));
                }

//                @Override
//                public CharSequence getPageTitle(int position) {
//                    return titles.get(position);
//                }

                @Override
                public Object instantiateItem(View container, int position) {
                    ((ViewPager)container).addView(views.get(position));
                    return views.get(position);
                }
            };

            mViewPager.setAdapter(mPagerAdapter);
        }

}
