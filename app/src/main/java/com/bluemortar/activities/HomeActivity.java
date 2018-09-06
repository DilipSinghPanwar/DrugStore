package com.bluemortar.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bluemortar.R;
import com.bluemortar.apputils.MyBottomNavigationView;
import com.bluemortar.customui.CustomTextView;
import com.bluemortar.fragments.AuctionsFragment;
import com.bluemortar.fragments.CategoryFragment;
import com.bluemortar.fragments.DashboardFragment;
import com.bluemortar.fragments.HomeFragment;
import com.bluemortar.fragments.SettingsFragment;

import java.lang.reflect.Field;

public class HomeActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private CustomTextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigationView();
    }

    private void setupNavigationView() {
        MyBottomNavigationView bottomNavigationView = (MyBottomNavigationView) findViewById(R.id.navigation);
        disableShiftMode(bottomNavigationView);
        if (bottomNavigationView != null) {
            // Select first menu item by default and show Fragment accordingly.
            Menu menu = bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));
            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectFragment(item);
                            return false;
                        }
                    });
        }
    }

    protected void selectFragment(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.navigation_home:
                setToolbarTitle(getResources().getString(R.string.title_home));
                pushFragment(new HomeFragment());
                break;
            case R.id.navigation_auction:
                setToolbarTitle(getResources().getString(R.string.title_auction));
                pushFragment(new AuctionsFragment());
                break;
            case R.id.navigation_category:
                setToolbarTitle(getResources().getString(R.string.title_category));
                pushFragment(new CategoryFragment());
                break;
            case R.id.navigation_dashboard:
                setToolbarTitle(getResources().getString(R.string.title_dashboard));
                pushFragment(new DashboardFragment());
                break;
            case R.id.navigation_settings:
                setToolbarTitle(getResources().getString(R.string.title_settings));
                pushFragment(new SettingsFragment());
                break;
        }
    }

    private void setToolbarTitle(String tittle) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mToolbarTitle = toolbar.findViewById(R.id.toolbarTitle);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbarTitle.setText(tittle);
    }

    protected void pushFragment(Fragment fragment) {
        mFragmentManager = getSupportFragmentManager();
        if (fragment == null)
            return;
        if (mFragmentManager != null) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.FrameContainer, fragment);
                ft.commit();
            }
        }
    }

    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
//                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            //Timber.e(e, "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            //Timber.e(e, "Unable to change value of shift mode");
        }
    }
}