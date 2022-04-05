package com.developerx.ims;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.Bundle;

/* This file is used to create a splash screen */
public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = (ImageView) findViewById(R.id.splash_screen_logo);
        TextView name = (TextView) findViewById(R.id.splash_screen_name);


        //  create animations from resources
        Animation fromBottom = AnimationUtils.loadAnimation(this,R.anim.from_bottom);
        Animation fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);

        //  apply animations
        logo.setAnimation(fromBottom);
        name.setAnimation(fadeIn);

        // delay for app name to appear
        fadeIn.setStartOffset(2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent catalogIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(catalogIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}