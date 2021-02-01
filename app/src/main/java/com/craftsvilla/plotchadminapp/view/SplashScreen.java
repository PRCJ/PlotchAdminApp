package com.craftsvilla.plotchadminapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.craftsvilla.plotchadminapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private static  int SPLASH_SCREEN_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iH=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(iH);

                finish();


            }
        }
                ,SPLASH_SCREEN_TIME);
    }
}