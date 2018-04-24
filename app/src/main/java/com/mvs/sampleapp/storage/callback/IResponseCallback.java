package com.mvs.sampleapp.storage.callback;

public interface IResponseCallback<T> {
    void onResponse(T response);

    void onFailure(Throwable t);
}