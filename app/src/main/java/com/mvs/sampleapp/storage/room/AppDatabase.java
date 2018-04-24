package com.mvs.sampleapp.storage.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.mvs.sampleapp.storage.room.dao.CountryDao;
import com.mvs.sampleapp.storage.room.model.CountryDataModel;

@Database(entities = {CountryDataModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public static void destroyInstance() {
        instance = null;
    }

    public static void init(Context context) {
        instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "country-database")
                // We should do transactions on another thread in production app
                .allowMainThreadQueries()
                .build();
    }

    public static AppDatabase getInstance() {
        return instance;
    }

    //---------------------------------------------------

    public abstract CountryDao userDao();
}