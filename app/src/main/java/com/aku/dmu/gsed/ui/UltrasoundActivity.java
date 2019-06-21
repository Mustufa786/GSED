package com.aku.dmu.gsed.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.ActivityUltrasoundBinding;

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

    private void SaveDraft() {

    }

    private boolean formValidation() {

        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
