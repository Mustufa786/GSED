package com.aku.dmu.gsed.ui.ultrasound;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.ActivityUltrasoundBinding;
import com.aku.dmu.gsed.jsonGenerator.GeneratorClass;
import com.aku.dmu.gsed.ui.main.MainActivity;
import com.aku.dmu.gsed.validations.ValidatorClass;

import org.json.JSONObject;

public class UltrasoundActivity extends AppCompatActivity {

    ActivityUltrasoundBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_ultrasound);
        bi.setCallback(this);

    }

    public void BtnEnd() {

    }

    public void BtnContinue() {
        if (!formValidation())
            return;

        SaveDraft();
        if (UpdateDB()) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() {

        JSONObject json = GeneratorClass.getContainerJSON(bi.fldGrpUltrasound, true);

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpUltrasound);
    }

}
