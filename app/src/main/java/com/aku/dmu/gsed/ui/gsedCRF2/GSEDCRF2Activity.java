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
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.SectionAFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.SectionBFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.SectionCFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.SectionDFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.SectionEFGFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.SectionHFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.SectionIJKFragment;
import com.aku.dmu.gsed.ui.gsedCRF2.fragments.SectionLFragment;

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
        adapter.addFragment(new SectionAFragment(), "CS");
        adapter.addFragment(new SectionBFragment(), "CCH");
        adapter.addFragment(new SectionCFragment(), "CAH");
        adapter.addFragment(new SectionDFragment(), "CA");
        adapter.addFragment(new SectionEFGFragment(), "CRITERIA");
        adapter.addFragment(new SectionHFragment(), "PDH");
        adapter.addFragment(new SectionIJKFragment(), "STATUS");
        adapter.addFragment(new SectionLFragment(), "ASSETS");
        bi.viewpager.setAdapter(adapter);
        bi.tabs.setupWithViewPager(bi.viewpager);

    }

    @Override
    public void validateFragmentOne(boolean validated) {
        valid = validated;
    }
}
