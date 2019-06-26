package com.aku.dmu.gsed.ui.gsedCRF2.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FragmentCrf2SectionHBinding;
import com.aku.dmu.gsed.ui.gsedCRF2.callbacks.Callbacks;

/**
 * A simple {@link Fragment} subclass.
 */
public class CRF2SectionHFragment extends Fragment {


    Callbacks callbacks;
    FragmentCrf2SectionHBinding bi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_crf2_section_h, container, false);
        bi.setCallback(this);
        getActivity().setTitle(getString(R.string.crf2_sectionh));

        setListeners();

        return bi.getRoot();
    }

    private void setListeners() {

        bi.pd01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {
                    bi.pd01num.setText(null);
                }
            }
        });

        bi.pd01num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.pd01.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.pd02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {
                    bi.pd02num.setText(null);
                }
            }
        });

        bi.pd02num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.pd02.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.pd03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {
                    bi.pd03num.setText(null);
                }
            }
        });

        bi.pd03num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.pd03.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callbacks = (Callbacks) context;
    }

}
