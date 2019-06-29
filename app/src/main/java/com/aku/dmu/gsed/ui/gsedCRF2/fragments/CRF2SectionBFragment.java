package com.aku.dmu.gsed.ui.gsedCRF2.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FragmentCrf2SectionBBinding;
import com.aku.dmu.gsed.ui.gsedCRF2.callbacks.Callbacks;
import com.aku.dmu.gsed.validations.ValidatorClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class CRF2SectionBFragment extends Fragment {

    Callbacks callbacks;
    FragmentCrf2SectionBBinding bi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_crf2_section_b, container, false);
        bi.setCallback(this);
        getActivity().setTitle(getString(R.string.crf2_sectionb));

        return bi.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callbacks = (Callbacks) context;
    }

    public boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(getContext(), bi.fldGrpSectionB01);
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
            Toast.makeText(getContext(), "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() {
    }
}
