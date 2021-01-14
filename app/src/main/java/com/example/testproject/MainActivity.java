package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.testproject.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "test";
    ActivityMainBinding mBinding;
    postAdapter mAdapter;
    mainViewModel viewModel;
    List<post> myPost = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        initRef();
        observer();
        viewModel.fetchPosts();

    }


    private void initRef() {
        viewModel = new ViewModelProvider(this, new factory()).get(mainViewModel.class);

    }

    private void observer() {
        viewModel.getPosts().observe(this, post -> {
            if (post != null) {
                Log.d(TAG, "observer: " + post);
                com.example.testproject.post mPost = new post();
                mPost.setId(post.getId());
                mPost.setPostId(post.getPostId());
                mPost.setEmails(post.getEmails());
                mPost.setNames(post.getNames());
                mPost.setBody(post.getBody());

                myPost.add(mPost);
                setUpRecycler(myPost);

            } else {
                Toast.makeText(this, "data not found", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void setUpRecycler(List<post> Post) {
        mAdapter = new postAdapter(this, Post);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setSmoothScrollbarEnabled(true);
        mBinding.listItem.setAdapter(mAdapter);
        mBinding.listItem.setHasFixedSize(true);
        mBinding.listItem.setLayoutManager(manager);
        mAdapter.notifyDataSetChanged();

    }
}


