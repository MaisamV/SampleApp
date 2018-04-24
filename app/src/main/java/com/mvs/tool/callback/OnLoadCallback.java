package com.mvs.tool.callback;

public interface OnLoadCallback<T> {
    void onLoad(T data);

    void onFailure(Throwable t);
}
