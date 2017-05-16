package com.zungx.mvpdagger.ui.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zungx.mvpdagger.R;
import com.zungx.mvpdagger.app.ZungXApplication;
import com.zungx.mvpdagger.model.User;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements UserView {

    private Button btnReload;
    private TextView tvContent;

    @Inject
    UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ZungXApplication) getApplication()).getAppComponent().inject(this);

        userPresenter.setView(this);
        userPresenter.getUser();

        tvContent = (TextView) findViewById(R.id.tv_content);
        btnReload = (Button) findViewById(R.id.btn_reload);
        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPresenter.getUser();
            }
        });
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
        String listUser = "";
        for (User user : userList) {
            listUser += user.getUsername() + " \n ";
        }

        final String finalListUser = listUser;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvContent.setText("List user \n "+ finalListUser);
            }
        });
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
