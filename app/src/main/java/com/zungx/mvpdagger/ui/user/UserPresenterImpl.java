package com.zungx.mvpdagger.ui.user;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.zungx.mvpdagger.app.Constants;
import com.zungx.mvpdagger.app.ZungXApplication;
import com.zungx.mvpdagger.model.User;
import com.zungx.mvpdagger.network.BaseRestClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

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

        baseRestClient.getRequest(Constants.LIST_USER, "test", null, null, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("ZungX", "err: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    userView.showErrorMessage("Error");
                } else {
                    try {
                        List<User> users = new ArrayList<User>();
                        JsonParser parser = new JsonParser();
                        JsonArray arrResponse = parser.parse(response.body().string()).getAsJsonArray();
                        for (int i =0; i<arrResponse.size(); i++) {
                            JsonObject objUser = arrResponse.get(i).getAsJsonObject();
                            users.add(new User(
                                    objUser.get("id").getAsInt(),
                                    objUser.get("login").getAsString(),
                                    objUser.get("avatar_url").getAsString(),
                                    objUser.get("repos_url").getAsString()
                            ));
                        }
                        userView.showUser(users);
                    } catch (Exception e) {
                        Log.d("ZungX", "Error: " + e.getMessage());
                    }
                }
                userView.hideLoading();
            }
        });
    }
}
