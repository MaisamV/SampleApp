package com.mvs.sampleapp.net.callback;

import com.mvs.sampleapp.net.IResponse;

public interface IResponseCallback<T> {
    void onResponse(IResponse<T> response);

    void onFailure(Throwable t);
}