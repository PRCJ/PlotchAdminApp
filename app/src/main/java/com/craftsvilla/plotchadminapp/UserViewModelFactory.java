package com.craftsvilla.plotchadminapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.craftsvilla.plotchadminapp.model.User;
import com.craftsvilla.plotchadminapp.view.MainActivity;
import com.craftsvilla.plotchadminapp.viewmodel.UserViewModel;

public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private User user;
    private Context context;

    public UserViewModelFactory(MainActivity mainActivity, User user) {
        this.context = mainActivity;
        this.user = user;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new UserViewModel(context,user);
    }
}
