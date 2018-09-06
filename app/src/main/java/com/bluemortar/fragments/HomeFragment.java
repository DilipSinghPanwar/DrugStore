package com.bluemortar.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluemortar.R;
import com.bluemortar.adapters.MedicineOneAdapter;
import com.bluemortar.adapters.MedicineTwoAdapter;
import com.bluemortar.beans.Medicine;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ADMIN on 06-Dec-17.
 */

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private SliderLayout mDemoSlider;
    private Context mContext;
    private ArrayList<Medicine> mMedicineList;
    private RecyclerView mRvTopBrands, mRvTopViewed;
    private MedicineOneAdapter mRvTopBrandsAdapters;
    private MedicineTwoAdapter mRvTopViewedAdapters;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setUpSlider(view);
        setUpTopBrands(view);
        setUpTopViewed(view);
        return view;
    }

    private void setUpSlider(View view) {
        mContext = getActivity();
        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);
        /*HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://www.freepressjournal.in/wp-content/uploads/2016/07/etc-7th-lead-pills.jpg");
        url_maps.put("Big Bang Theory", "https://images.collegexpress.com/article/health-and-medicine.jpg");
        url_maps.put("Hannibal", "http://www.freepressjournal.in/wp-content/uploads/2016/07/etc-7th-lead-pills.jpg");
        url_maps.put("Big Bang Theory", "https://images.collegexpress.com/article/health-and-medicine.jpg");*/

        HashMap<String, Integer> url_maps = new HashMap<String, Integer>();
        url_maps.put("Hannibal", R.drawable.banner_one);
        url_maps.put("Big Bang Theory", R.drawable.banner_one);
        url_maps.put("House of Cards", R.drawable.banner_one);
        url_maps.put("Game of Thrones", R.drawable.banner_one);
        mDemoSlider.removeAllSliders();
        for (String name : url_maps.keySet()) {
            DefaultSliderView textSliderView = new DefaultSliderView(mContext);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.error(R.mipmap.ic_launcher);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        /*if (mDemoSlider != null && mStrBanner != null && mStrBanner.size() > 0) {
            mDemoSlider.startAutoCycle();
        }*/
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
//        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
    
    /*
    top viewed list
     */

    private void setUpTopBrands(View view) {
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
        mRvTopBrands = view.findViewById(R.id.rvTopBrands);
        mRvTopBrands.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRvTopBrands.setHasFixedSize(true);
        mRvTopBrandsAdapters = new MedicineOneAdapter(mContext, mMedicineList);
        mRvTopBrands.setAdapter(mRvTopBrandsAdapters);
    }

    /*
    top viewed
     */
    private void setUpTopViewed(View view) {
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
        mRvTopViewed = view.findViewById(R.id.rvTopViewed);
        mRvTopViewed.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRvTopViewed.setHasFixedSize(true);
        mRvTopViewedAdapters = new MedicineTwoAdapter(mContext, mMedicineList);
        mRvTopViewed.setAdapter(mRvTopViewedAdapters);
    }
}
