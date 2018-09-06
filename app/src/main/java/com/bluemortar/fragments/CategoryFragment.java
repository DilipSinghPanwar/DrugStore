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
import com.bluemortar.adapters.MedicineOneAdapter;
import com.bluemortar.adapters.MedicineTwoAdapter;
import com.bluemortar.beans.Medicine;

import java.util.ArrayList;

/**
 * Created by ADMIN on 06-Dec-17.
 */

public class CategoryFragment extends Fragment {

    private Context mContext;
    private ArrayList<Medicine> mMedicineList;
    private RecyclerView mRvTopBrands, mRvTopViewed;
    private MedicineOneAdapter mRvTopBrandsAdapters;
    private MedicineTwoAdapter mRvTopViewedAdapters;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        setUpCategoryOne(view);
        setUpCategoryTwo(view);
        setUpCategoryThree(view);
        return view;
    }

    /*
    top viewed list
     */

    private void setUpCategoryOne(View view) {
        mMedicineList = new ArrayList<Medicine>();
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "350"));
        mMedicineList.add(new Medicine("Asprin ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "165"));
        mMedicineList.add(new Medicine("Diclofenac", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "280"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "690"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "350"));
        mMedicineList.add(new Medicine("Asprin ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "165"));
        mMedicineList.add(new Medicine("Diclofenac", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "280"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "690"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "350"));
        mMedicineList.add(new Medicine("Asprin ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "165"));
        mMedicineList.add(new Medicine("Diclofenac", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "280"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "690"));
        mRvTopBrands = view.findViewById(R.id.rvCategoryOne);
        mRvTopBrands.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRvTopBrands.setHasFixedSize(true);
        mRvTopBrandsAdapters = new MedicineOneAdapter(mContext, mMedicineList);
        mRvTopBrands.setAdapter(mRvTopBrandsAdapters);
    }

    /*
    top viewed
     */
    private void setUpCategoryTwo(View view) {
        mMedicineList = new ArrayList<Medicine>();
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "350"));
        mMedicineList.add(new Medicine("Asprin ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "165"));
        mMedicineList.add(new Medicine("Diclofenac", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "280"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "690"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "350"));
        mMedicineList.add(new Medicine("Asprin ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "165"));
        mMedicineList.add(new Medicine("Diclofenac", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "280"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "690"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "350"));
        mMedicineList.add(new Medicine("Asprin ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "165"));
        mMedicineList.add(new Medicine("Diclofenac", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "280"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "690"));
        mRvTopViewed = view.findViewById(R.id.rvCategoryTwo);
        mRvTopViewed.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRvTopViewed.setHasFixedSize(true);
        mRvTopViewedAdapters = new MedicineTwoAdapter(mContext, mMedicineList);
        mRvTopViewed.setAdapter(mRvTopViewedAdapters);
    }

    /*
    top viewed
     */
    private void setUpCategoryThree(View view) {
        mMedicineList = new ArrayList<Medicine>();
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "350"));
        mMedicineList.add(new Medicine("Asprin ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "165"));
        mMedicineList.add(new Medicine("Diclofenac", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "280"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "690"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "350"));
        mMedicineList.add(new Medicine("Asprin ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "165"));
        mMedicineList.add(new Medicine("Diclofenac", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "280"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "690"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "350"));
        mMedicineList.add(new Medicine("Asprin ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "165"));
        mMedicineList.add(new Medicine("Diclofenac", R.drawable.home_one, "Maintained by Department of Pharmaceuticals  ", "280"));
        mMedicineList.add(new Medicine("Paracetamol ", R.drawable.home_two, "Maintained by Department of Pharmaceuticals  ", "690"));
        mRvTopViewed = view.findViewById(R.id.rvCategoryThree);
        mRvTopViewed.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRvTopViewed.setHasFixedSize(true);
        mRvTopViewedAdapters = new MedicineTwoAdapter(mContext, mMedicineList);
        mRvTopViewed.setAdapter(mRvTopViewedAdapters);
    }
}
