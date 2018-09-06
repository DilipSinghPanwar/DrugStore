package com.bluemortar.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bluemortar.R;
import com.bluemortar.customui.CustomTextView;


public class ProductDetailActivity extends AppCompatActivity {

    private static final String TAG = ProductDetailActivity.class.getSimpleName();
    private Context mContext;
    private Toolbar mToolbar;
    private CustomTextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);
        mContext = ProductDetailActivity.this;
        setUpToolBar();
    }

    public void setUpToolBar() {
        // mToolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // getSupportActionBar().setTitle("Support");
        mToolbarTitle = (CustomTextView) mToolbar.findViewById(R.id.toolbarTitle);
        mToolbarTitle.setText(getString(R.string.ttProductDetail));
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
    }
}
