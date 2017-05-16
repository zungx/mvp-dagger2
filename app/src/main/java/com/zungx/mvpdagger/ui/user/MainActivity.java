package com.zungx.mvpdagger.ui.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zungx.mvpdagger.R;
import com.zungx.mvpdagger.app.ZungXApplication;
import com.zungx.mvpdagger.model.User;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements UserView {

    @Inject
    UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ZungXApplication) getApplication()).getAppComponent().inject(this);

        userPresenter.setView(this);
        userPresenter.getUser();
    }

    @Override
    public void showLoading() {
        Log.d("ZungX", "Show loading view");
    }

    @Override
    public void hideLoading() {
        Log.d("ZungX", "hide loading view");
    }

    @Override
    public void showUser(List<User> userList) {
        for (User user : userList) {
            Log.d("ZungX", "_____" + user.getUsername());
        }
    }

    @Override
    public void showErrorMessage(String msg) {
        Log.d("ZungX", "Show error view");
    }

    @Override
    public void launchUserDetail(User user) {
        //
    }
}
