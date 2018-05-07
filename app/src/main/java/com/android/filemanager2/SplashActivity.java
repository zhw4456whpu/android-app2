package com.android.filemanager2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {

    private ImageView mSplashImage;
    private TextView mVersionName;
    private TextView mCopyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //todo
        mSplashImage = (ImageView)findViewById(R.id.splash_image);
        mVersionName = (TextView)findViewById(R.id.splash_version_name);
        mCopyright   = (TextView)findViewById(R.id.splash_copyright);

        mCopyright.setText(getResources().getString(R.string.splash_copyright));
        mVersionName.setText(getVersionName(getApplication()));

        Animation animation = AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.splash
        );

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mSplashImage.startAnimation(animation);

    }
    private String getVersionName(Context context) {
        String versionName = null;
        try {
            versionName = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
        //
    }
}
