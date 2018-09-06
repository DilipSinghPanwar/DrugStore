package com.bluemortar.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluemortar.R;
import com.bluemortar.activities.ProductDetailActivity;
import com.bluemortar.apputils.ProgressHUD;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

/**
 * Created by ADMIN on 06-Dec-17.
 */

public class DashboardFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {

    private Context mContext;
    private ProgressHUD mProgressHUD;
    private SliderLayout mDemoSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView(view);
        setUpSlider(view);
//        TimeConsumingTask t = new TimeConsumingTask();
//        t.execute();
        return view;
    }

    public void initView(View view) {
        view.findViewById(R.id.rlOne).setOnClickListener(this);
        view.findViewById(R.id.rlTwo).setOnClickListener(this);
        view.findViewById(R.id.rlThree).setOnClickListener(this);
        view.findViewById(R.id.rlFour).setOnClickListener(this);
        view.findViewById(R.id.rlFive).setOnClickListener(this);
        view.findViewById(R.id.rlSix).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlOne:
                startActivity(new Intent(mContext, ProductDetailActivity.class));
                break;
            case R.id.rlTwo:
                startActivity(new Intent(mContext, ProductDetailActivity.class));
                break;
            case R.id.rlThree:
                startActivity(new Intent(mContext, ProductDetailActivity.class));
                break;
            case R.id.rlFour:
                startActivity(new Intent(mContext, ProductDetailActivity.class));
                break;
            case R.id.rlFive:
                startActivity(new Intent(mContext, ProductDetailActivity.class));
                break;
            case R.id.rlSix:
                startActivity(new Intent(mContext, ProductDetailActivity.class));
                break;
        }
    }

    private class TimeConsumingTask extends AsyncTask<Void, String, Void> implements DialogInterface.OnCancelListener {
        @Override
        protected void onPreExecute() {
            mProgressHUD = ProgressHUD.show(getActivity(), "Connecting", true, true, this);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                publishProgress("Connecting");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mProgressHUD.setMessage(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void result) {
            mProgressHUD.dismiss();
            super.onPostExecute(result);
        }

        @Override
        public void onCancel(DialogInterface dialog) {
            this.cancel(true);
            mProgressHUD.dismiss();
        }
    }

    /*
    slider
     */
    private void setUpSlider(View view) {
        mContext = getActivity();
        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);
//        HashMap<String, String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://www.freepressjournal.in/wp-content/uploads/2016/07/etc-7th-lead-pills.jpg");
//        url_maps.put("Big Bang Theory", "https://images.collegexpress.com/article/health-and-medicine.jpg");
//        url_maps.put("Hannibal", "http://www.freepressjournal.in/wp-content/uploads/2016/07/etc-7th-lead-pills.jpg");
//        url_maps.put("Big Bang Theory", "https://images.collegexpress.com/article/health-and-medicine.jpg");

        HashMap<String, Integer> url_maps = new HashMap<String, Integer>();
        url_maps.put("Hannibal", R.drawable.banner_one);
        url_maps.put("Big Bang Theory", R.drawable.banner_one);
        url_maps.put("House of Cards", R.drawable.banner_one);
        url_maps.put("Game of Thrones", R.drawable.banner_one);

        mDemoSlider.removeAllSliders();
        for (String name : url_maps.keySet()) {
//            TextSliderView textSliderView = new TextSliderView(mContext);
            DefaultSliderView textSliderView = new DefaultSliderView(mContext);
            // initialize a SliderLayout
            textSliderView
//                    .description(name)
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


}
