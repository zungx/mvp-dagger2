package com.zungx.mvpdagger.dagger;

import android.content.Context;

import com.zungx.mvpdagger.ui.user.UserPresenter;
import com.zungx.mvpdagger.ui.user.UserPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dungtv on 5/16/17.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    UserPresenter provideUserPresenter(Context context) {
        return new UserPresenterImpl(context);
    }

}
