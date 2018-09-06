package com.bluemortar.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bluemortar.R;
import com.bluemortar.adapters.NotificationAdapter;
import com.bluemortar.beans.Auction;

import java.util.ArrayList;

/**
 * Created by ADMIN on 07-Dec-17.
 */

public class NotificationListActivity extends AppCompatActivity {

    private Context mContext;
    private ArrayList<Auction> mAuctionList;
    private RecyclerView mRvAuction;
    private NotificationAdapter mAuctionAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationlist);
        mContext = this;
        setUpAuctionList();
    }

    private void setUpAuctionList(){
        mAuctionList = new ArrayList<Auction>();
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mRvAuction = (RecyclerView)findViewById(R.id.rvAuction);
        mRvAuction.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mRvAuction.setLayoutManager(mLayoutManager);
        mAuctionAdapter = new NotificationAdapter(mContext,mAuctionList);
        mRvAuction.setAdapter(mAuctionAdapter);

    }
}
