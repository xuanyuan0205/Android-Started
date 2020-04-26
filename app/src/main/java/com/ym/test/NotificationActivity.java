package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.media.AudioAttributes;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private NotificationManager mNManager;
    private Notification notify1;
    Bitmap LargeBitmap = null;
    private static final int NOTIFYID_1 = 1;

    private Button btn_show_normal;
    private Button btn_close_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mContext = NotificationActivity.this;
        //创建大图标的Bitmap
        LargeBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.face1);
        mNManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        bindView();

    }


    private void bindView() {
        btn_show_normal = (Button) findViewById(R.id.btn_show_normal);
        btn_close_normal = (Button) findViewById(R.id.btn_close_normal);
        btn_show_normal.setOnClickListener(this);
        btn_close_normal.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_normal:
                //定义一个PendingIntent点击Notification后启动一个Activity
                Intent it = new Intent(mContext, NotificationOtherActivity.class);
                PendingIntent pit = PendingIntent.getActivity(mContext, 0, it, 0);

                if(Build.VERSION.SDK_INT >= 26)
                {
                    //当sdk版本大于26
                    String id = "channel_1";
                    String description = "143";
                    int importance = NotificationManager.IMPORTANCE_LOW;
                    NotificationChannel channel = new NotificationChannel(id,description,importance);
//                     channel.enableLights(true);
//                     channel.enableVibration(true);//
                    mNManager.createNotificationChannel(channel);
                    Notification.Builder mBuilder = new Notification.Builder(this,id);
                    mBuilder.setContentTitle("叶良辰")                        //标题
                            .setContentText("我有一百种方法让你呆不下去~")      //内容
                            .setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
                            .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
                            .setWhen(System.currentTimeMillis())           //设置通知时间
                            .setSmallIcon(R.mipmap.ic_help_view_1)            //设置小图标
                            .setLargeIcon(LargeBitmap)                     //设置大图标
                           // .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao), AudioAttributes.CONTENT_TYPE_MUSIC)  //设置自定义的提示音
                            .setAutoCancel(true)                           //设置点击后取消Notification
                            .setContentIntent(pit);                        //设置PendingIntent
                    try {
                        Uri notification = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao);
                        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    notify1 = mBuilder.build();
                    mNManager.notify(NOTIFYID_1, notify1);
                    break;
                }
                else
                {
                    //当sdk版本小于26
                    //设置图片,通知标题,发送时间,提示方式等属性
                    Notification.Builder mBuilder = new Notification.Builder(this);
                    mBuilder.setContentTitle("叶良辰")                        //标题
                            .setContentText("我有一百种方法让你呆不下去~")      //内容
                            .setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
                            .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
                            .setWhen(System.currentTimeMillis())           //设置通知时间
                            .setSmallIcon(R.mipmap.iv_lol_icon1)            //设置小图标
                            .setLargeIcon(LargeBitmap)                     //设置大图标
                            .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                            .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao))  //设置自定义的提示音
                            .setAutoCancel(true)                           //设置点击后取消Notification
                            .setContentIntent(pit);                        //设置PendingIntent
                    notify1 = mBuilder.build();
                    mNManager.notify(NOTIFYID_1, notify1);
                    break;
                }




            case R.id.btn_close_normal:
                //除了可以根据ID来取消Notification外,还可以调用cancelAll();关闭该应用产生的所有通知
                mNManager.cancel(NOTIFYID_1);                          //取消Notification
                break;

        }
    }
}
