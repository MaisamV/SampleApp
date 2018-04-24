package com.mvs.sampleapp.net.callback;

import com.mvs.sampleapp.net.IResponse;

public interface IResponseCallback<T> {
    void onResponse(IResponse<T> IResponse);

    void onFailure(Throwable t);
}