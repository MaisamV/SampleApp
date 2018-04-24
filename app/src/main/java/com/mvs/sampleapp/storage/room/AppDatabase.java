package com.mvs.sampleapp.storage.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.mvs.sampleapp.storage.room.dao.CountryDao;
import com.mvs.sampleapp.storage.room.model.CountryDataModel;
import com.mvs.util.ObjectUtil;

@Database(entities = {CountryDataModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public static void destroyInstance() {
        instance = null;
    }

    public static AppDatabase getAppDatabase(Context context) {
        if (ObjectUtil.isNull(instance)) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "country-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return instance;
    }

    //---------------------------------------------------

    public abstract CountryDao userDao();
}