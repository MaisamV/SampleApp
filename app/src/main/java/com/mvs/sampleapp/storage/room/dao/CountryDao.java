package com.mvs.sampleapp.storage.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.mvs.sampleapp.storage.room.model.CountryDataModel;

import java.util.List;

@Dao
public interface CountryDao {

    @Query("SELECT * FROM country")
    List<CountryDataModel> getAll();

    @Query("SELECT COUNT(*) from user")
    int countUsers();

    @Insert
    void insertAll(CountryDataModel... users);

    @Insert
    void insertAll(List<CountryDataModel> users);

    @Query("DELETE FROM country")
    void deleteAll();
}