package com.zungx.mvpdagger.network;

import android.content.Context;
import android.util.Log;

import com.zungx.mvpdagger.app.ZungXApplication;
import com.zungx.mvpdagger.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by dungtv on 5/16/17.
 */

public class BaseRestClient {

    private OkHttpClient okHttpClient;

    public BaseRestClient(Context context) {
        ((ZungXApplication) context).getAppComponent().inject(this);
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }
    }

    public void getRequest(String url, String tag, HashMap<String, String> headers, HashMap<String, String> params, Callback callback){
        String fullURL = url;
        if (params != null) {
            StringBuilder urlParams = new StringBuilder(url + "?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                urlParams.append(key).append("=").append(value).append("&");
            }
            fullURL = urlParams.toString();

            if (fullURL.length() > 0) {
                fullURL = fullURL.substring(0, fullURL.length() - 1);
            }
        }

        Request.Builder builder = new Request.Builder()
                .url(fullURL)
                .tag(tag)
                .get();

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                builder.addHeader(key, value);
            }
        }

        okHttpClient.newCall(builder.build()).enqueue(callback);
    }

    public void postRequest(){

    }
}
