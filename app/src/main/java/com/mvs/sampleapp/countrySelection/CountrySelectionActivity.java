package com.mvs.sampleapp.countrySelection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mvs.sampleapp.R;
import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.tool.callback.RecyclerItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountrySelectionActivity extends AppCompatActivity implements ICountrySelectionMvpView {

    private ICountrySelectionPresenter presenter;
    private CountrySelectionAdapter adapter;

    @BindView(R.id.countrySelection_recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_selection);
        ButterKnife.bind(this);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        CountryData itemData = adapter.getItem(position);
                        presenter.countrySelected(itemData);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do nothing
                    }
                })
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new CountrySelectionPresenter(this);
    }

    @Override
    public void loadCountryList(List countryList) {
        adapter = new CountrySelectionAdapter(this, countryList);
        adapter.setHeaderText(getString(R.string.headerText));
        adapter.setFooterText(getString(R.string.footerText));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        //to prevent memory leak
        presenter.onDestroy();
        presenter = null;
        super.onDestroy();
    }
}
