package com.bluemortar.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bluemortar.R;
import com.bluemortar.adapters.OrderHistoryAdapter;
import com.bluemortar.beans.OrderHistory;
import com.bluemortar.customui.CustomTextView;

import java.util.ArrayList;

/**
 * Created by ADMIN on 07-Dec-17.
 */

public class OrderHistoryActivity extends AppCompatActivity {

    private Context mContext;
    private Toolbar mToolbar;
    private CustomTextView mToolbarTitle;
    private ArrayList<OrderHistory> mAuctionList;
    private RecyclerView mRvOrderHistory;
    private OrderHistoryAdapter mAuctionAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderhistory);
        mContext = this;
        setUpAuctionList();
        setUpToolBar();
    }

    public void setUpToolBar() {
        // mToolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // getSupportActionBar().setTitle("Support");
        mToolbarTitle = (CustomTextView) mToolbar.findViewById(R.id.toolbarTitle);
        mToolbarTitle.setText(getString(R.string.ttOrderHistory));
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

    private void setUpAuctionList() {
        mAuctionList = new ArrayList<OrderHistory>();
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mAuctionList.add(new OrderHistory("1234", "Medicine", "Pickup 12 Nov 2017", "250"));
        mRvOrderHistory = findViewById(R.id.rvOrderHistory);
        mRvOrderHistory.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mRvOrderHistory.setLayoutManager(mLayoutManager);
        mAuctionAdapter = new OrderHistoryAdapter(mContext, mAuctionList);
        mRvOrderHistory.setAdapter(mAuctionAdapter);

    }
}
