package com.example.hamzasaleem.hci_new;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class CartSplash extends AppCompatActivity {
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_splash);



        ImageView rocketImage = (ImageView) findViewById(R.id.splash_img);
        rocketImage.setBackgroundResource(R.drawable.anim);
        animation = (AnimationDrawable) rocketImage.getBackground();

        animation.setCallback(rocketImage);
        animation.setVisible(true, true);

        animation.start();



        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {

              finish();
            }
        }, 2000);





    }
}
