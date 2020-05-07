package com.ym.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ym.test.mojo.ColorInfo;

import java.util.List;

public class ContextMenuWithXmlActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_with_xml);
        tv=findViewById(R.id.txt_contextmenu_xml_show);
        registerForContextMenu(tv);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.contextmenu,menu);


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_context_3:
                tv.setTextColor(Color.RED);
                break;
            case R.id.menu_context_2:
                tv.setTextColor(Color.GREEN);
                break;
            case R.id.menu_context_1:
                tv.setTextColor(Color.BLUE);
                break;
        }
        return true;
    }
}
