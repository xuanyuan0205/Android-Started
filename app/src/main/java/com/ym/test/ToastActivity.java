package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        findViewById(R.id.btn_toast_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midToast("hello world!",Toast.LENGTH_SHORT);
            }
        });
        findViewById(R.id.btn_toast_show2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midToast2("hello world!",Toast.LENGTH_SHORT);
            }
        });
    }
    private void midToast(String str, int showTime)
    {
        Toast toast = Toast.makeText(ToastActivity.this, str, showTime);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM , 0, 0);  //设置显示位置
        LinearLayout layout = (LinearLayout) toast.getView();
        layout.setBackgroundColor(Color.BLUE);
        ImageView image = new ImageView(this);
        image.setImageResource(R.mipmap.iv_lol_icon1);
        layout.addView(image, 0);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.YELLOW);     //设置字体颜色
        toast.show();
    }
    private void midToast2(String str, int showTime)
    {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.view_toast_custom,
                (ViewGroup) findViewById(R.id.lly_toast));
        ImageView img_logo = (ImageView) view.findViewById(R.id.img_logo);
        TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
        tv_msg.setText(str);
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }
}
