package com.zungx.mvpdagger.dagger;

import android.content.Context;

import com.zungx.mvpdagger.app.Constants;
import com.zungx.mvpdagger.network.BaseRestClient;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by dungtv on 5/16/17.
 */

@Module
public class NetworkModule {

    private static final String NAME_BASE_URL = "NAME_BASE_URL";

    @Provides
    @Singleton
    BaseRestClient provideBaseRestClient(Context context) {
        return new BaseRestClient(context);
    }
}
