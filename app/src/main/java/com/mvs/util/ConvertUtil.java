package com.mvs.util;

import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.sampleapp.storage.room.model.CountryDataModel;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtil {
    public static CountryData toCountryData(CountryDataModel model) {
        CountryData countryData = new CountryData();
        countryData.setCountry(model.getCountry());
        countryData.setIso(model.getIso());
        countryData.setCode(model.getCode());

        return countryData;
    }

    public static List<CountryData> toCountryList(List<CountryDataModel> modelList) {
        List<CountryData> result = null;

        if (ObjectUtil.notNull(modelList)) {
            result = new ArrayList<>(modelList.size());
            for (CountryDataModel model : modelList) {
                result.add(toCountryData(model));
            }
        }

        return result;
    }

    public static CountryDataModel toCountryDataModel(CountryData data) {
        CountryDataModel countryDataModel = new CountryDataModel();
        countryDataModel.setCountry(data.getCountry());
        countryDataModel.setIso(data.getIso());
        countryDataModel.setCode(data.getCode());

        return countryDataModel;
    }

    public static List<CountryDataModel> toCountryModelList(List<CountryData> modelList) {
        List<CountryDataModel> result = null;

        if (ObjectUtil.notNull(modelList)) {
            result = new ArrayList<>(modelList.size());
            for (CountryData model : modelList) {
                result.add(toCountryDataModel(model));
            }
        }

        return result;
    }
}
