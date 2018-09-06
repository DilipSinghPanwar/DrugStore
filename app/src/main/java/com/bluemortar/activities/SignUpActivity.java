package com.bluemortar.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bluemortar.R;
import com.bluemortar.customui.CustomEditText;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rlLoginMain;
    private ImageView ivRegisterLogo;
    private CustomEditText etRegisterEmail;
    private CustomEditText etRegisterPassword;
    private CustomEditText etRegisterConfirmPassword;
    private TextView etRegisterCountry;
    private TextView etRegisterState;
    private TextView etRegisterCity;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
    }

    private void initView() {
        mContext = this;
        rlLoginMain = findViewById(R.id.rl_login_main);
        ivRegisterLogo = findViewById(R.id.iv_register_logo);
        etRegisterEmail = findViewById(R.id.et_register_email);
        etRegisterPassword = findViewById(R.id.et_register_password);
        etRegisterConfirmPassword = findViewById(R.id.et_register_confirm_password);
        etRegisterCountry = findViewById(R.id.et_register_country);
        etRegisterState = findViewById(R.id.et_register_state);
        etRegisterCity = findViewById(R.id.et_register_city);
        findViewById(R.id.btnSignUp).setOnClickListener(this);
        findViewById(R.id.btnGoLogin).setOnClickListener(this);

        etRegisterCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] items = {"India", "United State", "Australia"};
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setTitle("Make your selection");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        etRegisterCountry.setText(items[item]);
                        etRegisterState.setText("");
                        etRegisterCity.setText("");
                        etRegisterState.setHint("State");
                        etRegisterCity.setHint("City");
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        etRegisterState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] items = {"State1", "State2", "State3"};
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setTitle("Make your selection");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        etRegisterState.setText(items[item]);
                        etRegisterCity.setText("");
                        etRegisterCity.setHint("City");
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        etRegisterCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] items = {"City1", "City2", "City3"};
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setTitle("Make your selection");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        etRegisterCity.setText(items[item]);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignUp:
                startActivity(new Intent(mContext, HomeActivity.class));
                break;
            case R.id.btnGoLogin:
                startActivity(new Intent(mContext, SignInActivity.class));
                break;
        }
    }
}
