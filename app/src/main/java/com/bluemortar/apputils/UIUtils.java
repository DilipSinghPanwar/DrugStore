package com.bluemortar.apputils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


public class UIUtils {

    public static void showToast(Context aContext, String aMag) {
        Toast.makeText(aContext, aMag, Toast.LENGTH_SHORT).show();
    }

    public static void hideKeyBoard(Activity mActivity) {
        View view = mActivity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
