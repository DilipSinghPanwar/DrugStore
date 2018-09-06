package com.bluemortar.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bluemortar.R;
import com.bluemortar.apputils.ProgressHUD;
import com.bluemortar.customui.CustomTextView;

import static com.bluemortar.apputils.AppUtils.showAlertDialog;
import static com.bluemortar.apputils.Utils.isConnectingToInternet;


public class PrivacyPolicyActivity extends AppCompatActivity {

    private Context mContext;
    private Toolbar mToolbar;
    private ProgressHUD mProgressHUD;
    private WebView mWebview;
    private CustomTextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termscondition);
        setUpToolBar();
        mContext = PrivacyPolicyActivity.this;
        mProgressHUD = ProgressHUD.show(mContext, "Connecting", true, true, null);
        mWebview = findViewById(R.id.webView);
        mWebview.setLongClickable(false);
        mWebview.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                return true;
            }
        });
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.setBackgroundColor(Color.TRANSPARENT);
        if (isConnectingToInternet(mContext)) {
            startWebView("http://demozero.grubpoints.com/show_about");
        } else {
            showAlertDialog(mContext, getString(R.string.networkError), getString(R.string.internetOff));
        }
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

    private void startWebView(String url) {
        mWebview.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressHUD.show();
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onLoadResource(WebView view, String url) {

            }

            public void onPageFinished(WebView view, String url) {
                mProgressHUD.dismiss();
            }

        });

        mWebview.loadUrl(url);
    }

    // To handle "Back" key press event for WebView to go back to previous screen.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebview.canGoBack()) {
            mWebview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
    }
}
