package com.aku.dmu.gsed.ui.gsedCRF2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_gsed_crf2);

        setupViewPager();

        final Fragment fragment = getSupportFragmentManager().findFragmentByTag("android:switcher:" + bi.viewpager + ":" + bi.viewpager.getCurrentItem());

        bi.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


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

        bi.tabs.getTabAt(1).parent.setEnabled(false);

    }

    @Override
    public void validateFragmentOne(boolean validated) {
        valid = validated;
    }
}
