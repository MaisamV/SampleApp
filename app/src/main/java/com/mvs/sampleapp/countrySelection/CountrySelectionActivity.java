package com.mvs.sampleapp.countrySelection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.mvs.sampleapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountrySelectionActivity extends AppCompatActivity implements ICountrySelectionMvpView {

    private ICountrySelectionPresenter presenter;

    @BindView(R.id.countrySelection_recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_selection);
        ButterKnife.bind(this);

        presenter = new CountrySelectionPresenter(this);
    }

    @Override
    public void loadCountryList(List countryList) {
        //TODO:
    }

    @Override
    protected void onDestroy() {
        //to prevent memory leak
        presenter.onDestroy();
        presenter = null;
        super.onDestroy();
    }
}
