package com.example.lenovo.day04volleytest2;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/**
 * Created by LENOVO on 2017/4/10.
 */

public class GsonRequest<T> extends Request<T> {


    public GsonRequest(String url, Response.ErrorListener listener) {
        super(url, listener);
    }

    public GsonRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(T response) {

    }
}
