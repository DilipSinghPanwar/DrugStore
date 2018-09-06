package com.bluemortar.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bluemortar.R;
import com.bluemortar.apputils.ProgressHUD;
import com.bluemortar.customui.CustomTextView;

/**
 * Created by ADMIN on 07-Dec-17.
 */

public class ChangePasswordActivity extends AppCompatActivity {

    private Context mContext;
    private Toolbar mToolbar;
    private ProgressHUD mProgressHUD;
    private CustomTextView mToolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        mContext = ChangePasswordActivity.this;
//        mProgressHUD = ProgressHUD.show(mContext, "Connecting", true, true, null);
    }

    public void setUpToolBar() {
        // mToolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // getSupportActionBar().setTitle("Support");
        mToolbarTitle = (CustomTextView) mToolbar.findViewById(R.id.toolbarTitle);
        mToolbarTitle.setText(getString(R.string.ttContact));
        //   Hide tittle
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //   Enable back button
        // add back arrow to mToolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
