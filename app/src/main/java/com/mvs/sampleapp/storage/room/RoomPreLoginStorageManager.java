package com.mvs.sampleapp.storage.room;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.sampleapp.storage.IPreLoginStorageManager;
import com.mvs.sampleapp.storage.callback.IResponseCallback;
import com.mvs.sampleapp.storage.room.model.CountryDataModel;
import com.mvs.util.ConvertUtil;

import java.io.IOException;
import java.util.List;

public class RoomPreLoginStorageManager implements IPreLoginStorageManager {
    @Override
    public void getCountryList(IResponseCallback<List<CountryData>> callback) {
        //TODO: implement async transaction
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CountryData> getCountryList() throws IOException {
        List<CountryDataModel> countryDataModels = AppDatabase.getInstance().userDao().getAll();
        return ConvertUtil.toCountryList(countryDataModels);
    }

    @Override
    public void insertCountryList(List<CountryData> data) {
        List<CountryDataModel> models = ConvertUtil.toCountryModelList(data);
        AppDatabase.getInstance().userDao().insertAll(models);
    }

    @Override
    public void deleteAllCountryData() {
        AppDatabase.getInstance().userDao().deleteAll();
    }
}
