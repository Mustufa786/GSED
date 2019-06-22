package com.aku.dmu.gsed.ui.ultrasound.view;

import com.aku.dmu.gsed.data.Entities.Forms;

public interface UltrasoundView {

    interface UltrasoundActivity {

        boolean formValidation(UltrasoundActivity activity);

        void saveDraft(UltrasoundActivity activity);

        boolean updateDB(Forms forms);

        void btnEnd();

        void btnContinue();

    }

}
