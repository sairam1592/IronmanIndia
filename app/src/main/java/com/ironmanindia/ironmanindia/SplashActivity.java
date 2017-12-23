package com.ironmanindia.ironmanindia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mindvalley on 23/12/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @BindView(R2.id.app_desc_txt)
    TextView app_desc_text;

    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        //start text fadeIn on splash screen
        startFadeInAnimation();
    }

    public void startFadeInAnimation() {
        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        app_desc_text.startAnimation(startAnimation);
        moveToMainActivity();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void moveToMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        }, 2000);
    }
}
