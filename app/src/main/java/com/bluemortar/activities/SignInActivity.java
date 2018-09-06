package com.bluemortar.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bluemortar.R;
import com.bluemortar.apputils.UIUtils;
import com.bluemortar.apputils.ValidatorUtils;
import com.bluemortar.interfaces.Constant;
import com.bluemortar.customui.CustomButton;
import com.bluemortar.customui.CustomEditText;
import com.bluemortar.customui.CustomTextView;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SignInActivity.class.getSimpleName();
    private int BackCount = Constant.APPLICATION_BACK_COUNT;
    private Context mContext;
    private ImageView mIvLogo;
    private CustomEditText mEtEmail;
    private CustomEditText mEtPassword;
    private LinearLayout mLlForgotPassword;
    private CustomTextView mTvForgotPassword;
    private CustomButton mBtnLogin;
    private CustomButton mBtnSignup;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        initView();
    }

    private void setValidation() {
        UIUtils.hideKeyBoard(this);
        if (ValidatorUtils.NotEmptyValidator(mContext, mEtEmail, true, getString(R.string.LoginUserNameWithEmailTxt))
                && ValidatorUtils.NotEmptyValidator(mContext, mEtPassword, true, getString(R.string.LoginPasswordTxt))
                && ValidatorUtils.MinimumLengthValidator(mContext, mEtPassword, Constant.MIN_PASSWORD_LENGTH, true,
                getString(R.string.RegisterPasswordMinimumLength))) {
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
//                setValidation();
                startActivity(new Intent(mContext,HomeActivity.class));
                break;
            case R.id.btnSignup:
                intent = new Intent(mContext, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.llForgotPassword:
                showPopup();
                break;
        }
    }

    private void showPopup() {
        final Dialog mDialog;
        mDialog = new Dialog(mContext);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.popup_forgotpwd);
        mDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.setCancelable(false);
        LinearLayout dialogButtonCancel = mDialog.findViewById(R.id.ll_cancel);
        CustomButton close_button = mDialog.findViewById(R.id.close_button);
        final CustomEditText etTextForget = mDialog.findViewById(R.id.et_edit_forgot_text);
        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });

        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });

        LinearLayout dialogButtonCheck = mDialog.findViewById(R.id.ll_check);
        dialogButtonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (ValidatorUtils.NotEmptyValidator(mContext, etTextForget, true, getString(R.string.RegisterEmptyEmail))
//                        && ValidatorUtils.EmailValidator(mContext, etTextForget, true, getString(R.string.RegisterInvalidEmail))) {
//                    startHttpRequestForForgotPassword(etTextForget.getText().toString());
                mDialog.dismiss();
//                }
            }
        });
        mDialog.show();

    }


    @Override
    public void onBackPressed() {
        showExitAlertDialog();
    }

    private void showExitAlertDialog() {
        if (BackCount == Constant.APPLICATION_BACK_EXIT_COUNT) {
            BackCount = Constant.APPLICATION_BACK_COUNT;
            finish();
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.backCountMsg), Toast.LENGTH_SHORT).show();
            BackCount++;
        }
    }


    private void initView() {
        mContext = this;
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mIvLogo = (ImageView) findViewById(R.id.ivLogo);
        mEtEmail = (CustomEditText) findViewById(R.id.etEmail);
        mEtPassword = (CustomEditText) findViewById(R.id.etPassword);
        mLlForgotPassword = (LinearLayout) findViewById(R.id.llForgotPassword);
        mLlForgotPassword.setOnClickListener(this);
        mTvForgotPassword = (CustomTextView) findViewById(R.id.tvForgotPassword);
        mBtnLogin = (CustomButton) findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(this);
        mBtnSignup = (CustomButton) findViewById(R.id.btnSignup);
        mBtnSignup.setOnClickListener(this);
    }
}
