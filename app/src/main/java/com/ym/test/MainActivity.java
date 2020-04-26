package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_main_list_opt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListViewOperationActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_grid_opt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GridViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_spinner_opt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SpinnerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_autotxt_opt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AutoCompleteTextViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_epdlv_opt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ExpandableListViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_vf1_opt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ViewFlipper1Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_vf2_opt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ViewFlipper2Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ToastActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_main_alertdialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AlertDialogActivity.class);
                startActivity(intent);
            }
        });
    }
}
