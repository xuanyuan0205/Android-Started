package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.ym.test.custom.MyPagerAdapter;

import java.util.ArrayList;

public class ViewPager1Activity extends AppCompatActivity {

    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager1);

        vpager_one = findViewById(R.id.vpager_one);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.viewpager_one,null,false));
        aList.add(li.inflate(R.layout.viewpager_two,null,false));
        aList.add(li.inflate(R.layout.viewpager_three,null,false));
        mAdapter = new MyPagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);
    }
}
