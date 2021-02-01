package com.craftsvilla.plotchadminapp.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.craftsvilla.plotchadminapp.model.User;
import com.craftsvilla.plotchadminapp.view.HomeActivity;
import com.craftsvilla.plotchadminapp.view.MainActivity;

public class UserViewModel extends ViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public User user;
    private Context context;

    public UserViewModel(Context context, User user) {
        this.user = user;
        this.context = context;
    }

    public void onSubmitClick() {
        user.setEmail(email.getValue());
        user.setPassword(password.getValue());
        if (user.isValid()){
            Toast.makeText(context, user.getEmail(), Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(context, HomeActivity.class);
            context.startActivity(myIntent);
        } else {
            Toast.makeText(context, "please enter valid email", Toast.LENGTH_LONG).show();

        }
    }

    public void onSkipClick(){
        Intent myIntent = new Intent(context, HomeActivity.class);
        context.startActivity(myIntent);
    }

}
