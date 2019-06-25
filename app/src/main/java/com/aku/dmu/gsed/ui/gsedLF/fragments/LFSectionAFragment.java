package com.aku.dmu.gsed.ui.gsedLF.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FragmentLfSectionABinding;
import com.aku.dmu.gsed.ui.gsedLF.callbacks.LFCallbacks;


/**
 * A simple {@link Fragment} subclass.
 */
public class LFSectionAFragment extends Fragment {

    LFCallbacks callbacks;
    FragmentLfSectionABinding bi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_lf_section_a, container, false);
        bi.setCallback(this);

        getActivity().setTitle(getString(R.string.crf2_sectiona));

        return bi.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callbacks = (LFCallbacks) context;
    }

}
