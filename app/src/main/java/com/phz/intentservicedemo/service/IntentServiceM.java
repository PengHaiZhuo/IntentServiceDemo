package com.phz.intentservicedemo.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class IntentServiceM extends IntentService {
    public IntentServiceM() {
        super("com.phz.ISM");
    }

    public IntentServiceM(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //Intent是从Activity发过来的，携带识别参数，根据参数不同执行不同的任务
        String operation = intent.getExtras().getString("param");
        switch (operation) {
            case "do1":
                Log.e(IntentServiceM.class.getName(), "do1");
                break;
            case "do2":
                Log.e(IntentServiceM.class.getName(), "do2");
                break;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(IntentServiceM.class.getName(), "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(IntentServiceM.class.getName(), "onDestroy");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }
}
