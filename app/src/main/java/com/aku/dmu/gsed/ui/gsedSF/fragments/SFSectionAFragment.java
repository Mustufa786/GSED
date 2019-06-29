package com.aku.dmu.gsed.ui.gsedSF.fragments;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FragmentSfSectionABinding;
import com.aku.dmu.gsed.ui.gsedSF.callbacks.SFCallbacks;
import com.aku.dmu.gsed.ui.main.MainActivity;
import com.aku.dmu.gsed.validations.ValidatorClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class SFSectionAFragment extends Fragment {

    SFCallbacks callbacks;
    FragmentSfSectionABinding bi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_sf_section_a, container, false);
        bi.setCallback(this);

        getActivity().setTitle(getString(R.string.crf2_sectiona));

        return bi.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callbacks = (SFCallbacks) context;
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
            getActivity().startActivity(new Intent(getContext(), MainActivity.class));
        } else {


        }


    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() {
    }
}
