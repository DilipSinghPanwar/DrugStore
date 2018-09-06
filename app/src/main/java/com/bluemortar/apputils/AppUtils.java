package com.bluemortar.apputils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Typeface;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.bluemortar.R;
import com.bluemortar.interfaces.Constant;
import com.bluemortar.customui.CustomTextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by ADMIN on 02-Sep-17.
 */

public class AppUtils {

    private static final String TAG = AppUtils.class.getSimpleName();

    public static void showAlertDialog(Context mContext, String title, String message) {
        LayoutInflater li = LayoutInflater.from(mContext);
        View view = li.inflate(R.layout.dialog_alert, null);
        CustomTextView tvALertTitle = (CustomTextView) view.findViewById(R.id.tvALertTitle);
        tvALertTitle.setTypeface(tvALertTitle.getTypeface(), Typeface.BOLD);
        CustomTextView tvALertMsg = (CustomTextView) view.findViewById(R.id.tvALertMsg);
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.MyDialogTheme);
//        builder.setTitle(title);
//        builder.setMessage(message);
        tvALertTitle.setText(title);
        tvALertMsg.setText(message);
        builder.setCancelable(false);
        builder.setView(view);
        builder.setPositiveButton(Constant.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private String generatingRandomeNumber() {
        Random random = new Random();
        int low = 10000000;
        int high = 99999999;
        int randomNumber = random.nextInt(high - low) + low;
        return "0" + randomNumber;
    }

    public static String printKeyHash(Activity context) {
        String key = null;
        try {
            //getting application package name, as defined in manifest
            String packageName = context.getApplicationContext().getPackageName();
            //Retriving package info
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            Log.e(TAG, "Package Name: >>" + context.getApplicationContext().getPackageName());
            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));
                // String key = new String(Base64.encodeBytes(md.digest()));
                Log.e(TAG, "printKeyHash: >>" + key);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }

    public static String getDeviceId(Context context) {
//      IMEI is dependent on the Simcard slot, 2 slot have 2 emei no, req permisson
//      TelephonyManager mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//      String imei = mTelephonyMgr.getDeviceId();
        String android_id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return android_id;
    }

    private void getCurrentDateTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mDateformat = new SimpleDateFormat("yyyy-MM-dd ");
        SimpleDateFormat mTimeformat = new SimpleDateFormat("HH:mm:ss");
        String mCurrentDate = mDateformat.format(calendar.getTime());
        String mCurrentTime = mTimeformat.format(calendar.getTime());
    }
}
