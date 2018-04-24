package com.mvs.sampleapp.countrySelection;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvs.sampleapp.R;
import com.mvs.sampleapp.countrySelection.model.CountryData;
import com.mvs.sampleapp.countrySelection.model.TitleItem;
import com.mvs.tool.adapter.TitleDescRecyclerAdapter;
import com.mvs.tool.adapter.TitleRecyclerAdapter;

import java.util.List;

public class CountrySelectionAdapter extends TitleDescRecyclerAdapter<CountryData, CountrySelectionItemHolder> {

    private static final int NORMAL_VIEW_TYPE = 0;
    private static final int HEADER_VIEW_TYPE = 1;
    private static final int FOOTER_VIEW_TYPE = 2;

    //------------------------------------------------------

    @LayoutRes
    private int headerLayout;
    @IdRes
    private int headerTitleId;
    @LayoutRes
    private int footerLayout;
    @IdRes
    private int footerTitleId;

    private TitleItem headerItem;
    private TitleItem footerItem;

    public void setHeaderText(String headerText) {
        this.headerItem = new TitleItem(headerText);
    }

    public void setFooterText(String footerText) {
        this.footerItem = new TitleItem(footerText);
    }

    public CountrySelectionAdapter(@NonNull Context context,
                                   @NonNull List<CountryData> data) {
        super(context, CountrySelectionItemHolder.class,
                R.layout.list_item_country, R.id.countryListItem_title, R.id.countryListItem_description, data);
        this.headerLayout = R.layout.list_item_header;
        this.footerLayout = R.layout.list_item_footer;
        this.headerTitleId = R.id.headerItem_title;
        this.footerTitleId = R.id.footerItem_title;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case HEADER_VIEW_TYPE:
                View header = getInflater().inflate(headerLayout, parent, false);
                HeaderViewHolder headerHolder = new HeaderViewHolder(header);
                viewHolder = headerHolder;
                findHeaderViews(header, headerHolder);
                break;
            case FOOTER_VIEW_TYPE:
                View footer = getInflater().inflate(footerLayout, parent, false);
                FooterViewHolder footerHolder = new FooterViewHolder(footer);
                viewHolder = footerHolder;
                findFooterViews(footer, footerHolder);
                break;
            case NORMAL_VIEW_TYPE:
            default:
                viewHolder = super.onCreateViewHolder(parent, viewType);
        }

        return viewHolder;
    }

    private void findHeaderViews(View header, HeaderViewHolder headerHolder) {
        headerHolder.titleView = (TextView) header.findViewById(headerTitleId);
    }

    private void findFooterViews(View footer, FooterViewHolder footerHolder) {
        footerHolder.titleView = (TextView) footer.findViewById(footerTitleId);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder viewHolder = (HeaderViewHolder) holder;
            viewHolder.initView(headerItem);
        } else if (holder instanceof FooterViewHolder) {
            FooterViewHolder viewHolder = (FooterViewHolder) holder;
            viewHolder.initView(footerItem);
        } else {
            super.onBindViewHolder(holder, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER_VIEW_TYPE;
        } else if (position == getItemCount() - 1) {
            return FOOTER_VIEW_TYPE;
        } else {
            return NORMAL_VIEW_TYPE;
        }
    }

    @Override
    public int getItemCount() {
        //+2 for header and footer
        return super.getItemCount() + 2;
    }

    @Override
    public CountryData getItem(int position) {
        return super.getItem(position - 1);
    }

    //-----------------------------------------------------------


    public static class HeaderViewHolder<T extends TitleRecyclerAdapter.TitleRecyclerItem> extends TitleRecyclerAdapter.TitleRecyclerHolder<T> {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class FooterViewHolder<T extends TitleRecyclerAdapter.TitleRecyclerItem> extends TitleRecyclerAdapter.TitleRecyclerHolder<T> {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
