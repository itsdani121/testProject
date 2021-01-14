package com.example.testproject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class factory extends ViewModelProvider.NewInstanceFactory {
    public factory(){}
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new mainViewModel();
    }

}
