package com.bluemortar.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bluemortar.R;
import com.bluemortar.adapters.CartDetailsAdapter;
import com.bluemortar.apputils.ProgressHUD;
import com.bluemortar.beans.Auction;
import com.bluemortar.customui.CustomTextView;

import java.util.ArrayList;

import static com.bluemortar.apputils.AppUtils.showAlertDialog;
import static com.bluemortar.apputils.Utils.isConnectingToInternet;


public class CartDetailsActivity extends AppCompatActivity {

    private Context mContext;
    private Toolbar mToolbar;
    private ProgressHUD mProgressHUD;
    private CustomTextView mToolbarTitle;
    private ArrayList<Auction> mAuctionList;
    private RecyclerView mRvAuction;
    private CartDetailsAdapter mCartDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartdetails);
        setUpToolBar();
        mContext = CartDetailsActivity.this;
//        mProgressHUD = ProgressHUD.show(mContext, "Connecting", true, true, null);
//        mProgressHUD.show();
//        mProgressHUD.dismiss();
        setUpAuctionList();
        if (isConnectingToInternet(mContext)) {

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
        mToolbarTitle.setText(getString(R.string.ttCartDetails));
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

    private void setUpAuctionList(){
        mAuctionList = new ArrayList<Auction>();
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mRvAuction = (RecyclerView)findViewById(R.id.rvAuction);
        mRvAuction.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mRvAuction.setLayoutManager(mLayoutManager);
        mCartDetailAdapter = new CartDetailsAdapter(mContext,mAuctionList);
        mRvAuction.setAdapter(mCartDetailAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
    }
}
