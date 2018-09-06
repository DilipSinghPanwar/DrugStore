package com.bluemortar.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluemortar.R;
import com.bluemortar.adapters.AuctionAdapter;
import com.bluemortar.beans.Auction;

import java.util.ArrayList;

/**
 * Created by ADMIN on 06-Dec-17.
 */

public class AuctionsFragment extends Fragment {

    private Context mContext;
    private ArrayList<Auction> mAuctionList;
    private RecyclerView mRvAuction;
    private AuctionAdapter mAuctionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auction,container, false);
        setUpAuctionList(view);
        return view;
    }

    private void setUpAuctionList(View view){
        mAuctionList = new ArrayList<Auction>();
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mAuctionList.add(new Auction("Assorted Medical Supplies","Group has grown to become the largest medical auction house in the world, with locations in Chicago, Las Vegas and Fort Lauderdale.","123 Main Street","250"));
        mRvAuction = (RecyclerView)view.findViewById(R.id.rvAuction);
        mRvAuction.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRvAuction.setLayoutManager(mLayoutManager);
        mAuctionAdapter = new AuctionAdapter(mContext,mAuctionList);
        mRvAuction.setAdapter(mAuctionAdapter);

    }
}
