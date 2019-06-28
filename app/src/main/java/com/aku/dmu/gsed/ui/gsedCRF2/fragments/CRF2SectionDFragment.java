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
import com.aku.dmu.gsed.databinding.FragmentCrf2SectionDBinding;
import com.aku.dmu.gsed.ui.gsedCRF2.callbacks.Callbacks;
import com.aku.dmu.gsed.validations.ValidatorClass;


public class CRF2SectionDFragment extends Fragment {

    Callbacks callbacks;
    FragmentCrf2SectionDBinding bi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_crf2_section_d, container, false);
        bi.setCallback(this);
        getActivity().setTitle(getString(R.string.crf2_sectiond));

        setListeners();

        return bi.getRoot();
    }

    private void setListeners() {

        bi.ca02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca02a.setText(null);

                }
            }
        });

        bi.ca02a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca02.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca03a.setText(null);

                }
            }
        });

        bi.ca03a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca03.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca04a.setText(null);

                }
            }
        });

        bi.ca04a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca04.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca05a.setText(null);

                }
            }
        });

        bi.ca05a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca05.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca06a.setText(null);

                }
            }
        });

        bi.ca06a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca06.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca07a.setText(null);

                }
            }
        });

        bi.ca07a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca07.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca08a.setText(null);

                }
            }
        });

        bi.ca08a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca08.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca09a.setText(null);

                }
            }
        });

        bi.ca09a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca09.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca10a.setText(null);

                }
            }
        });

        bi.ca10a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca10.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca11a.setText(null);

                }
            }
        });

        bi.ca11a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca11.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca12a.setText(null);

                }
            }
        });

        bi.ca12a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca12.clearCheck();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.ca13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() != -1) {

                    bi.ca13a.setText(null);

                }
            }
        });

        bi.ca13a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().isEmpty()) {
                    bi.ca13.clearCheck();
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

        return ValidatorClass.EmptyCheckingContainer(getContext(), bi.fldGrpSectionD);
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() {
    }


}
