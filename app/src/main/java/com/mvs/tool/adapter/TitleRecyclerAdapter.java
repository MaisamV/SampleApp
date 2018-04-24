package com.mvs.tool.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.mvs.util.ResourceUtil;

import java.util.List;

public class TitleRecyclerAdapter<T extends TitleRecyclerAdapter.TitleRecyclerItem, M extends TitleRecyclerAdapter.TitleRecyclerHolder>
        extends GenericRecyclerAdapter<T, M> {

    @IdRes
    private int titleId;


    public TitleRecyclerAdapter(@NonNull Context context, @NonNull Class<M> clazz, @LayoutRes int layoutId,
                                @IdRes int titleId, @NonNull List data) {
        super(context, clazz, layoutId, data);
        this.titleId = titleId;
    }

    @Override
    protected void findViews(View itemView, M holder) {
        super.findViews(itemView, holder);
        if (ResourceUtil.isValid(titleId)) {
            holder.titleView = (TextView) itemView.findViewById(titleId);
        }
    }

    //------------------------------------------------------------------

    public interface TitleRecyclerItem extends GenericRecyclerItem {
        String getTitle();
    }

    public static class TitleRecyclerHolder<T extends TitleRecyclerItem> extends GenericRecyclerHolder<T> {

        public TextView titleView;

        public TitleRecyclerHolder(View itemView) {
            super(itemView);
        }

        public void initView(T item) {
            titleView.setText(item.getTitle());
        }
    }
}
