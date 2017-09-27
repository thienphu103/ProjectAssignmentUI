package com.example.a.projectassignmentui.Activity_Screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.a.projectassignmentui.R;

public class SplashActivityResume extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2500;
    ImageView image;
    CountDownTimer waitTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_resume);
        getSupportActionBar().hide();
        image = (ImageView)findViewById(R.id.image_view_icon);
        waitTimer = new CountDownTimer(2000, 1000) {

            public void onTick(long l) {
                final Animation animation1 =
               AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
        image.startAnimation(animation1);
            }

            public void onFinish() {
                final Animation animation1 =
                        AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.translate_up);
                image.startAnimation(animation1);
            }
        }.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivityResume.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


}
