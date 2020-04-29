package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressDialogActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;

    ProgressDialog pd1;
    ProgressDialog pd2;

    private Context mContext = null;
    private final static int PD2_VALUE_MAX=100;
    private int pd2_progress_value=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
        mContext=ProgressDialogActivity.this;
        bindViews();

    }
    private void bindViews() {
        btn1 = (Button) findViewById(R.id.btn_pdialog_1);
        btn2 = (Button) findViewById(R.id.btn_pdialog_2);
        btn3 = (Button) findViewById(R.id.btn_pdialog_3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("pd1","click");
                //这里的话参数依次为,上下文,标题,内容,是否显示进度,是否可以用取消按钮关闭
                ProgressDialog.show(mContext,"资源加载中……","资源加载中,请稍后...",true,true);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("pd2","click");
                pd1 = new ProgressDialog(mContext);
                //依次设置标题,内容,是否用取消按钮关闭,是否显示进度
                pd1.setTitle("软件更新中");
                pd1.setMessage("软件正在更新中,请稍后...");
                pd1.setCancelable(true);
                //这里是设置进度条的风格,HORIZONTAL是水平进度条,SPINNER是圆形进度条
                pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd1.setIndeterminate(true);
                //调用show()方法将ProgressDialog显示出来
                pd1.show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("pd3","click");
                //初始化属性
                pd2_progress_value = 0;
                //依次设置一些属性
                pd2 = new ProgressDialog(mContext);
                pd2.setMax(PD2_VALUE_MAX);
                pd2.setTitle("文件读取中");
                pd2.setMessage("文件加载中,请稍后...");
                //这里设置为不可以通过按取消按钮关闭进度条
                pd2.setCancelable(false);
                pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //这里设置的是是否显示进度,设为false才是显示的哦！
                pd2.setIndeterminate(false);
                pd2.show();
                //这里的话新建一个线程,重写run()方法,
                new Thread()
                {
                    public void run()
                    {
                        while(pd2_progress_value < PD2_VALUE_MAX)
                        {
                            //这里的算法是决定进度条变化的,可以按需要写
                            pd2_progress_value +=  Math.random()*5 ;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //把信息码发送给handle让更新界面
                            hand.sendEmptyMessage(1);
                        }
                    }
                }.start();
            }
        });
    }
    //定义一个用于更新进度的Handler,因为只能由主线程更新界面,所以要用Handler传递信息
    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            //这里的话如果接受到信息码是123
            if(msg.what == 1)
            {
                //设置进度条的当前值
                pd2.setProgress(pd2_progress_value);
            }
            //如果当前大于或等于进度条的最大值,调用dismiss()方法关闭对话框
            if(pd2_progress_value >= PD2_VALUE_MAX)
            {
                pd2.dismiss();
            }
        }
    };

}
