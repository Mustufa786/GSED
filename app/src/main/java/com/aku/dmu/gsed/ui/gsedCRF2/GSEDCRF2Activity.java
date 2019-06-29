package com.aku.dmu.gsed.ui.gsedCRF2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.ActivityGsedCrf2Binding;
import com.aku.dmu.gsed.ui.gsedCRF2.adapter.ViewPagerAdapter;
import com.aku.dmu.gsed.ui.gsedCRF2.callbacks.Callbacks;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.CRF2SectionAFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.CRF2SectionBFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.CRF2SectionCFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.CRF2SectionDFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.CRF2SectionEFGFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.CRF2SectionHFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.CRF2SectionIJKFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.CRF2SectionLFragment;

public class GSEDCRF2Activity extends AppCompatActivity implements Callbacks {

    ActivityGsedCrf2Binding bi;
    boolean valid;
    LinearLayout tabStrip;
    int item = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_gsed_crf2);

        setupViewPager();


    }

    private void setupViewPager() {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CRF2SectionAFragment(), "CS");
        adapter.addFragment(new CRF2SectionBFragment(), "CCH");
        adapter.addFragment(new CRF2SectionCFragment(), "CAH");
        adapter.addFragment(new CRF2SectionDFragment(), "CA");
        adapter.addFragment(new CRF2SectionEFGFragment(), "CRITERIA");
        adapter.addFragment(new CRF2SectionHFragment(), "PDH");
        adapter.addFragment(new CRF2SectionIJKFragment(), "STATUS");
        adapter.addFragment(new CRF2SectionLFragment(), "ASSETS");
        bi.viewpager.setAdapter(adapter);
        bi.tabs.setupWithViewPager(bi.viewpager);
        bi.viewpager.beginFakeDrag();

        tabStrip = ((LinearLayout) bi.tabs.getChildAt(0));
        for (int i = 1; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setEnabled(false);

        }


    }


    private int getItem(int i) {
        return bi.viewpager.getCurrentItem() + i;
    }

    @Override
    public void validated(boolean isValidated) {
        valid = isValidated;
        if (valid) {
            item = getItem(+1);
            bi.viewpager.setCurrentItem(item, true);
            enabledNextForm(item);
        } else {
            Toast.makeText(this, "Please form firs!", Toast.LENGTH_SHORT).show();
        }
    }

    private void enabledNextForm(int item) {
        tabStrip.getChildAt(item).setEnabled(true);
    }
}
