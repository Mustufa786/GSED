package com.aku.dmu.gsed.ui.gsedCRF2.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FragmentCrf2SectionCBinding;
import com.aku.dmu.gsed.ui.gsedCRF2.callbacks.Callbacks;
import com.aku.dmu.gsed.validations.ValidatorClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class CRF2SectionCFragment extends Fragment {

    Callbacks callbacks;
    FragmentCrf2SectionCBinding bi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_crf2_section_c, container, false);
        bi.setCallback(this);
        getActivity().setTitle(getString(R.string.crf2_sectionc));

        return bi.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callbacks = (Callbacks) context;
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

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(getContext(), bi.fldGrpSectionC01);
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() {
    }

}
