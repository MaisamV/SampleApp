package com.mvs.sampleapp;

import com.mvs.util.ObjectUtil;


/**
 * this class keep all use-case and handler references that work with networks, db, device, ... layers.
 */

public class AppDataManager {

    private static AppDataManager instance;

    public static AppDataManager getInstance() {
        if (ObjectUtil.isNull(instance)) {
            instance = new AppDataManager();
        }

        return instance;
    }

    //----------------------------------------------------

    IPreLoginDataProvider preLoginDataProvider;

    //singleton
    private AppDataManager() {
        //TODO: init preLoginDataProvider
    }

    public IPreLoginDataProvider getPreLoginDataProvider() {
        return preLoginDataProvider;
    }
}
