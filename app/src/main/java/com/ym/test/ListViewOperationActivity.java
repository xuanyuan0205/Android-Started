package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ym.test.custom.MyAdapter;
import com.ym.test.mojo.User;

import java.util.LinkedList;
import java.util.List;

public class ListViewOperationActivity extends AppCompatActivity {

    private ListView list_one;
    private MyAdapter mAdapter = null;
    private List<User> mData = null;
    int[] images=new int[]{R.mipmap.face1,R.mipmap.face2,R.mipmap.face3};
    int[] images_update=new int[]{R.mipmap.face4,R.mipmap.face5,R.mipmap.face6};
    int selectPosition=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_operation);
        bindViews();
        mData = new LinkedList<User>();
        mAdapter = new MyAdapter((LinkedList<User>) mData,ListViewOperationActivity.this);
        list_one.setAdapter(mAdapter);
        if(null!=mData&&mData.size()==0){
        TextView txt_empty=findViewById(R.id.lv_txt_empty);
        txt_empty.setText("暂无数据~");
        list_one.setEmptyView(txt_empty);
        }
    }
    private void bindViews(){
        list_one = (ListView) findViewById(R.id.list_one);
        list_one.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectPosition=(int)mAdapter.getItemId(position);
                list_one.setSelector(R.drawable.item_select);

            }
        });
        findViewById(R.id.btn_lv_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=(int) (Math.random()*3);
                mAdapter.add(new User(images[i],"hello"));
            }
        });
        findViewById(R.id.btn_lv_delselect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("selectPosition=",""+selectPosition);
                if(-1!=selectPosition) {
                    mAdapter.remove(selectPosition);

                    selectPosition = -1;
                    list_one.setSelector(new ColorDrawable(Color.TRANSPARENT));
                }
            }
        });
        findViewById(R.id.btn_lv_delall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("btn_lv_delall","click");

                mAdapter.removeAll();
            }
        });
        findViewById(R.id.btn_lv_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (-1 != selectPosition) {
                    int i = (int) (Math.random() * 3);
                    mAdapter.update(selectPosition, new User(images_update[i], "hello world"));
                    selectPosition = -1;
                    list_one.setSelector(new ColorDrawable(Color.TRANSPARENT));
                }
            }
        });
    }
}
