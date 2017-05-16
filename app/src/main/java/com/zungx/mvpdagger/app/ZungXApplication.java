package com.zungx.mvpdagger.app;

import android.app.Application;

import com.zungx.mvpdagger.dagger.AppComponent;
import com.zungx.mvpdagger.dagger.AppModule;
import com.zungx.mvpdagger.dagger.DaggerAppComponent;

/**
 * Created by dungtv on 5/16/17.
 */

public class ZungXApplication extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(ZungXApplication application){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}
