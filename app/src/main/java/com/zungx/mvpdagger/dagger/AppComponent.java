package com.zungx.mvpdagger.dagger;

import com.zungx.mvpdagger.ui.user.MainActivity;
import com.zungx.mvpdagger.ui.user.UserPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dungtv on 5/16/17.
 */

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(MainActivity target);

    void inject(UserPresenterImpl target);
}
