package com.example.testproject;


import org.json.JSONArray;
import org.json.JSONObject;

public interface jsonCallBack {
    void onSuccessCallback(JSONArray response);
    void onSuccessCallback(JSONObject response);

    void onFailedCallback(String error);
}
