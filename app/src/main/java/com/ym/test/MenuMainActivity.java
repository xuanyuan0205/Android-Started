package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
        findViewById(R.id.btn_menu_option).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuMainActivity.this,OptionMenuActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_menu_option_xml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuMainActivity.this,OptionMenuWithXmlActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_menu_context).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuMainActivity.this,ContextMenuActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_menu_context_xml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuMainActivity.this,ContextMenuWithXmlActivity.class);
                startActivity(intent);
            }
        });
    }
}
