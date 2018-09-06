package com.bluemortar.apputils;


import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtil {
    public static final String[] ALL_APP_PERMISSIONS = {
            Manifest.permission.ACCESS_NETWORK_STATE
    };

    @TargetApi(Build.VERSION_CODES.M)
    public static boolean isPermissionGranted(Context aContext, String aPermissionStr) {
        boolean permissionGranted = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(aContext, aPermissionStr) == PackageManager.PERMISSION_GRANTED) {
                permissionGranted = true;
            }
        } else {
            permissionGranted = true;
        }
        return permissionGranted;
    }

    public static void requestAppForPermission(Activity aActivity, String[] aPermissionArr, int aRequestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (aPermissionArr.length > 0) {
                ActivityCompat.requestPermissions(aActivity,
                        aPermissionArr,
                        aRequestCode);
            }
        }
    }

    public static String[] getAllDeniedPermissions(Context aContext, String[] aPermissionArr) {
        List<String> deniedPermissions = new ArrayList<>();
        for (String str : aPermissionArr) {
            if (!isPermissionGranted(aContext, str)) {
                deniedPermissions.add((str));
            }
        }
        return deniedPermissions.toArray(new String[deniedPermissions.size()]);
    }

    public static boolean isAllPermissionGranted(Context aContext, String[] aPermissionArr) {
        boolean permissionGranted = true;
        for (String aStr : aPermissionArr) {
            if (ContextCompat.checkSelfPermission(aContext, aStr)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionGranted = false;
            }
        }
        return permissionGranted;
    }
}
