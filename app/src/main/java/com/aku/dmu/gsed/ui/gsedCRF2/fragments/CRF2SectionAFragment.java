package com.aku.dmu.gsed.ui.gsedCRF2.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FragmentCrf2SectionABinding;
import com.aku.dmu.gsed.ui.gsedCRF2.callbacks.Callbacks;
import com.aku.dmu.gsed.validations.ValidatorClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class CRF2SectionAFragment extends Fragment {

    Callbacks callbacks;
    FragmentCrf2SectionABinding bi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_crf2_section_a, container, false);
        bi.setCallback(this);

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

    public void BtnEnd() {

    }

    public void BtnContinue() {
        if (!formValidation())
            return;
        SaveDraft();
        if (UpdateDB()) {
            callbacks.validated(true);
        } else {


        }


    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() {
    }
}
