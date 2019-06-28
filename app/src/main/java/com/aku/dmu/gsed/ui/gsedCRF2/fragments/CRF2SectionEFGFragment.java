package com.aku.dmu.gsed.ui.gsedCRF2.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FragmentCrf2SectionEfgBinding;
import com.aku.dmu.gsed.ui.gsedCRF2.callbacks.Callbacks;
import com.aku.dmu.gsed.validations.ValidatorClass;

/**
 * A simple {@link Fragment} subclass.
 */
public class CRF2SectionEFGFragment extends Fragment {


    Callbacks callbacks;
    FragmentCrf2SectionEfgBinding bi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_crf2_section_efg, container, false);
        bi.setCallback(this);
        getActivity().setTitle(getString(R.string.crf2_sectione));

        settngListeners();

        return bi.getRoot();
    }

    private void settngListeners() {

        bi.hs0298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    bi.hs01.setText(null);
                    bi.hs0299.setChecked(false);
                }
            }
        });
        bi.hs0299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    bi.hs01.setText(null);
                    bi.hs0298.setChecked(false);
                }
            }
        });
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


        } else {


        }


    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(getContext(), bi.fldGrpSectionefg);
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() {
    }

}
