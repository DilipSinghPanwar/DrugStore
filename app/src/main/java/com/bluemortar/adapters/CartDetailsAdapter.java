package com.bluemortar.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluemortar.R;
import com.bluemortar.beans.Auction;
import com.bluemortar.customui.CustomTextView;

import java.util.List;


public class CartDetailsAdapter extends RecyclerView.Adapter<CartDetailsAdapter.RecyclerViewViewHolder> {

    private Context mContext;
    private List<Auction> auctionList;

    public CartDetailsAdapter(Context mContext, List<Auction> auctionList) {
        this.mContext = mContext;
        this.auctionList = auctionList;
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cartdetails, parent, false);
        RecyclerViewViewHolder viewHolder = new RecyclerViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {
        holder.productName.setText(auctionList.get(position).getProductName());
        holder.productInfo.setText(auctionList.get(position).getProductInfo());
        holder.productLocation.setText("Location: " + auctionList.get(position).getProductLocation());
    }

    @Override
    public int getItemCount() {
        return auctionList.size();
    }

    public class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CustomTextView productName, productInfo, productLocation;

        public RecyclerViewViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            productName = itemView.findViewById(R.id.tvName);
            productInfo = itemView.findViewById(R.id.tvDescription);
//            productLocation = itemView.findViewById(R.id.tvLocation);
        }

        @Override
        public void onClick(View v) {
//            int position = getLayoutPosition();
//            Intent _intent = new Intent(v.getContext(), ProductDetailActivity.class);
//            _intent.putExtra("position", position);
//            v.getContext().startActivity(_intent);
//            v.getContext().overridePendingTransition(R.anim.activity_left, R.anim.activity_right);
           /* switch (pos){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
            }*/

        }
    }

}