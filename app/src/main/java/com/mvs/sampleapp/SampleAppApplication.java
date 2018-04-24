package com.mvs.sampleapp;

import android.app.Application;

import com.mvs.sampleapp.storage.room.AppDatabase;

public class SampleAppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.init(this);
    }
}
