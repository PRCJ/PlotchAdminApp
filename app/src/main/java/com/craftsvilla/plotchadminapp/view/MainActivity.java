package com.craftsvilla.plotchadminapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.craftsvilla.plotchadminapp.R;
import com.craftsvilla.plotchadminapp.UserViewModelFactory;
import com.craftsvilla.plotchadminapp.databinding.ActivityMainBinding;
import com.craftsvilla.plotchadminapp.model.User;
import com.craftsvilla.plotchadminapp.viewmodel.UserViewModel;
import com.plotch.sdk.PlotchChatbotService;
import com.plotch.sdk.PlotchNotificationService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserViewModel userViewModel = ViewModelProviders.of(this, new UserViewModelFactory(this, new User())).get(UserViewModel.class);
        binding.setUserModel(userViewModel);

    }
}