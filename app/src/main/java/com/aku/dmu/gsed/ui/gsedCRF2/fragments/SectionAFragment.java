package com.aku.dmu.gsed.ui.gsedCRF2.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FramentSectionABinding;
import com.aku.dmu.gsed.ui.gsedCRF2.callbacks.Callbacks;
import com.aku.dmu.gsed.validations.ValidatorClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class SectionAFragment extends Fragment {

    Callbacks callbacks;
    FramentSectionABinding bi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.frament_section_a, container, false);

        getActivity().setTitle(getString(R.string.crf2_sectiona));

        return bi.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callbacks = (Callbacks) context;
    }

    public boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(getContext(), bi.fldGrpSectionA01);
    }
}
