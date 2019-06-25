package com.aku.dmu.gsed.ui.gsedSF;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.ActivityGsedCrf2Binding;
import com.aku.dmu.gsed.ui.gsedSF.adapter.SFViewPagerAdapter;
import com.aku.dmu.gsed.ui.gsedSF.callbacks.SFCallbacks;
import com.aku.dmu.gsed.ui.gsedSF.fragments.SFSectionAFragment;

public class GSEDSFActivity extends AppCompatActivity implements SFCallbacks {

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

        SFViewPagerAdapter adapter = new SFViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SFSectionAFragment(), "CS");
        bi.viewpager.setAdapter(adapter);
        bi.tabs.setupWithViewPager(bi.viewpager);

    }

    @Override
    public void validateFragmentOne(boolean validated) {
        valid = validated;
    }
}
