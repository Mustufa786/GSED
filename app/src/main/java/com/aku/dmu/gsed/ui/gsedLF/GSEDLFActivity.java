package com.aku.dmu.gsed.ui.gsedLF;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.ActivityGsedLfBinding;
import com.aku.dmu.gsed.ui.gsedLF.adapter.LFViewPagerAdapter;
import com.aku.dmu.gsed.ui.gsedLF.callbacks.LFCallbacks;
import com.aku.dmu.gsed.ui.gsedLF.fragments.LFSectionAFragment;

public class GSEDLFActivity extends AppCompatActivity implements LFCallbacks {

    ActivityGsedLfBinding bi;
    boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_gsed_lf);

        setupViewPager();

        final Fragment fragment = getSupportFragmentManager().findFragmentByTag("android:switcher:" + bi.viewpager + ":" + bi.viewpager.getCurrentItem());

        bi.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void setupViewPager() {

        LFViewPagerAdapter adapter = new LFViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LFSectionAFragment(), "SECTION A");
        bi.viewpager.setAdapter(adapter);
        bi.tabs.setupWithViewPager(bi.viewpager);

    }

    @Override
    public void validateFragmentOne(boolean validated) {
        valid = validated;
    }
}
