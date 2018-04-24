package com.mvs.sampleapp.net;

public interface IResponse<T> {

    boolean isSuccessful();

    T getBody();

    <M> M getErrorBody(Class<M> clazz);

    Object getHeaders();

    int getCode();
}