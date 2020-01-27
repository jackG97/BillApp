package com.example.billapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {
    // varibles and the time set of the display if the splash screen
    Animation animation;
    public static int SPLASH_TIME = 6000;

    //code for the lauchhing of the app and the splash screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent HomeIntent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(HomeIntent);

                        finish();

            }
        }, SPLASH_TIME);
    }
}
