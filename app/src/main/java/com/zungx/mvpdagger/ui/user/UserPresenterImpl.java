package com.zungx.mvpdagger.ui.user;

import android.content.Context;

import com.zungx.mvpdagger.app.ZungXApplication;
import com.zungx.mvpdagger.model.User;
import com.zungx.mvpdagger.network.BaseRestClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by dungtv on 5/16/17.
 */

public class UserPresenterImpl implements UserPresenter {

    private UserView userView;

    @Inject
    BaseRestClient baseRestClient;

    public UserPresenterImpl(Context context) {
        ((ZungXApplication) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(UserView view) {
        this.userView = view;
    }

    @Override
    public void getUser() {
        userView.showLoading();

        //call api here

        List<User> users = new ArrayList<>();
        for (int i=0; i<10; i++) {
            users.add(new User(i, "name " + i, "avatar", "link repo"));
        }

        userView.showUser(users);

        userView.hideLoading();
    }
}
