package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdsActivity extends AppCompatActivity {


    volatile int  m_progress=0;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        progressBar=findViewById(R.id.ads_pb);
        findViewById(R.id.ads_btn_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_progress=100;
//                Intent intent=new Intent(AdsActivity.this,MainActivity.class);
//                startActivity(intent);
            }
        });
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true){
                    m_progress += 10;
                    Log.d("msg","后台线程执行"+m_progress);
                    if(m_progress<100){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(m_progress);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent=new Intent(AdsActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        });
                        break;
                    }
                }
            }
        });
    }

    /*int  m_progress=0;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        progressBar=findViewById(R.id.ads_pb);
        findViewById(R.id.ads_btn_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                synchronized (AdsActivity.this){
                    m_progress=100;
                }
            }
        });
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (AdsActivity.this) {
                        m_progress += 10;
                    }
                    Log.d("msg","后台线程执行"+m_progress);
                    if(m_progress<100){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(m_progress);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent=new Intent(AdsActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        });
                        break;
                    }
                }
            }
        });
    }*/
}
