package ru.list.victor_90.study.myapplication;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;


public class MyApplication extends Application {

    private MyApplication myApplication;

    public MyApplication getInstance(){ return myApplication;}

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        myApplication = this;
        Log.d("MyApplication", "onCreate()");
    }
}
