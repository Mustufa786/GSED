package com.aku.dmu.gsed.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.ActivityGsedInfoBinding;
import com.aku.dmu.gsed.ui.gsedLF.GSEDLFActivity;
import com.aku.dmu.gsed.ui.gsedSF.GSEDSFActivity;
import com.aku.dmu.gsed.ui.main.MainActivity;
import com.aku.dmu.gsed.utils.Constant.Constants;
import com.aku.dmu.gsed.validations.ValidatorClass;

public class GSEDinfo extends AppCompatActivity {

    ActivityGsedInfoBinding bi;
    String formType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_gsed_info);
        bi.setCallback(this);

        setTitle(R.string.gsed_info);

        formType = getIntent().getStringExtra(Constants.formType);

        setListeners();

    }

    private void setListeners() {

        bi.gsedCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!formValidation())
                    return;

                bi.checkLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    public boolean formValidation() {
        if (bi.gsedCheck.isPressed())
            return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSectionA02);
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSectionA01);
    }


    public void BtnEnd() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void BtnContinue() {
        if (!formValidation())
            return;

        SaveDraft();
        if (UpdateDB()) {

            startActivity(new Intent(this, formType.equals("t6lf") ? GSEDLFActivity.class
                    : formType.equals("t6sf") ? GSEDSFActivity.class : null));
        } else {

            Toast.makeText(this, "Error in updating DB", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() {
    }

}
