package com.mvs.tool.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.mvs.util.ResourceUtil;

import java.util.List;

public class TitleDescRecyclerAdapter<T extends TitleDescRecyclerAdapter.TitleDescRecyclerItem, M extends TitleDescRecyclerAdapter.TitleDescRecyclerHolder>
        extends TitleRecyclerAdapter<T, M> {

    @IdRes
    private int descriptionId;


    public TitleDescRecyclerAdapter(@NonNull Context context, @NonNull Class<M> clazz, @LayoutRes int layoutId,
                                    @IdRes int titleId, @IdRes int descriptionId, @NonNull List data) {
        super(context, clazz, layoutId, titleId, data);
        this.descriptionId = descriptionId;
    }

    @Override
    protected void findViews(View itemView, M holder) {
        super.findViews(itemView, holder);
        if (ResourceUtil.isValid(descriptionId)) {
            holder.descriptionView = (TextView) itemView.findViewById(descriptionId);
        }
    }

    //------------------------------------------------------------------

    public interface TitleDescRecyclerItem extends TitleRecyclerItem {
        String getDescription();
    }

    public static class TitleDescRecyclerHolder<T extends TitleDescRecyclerItem> extends TitleRecyclerHolder<T> {

        TextView descriptionView;

        public TitleDescRecyclerHolder(View itemView) {
            super(itemView);
        }

        public void initView(T item) {
            super.initView(item);
            descriptionView.setText(item.getDescription());
        }
    }
}
