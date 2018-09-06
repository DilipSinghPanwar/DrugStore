package com.bluemortar.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bluemortar.R;
import com.bluemortar.customui.CustomTextView;
import com.bluemortar.prefmanager.PrefConnector;

import static com.bluemortar.interfaces.Constant.SPLASH_TIME_OUT;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private Context mContext;
    private Intent intent;
    private ImageView mImgSplashLogo;
    private CustomTextView mTvSplashLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        mConnectionToDrugStore();
        getAppNavigation();
    }

    private void mConnectionToDrugStore() {
        final int[] array = {R.string.SplashLoadingOneDotText, R.string.SplashLoadingTwoDotText, R.string.SplashLoadingThreeDotText, R.string.SplashLoadingFourDotText};
        mTvSplashLoading.post(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                mTvSplashLoading.setText(array[i]);
                i++;
                if (i == 4)
                    i = 0;
                mTvSplashLoading.postDelayed(this, 500);
            }
        });
    }

    private void getAppNavigation() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(SPLASH_TIME_OUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (PrefConnector.readBoolean(mContext, PrefConnector.LOGIN_SESSION, false)) {
                        startActivity(new Intent(mContext, SignInActivity.class));
                        overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                        finish();
                    } else {
                        startActivity(new Intent(mContext, SignInActivity.class));
                        overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                        finish();
                    }
                }
            }
        }).start();
    }

    private void initView() {
        mContext = this;
        mImgSplashLogo = (ImageView) findViewById(R.id.ivSplashlogo);
        mTvSplashLoading = (CustomTextView) findViewById(R.id.tvConnectingTxt);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }
}
