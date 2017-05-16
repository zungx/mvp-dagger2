package com.zungx.mvpdagger.ui.user;

import com.zungx.mvpdagger.model.User;

import java.util.List;

/**
 * Created by dungtv on 5/16/17.
 */

public interface UserView {

    void showLoading();

    void hideLoading();

    void showUser(List<User> userList);

    void showErrorMessage(String msg);

    void launchUserDetail(User user);

}
