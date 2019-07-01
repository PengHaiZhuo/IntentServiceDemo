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
        //IntentService好处之一，请求完成后自己关闭，不需要开发者去调stopservice
        super.onDestroy();
        Log.e(IntentServiceM.class.getName(), "onDestroy");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        //根据此方法设置的布尔值来决定onStartCommand 返回START_NOT_STICKY(默认这种)还是START_REDELIVER_INTENT(START_REDELIVER_INTENT 型服务会在可用资源不再吃紧的时候尝试再次启动服务)
        super.setIntentRedelivery(enabled);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //与service的区别是，默认返回null
        return super.onBind(intent);
    }
}
