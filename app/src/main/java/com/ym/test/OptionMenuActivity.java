package com.ym.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ym.test.mojo.ColorInfo;

import java.util.ArrayList;
import java.util.List;

public class OptionMenuActivity extends AppCompatActivity {

    private TextView tv;
    private List<ColorInfo> colorInfos;
    private  final int RED_ID=10;
    private  final int GREEN_ID=11;
    private  final int BLUE_ID=12;

    private final ColorInfo RED=new ColorInfo(RED_ID,"红色",Color.RED);
    private final ColorInfo GREEN=new ColorInfo(GREEN_ID,"绿色",Color.GREEN);
    private final ColorInfo BLUE=new ColorInfo(BLUE_ID,"蓝色",Color.BLUE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
        tv=findViewById(R.id.txt_option_show);
        colorInfos=new ArrayList<>();
        colorInfos.add(RED);
        colorInfos.add(GREEN);
        colorInfos.add(BLUE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        for(ColorInfo colorInfo : colorInfos){
            //add(菜单项的组号，ID，排序号，标题),如果排序号是按添加顺序排序的话都填0即可
            menu.add(1,colorInfo.getId(),0,colorInfo.getName());
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case RED_ID:
                tv.setTextColor(Color.RED);
                break;
            case GREEN_ID:
                tv.setTextColor(Color.GREEN);
                break;
            case BLUE_ID:
                tv.setTextColor(Color.BLUE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
