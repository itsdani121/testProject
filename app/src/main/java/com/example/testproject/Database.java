package com.example.testproject;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class Database {
    private static Database instance;

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    private Database() {
        AndroidNetworking.initialize(MyApp.getInstance().getAppContext());
    }

    public void getJsonData(String url, final jsonCallBack callBack) {
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        callBack.onSuccessCallback(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        callBack.onFailedCallback(anError.getMessage());
                    }
                });

                /*.getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        callBack.onSuccessCallback(response);
                        Log.d(TAG, "onResponses " + response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        callBack.onFailedCallback(anError.getMessage());
                    }
                });*/
    }


    public void uploadData(String url, Object obj, final jsonCallBack callBack) {
        AndroidNetworking.post(url)
                .addBodyParameter(obj)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callBack.onSuccessCallback(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        callBack.onFailedCallback(anError.getMessage());
                    }
                });
    }

}