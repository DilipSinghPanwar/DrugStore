package com.bluemortar.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bluemortar.R;
import com.bluemortar.activities.ProductDetailActivity;
import com.bluemortar.beans.Medicine;
import com.bluemortar.customui.CustomTextView;

import java.util.List;


public class MedicineTwoAdapter extends RecyclerView.Adapter<MedicineTwoAdapter.RecyclerViewViewHolder> {

    Context mContext;
    List<Medicine> medicineList;

    public MedicineTwoAdapter(Context mContext, List<Medicine> medicineList) {
        this.mContext = mContext;
        this.medicineList = medicineList;
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_topviewed, parent, false);
        RecyclerViewViewHolder viewHolder = new RecyclerViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {
        holder.tvName.setText(medicineList.get(position).getMedicineName());
        holder.tvPrice.setText("$" + medicineList.get(position).getMedicinePrice());
        holder.tvThumbnail.setBackgroundResource(medicineList.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CustomTextView tvName, tvPrice;
        ImageView tvThumbnail;

        public RecyclerViewViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvThumbnail = itemView.findViewById(R.id.tvThumbnail);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Intent _intent = new Intent(v.getContext(), ProductDetailActivity.class);
            _intent.putExtra("position", position);
            v.getContext().startActivity(_intent);
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