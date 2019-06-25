package com.aku.dmu.gsed.ui.gsedCRF2.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FragmentSectionDBinding;


public class SectionDFragment extends Fragment {

    FragmentSectionDBinding bi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_section_d, container, false);
        bi.setCallback(this);
        getActivity().setTitle(getString(R.string.crf2_sectiond));

        return bi.getRoot();
    }


}
