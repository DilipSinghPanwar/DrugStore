package com.bluemortar.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluemortar.R;
import com.bluemortar.activities.AboutUsActivity;
import com.bluemortar.activities.ChangePasswordActivity;
import com.bluemortar.activities.ContactUsActivity;
import com.bluemortar.activities.EditUpdateProfileActivity;
import com.bluemortar.activities.NotificationListActivity;
import com.bluemortar.activities.OrderHistoryActivity;
import com.bluemortar.activities.PrivacyPolicyActivity;
import com.bluemortar.activities.TermsConditionsActivity;

/**
 * Created by ADMIN on 06-Dec-17.
 */

public class SettingsFragment extends Fragment implements View.OnClickListener {

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mContext = getContext();
        view.findViewById(R.id.llOrderHistory).setOnClickListener(this);
        view.findViewById(R.id.llEditProfile).setOnClickListener(this);
        view.findViewById(R.id.llNotification).setOnClickListener(this);
        view.findViewById(R.id.switchOnOff);
        view.findViewById(R.id.llChangePassword).setOnClickListener(this);
        view.findViewById(R.id.llAboutUs).setOnClickListener(this);
        view.findViewById(R.id.llTermCondition).setOnClickListener(this);
        view.findViewById(R.id.llPrivacyPolicy).setOnClickListener(this);
        view.findViewById(R.id.llContactUs).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llOrderHistory:
                startActivity(new Intent(mContext, OrderHistoryActivity.class));
                getActivity().overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                break;
            case R.id.llEditProfile:
                startActivity(new Intent(mContext, EditUpdateProfileActivity.class));
                getActivity().overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                break;
            case R.id.llNotification:
                startActivity(new Intent(mContext, NotificationListActivity.class));
                getActivity().overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                break;
            case R.id.switchOnOff:
                break;
            case R.id.llChangePassword:
                startActivity(new Intent(mContext, ChangePasswordActivity.class));
                getActivity().overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                break;
            case R.id.llAboutUs:
                startActivity(new Intent(mContext, AboutUsActivity.class));
                getActivity().overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                break;
            case R.id.llTermCondition:
                startActivity(new Intent(mContext, TermsConditionsActivity.class));
                getActivity().overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                break;
            case R.id.llPrivacyPolicy:
                startActivity(new Intent(mContext, PrivacyPolicyActivity.class));
                getActivity().overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                break;
            case R.id.llContactUs:
                startActivity(new Intent(mContext, ContactUsActivity.class));
                getActivity().overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
                break;
            default:
                break;
        }
    }
}
