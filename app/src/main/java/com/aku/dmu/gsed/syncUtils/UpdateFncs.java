package com.aku.dmu.gsed.syncUtils;

import android.content.Context;

import com.aku.dmu.gsed.data.AppDatabase;
import com.aku.dmu.gsed.data.DAO.FormsDAO;
import com.aku.dmu.gsed.rmOperations.UpdateSyncedStatus;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public abstract class UpdateFncs {

    public static void updateSyncedForms(Context mContext, int _id) {
        try {
            new UpdateSyncedStatus(AppDatabase.getDatabase(mContext), new Date().toString(), _id).execute(FormsDAO.class.getName(), "formsDao", "updateSyncedForms").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
