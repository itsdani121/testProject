package com.example.testproject;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class mainViewModel extends ViewModel {
    public MutableLiveData<post> posts;
    public Database mdb;

    public mainViewModel() {
        this.posts = new MutableLiveData<>();
        this.mdb = Database.getInstance();
    }

    public LiveData<post> getPosts() {
        if (posts == null) {
            posts = new MutableLiveData<>();

        }
        Log.d(TAG, "getPosts: " + posts);
        return posts;
    }

    public void fetchPosts() {
        mdb.getJsonData("https://jsonplaceholder.typicode.com/" + "comments" + "?postId=1", new jsonCallBack() {
            public void onSuccessCallback(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    JSONObject array = null;
                    try {
                        array = response.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Gson gson = new Gson();
                    post mPost = gson.fromJson(array.toString(), post.class);
                    Log.d(TAG, "onSuccessCallback: " + array);
                    posts.setValue(mPost);
                }

            }

            @Override
            public void onSuccessCallback(JSONObject response) {

            }

            @Override
            public void onFailedCallback(String error) {
            }
        });
    }
}
