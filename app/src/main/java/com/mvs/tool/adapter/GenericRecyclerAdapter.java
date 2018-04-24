package com.mvs.tool.adapter;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class GenericRecyclerAdapter<T extends GenericRecyclerAdapter.GenericRecyclerItem, M extends GenericRecyclerAdapter.GenericRecyclerHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private Class<M> clazz;
    private List<T> data;

    @LayoutRes
    private int layoutId;


    public GenericRecyclerAdapter(@NonNull Context context, @NonNull Class<M> clazz, @LayoutRes int layoutId, @NonNull List<T> data) {
        this.context = context;
        this.clazz = clazz;
        this.layoutId = layoutId;

        this.data = new ArrayList<>(data);
        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = createItemView(getItemLayoutId(), parent, false);
        M holder = createHolder(getClazz(), itemView);
        findViews(itemView, holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((M) holder).initView(getItem(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public T getItem(int position) {
        return data.get(position);
    }

    public int getItemLayoutId() {
        return layoutId;
    }

    public Class<M> getClazz() {
        return clazz;
    }

    public Context getContext() {
        return context;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    protected View createItemView(int layoutId, ViewGroup parent, boolean attachToRoot) {
        return inflater.inflate(layoutId, parent, attachToRoot);
    }

    protected void findViews(View itemView, M holder) {
    }

    protected final <Z extends GenericRecyclerHolder> Z createHolder(Class<Z> clazz, View view) {
        Z result = null;
        try {
            Constructor<Z> constructor = clazz.getConstructor(View.class);
            result = constructor.newInstance(view);
        } catch (Exception e) {
        }

        return result;
    }

    //---------------------------------------------------------------------

    public interface GenericRecyclerItem {
    }

    public static abstract class GenericRecyclerHolder<T extends GenericRecyclerItem> extends RecyclerView.ViewHolder {

        public GenericRecyclerHolder(View itemView) {
            super(itemView);
        }

        abstract public void initView(T item);
    }
}