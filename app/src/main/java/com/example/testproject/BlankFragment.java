package com.example.testproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testproject.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {
    private FragmentBlankBinding fragment;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_blank, container, false);
        fragment = FragmentBlankBinding.inflate(inflater, container, false);
        View view = fragment.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onclick();
    }

    private void onclick() {
        fragment.fragText.setText("this is new binding mehod");


    }
}