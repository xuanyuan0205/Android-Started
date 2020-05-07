package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewPagerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);

        findViewById(R.id.btn_viewpager_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ViewPagerMainActivity.this,ViewPager1Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_viewpager_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ViewPagerMainActivity.this,ViewPager1Activity.class);
                startActivity(intent);
            }
        });
    }
}
