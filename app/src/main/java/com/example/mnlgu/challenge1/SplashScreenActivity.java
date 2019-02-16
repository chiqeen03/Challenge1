package com.example.mnlgu.challenge1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    public static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(SplashScreenActivity.this, WelcomeActivity.class);
                startActivity(splashIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
