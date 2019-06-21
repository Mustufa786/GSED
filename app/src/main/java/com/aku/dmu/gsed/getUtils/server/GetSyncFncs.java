package com.aku.dmu.gsed.getUtils.server;

import android.content.Context;

import com.aku.dmu.gsed.data.AppDatabase;
import com.aku.dmu.gsed.data.DAO.FormsDAO;
import com.aku.dmu.gsed.data.Entities.Clusters;
import com.aku.dmu.gsed.data.Entities.Districts;
import com.aku.dmu.gsed.data.Entities.UCs;
import com.aku.dmu.gsed.data.Entities.Users;
import com.aku.dmu.gsed.rmOperations.CrudOperations;
import com.aku.dmu.gsed.rmOperations.SyncOperations;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class GetSyncFncs {

    public static void syncUsers(Context mContext, JSONArray userlist) {

        AppDatabase db = AppDatabase.getDatabase(mContext);

        new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteUsers");

        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                Users users = new Users();
                users.Sync(jsonObjectUser);

                new CrudOperations(mContext, FormsDAO.class.getName(), "formsDao", "insertUsers", users).execute().get();
            }
            db.close();

        } catch (Exception e) {
        }
    }

    public static void syncClusters(Context mContext, JSONArray clusterList) {

        AppDatabase db = AppDatabase.getDatabase(mContext);

        new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteClusters");

        try {
            JSONArray jsonArray = clusterList;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                Clusters clusters = new Clusters();
                clusters.Sync(jsonObjectUser);

                new CrudOperations(mContext, FormsDAO.class.getName(), "formsDao", "insertClusters", clusters).execute().get();
            }
            db.close();

        } catch (Exception e) {
        }
    }

    public static void syncDistricts(Context mContext, JSONArray distList) {

        AppDatabase db = AppDatabase.getDatabase(mContext);

        new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteDistricts");

        try {
            JSONArray jsonArray = distList;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                Districts dist = new Districts();
                dist.Sync(jsonObjectUser);

                new CrudOperations(mContext, FormsDAO.class.getName(), "formsDao", "insertDistricts", dist).execute().get();
            }
            db.close();

        } catch (Exception e) {
        }
    }

    public static void syncUcs(Context mContext, JSONArray ucsList) {

        AppDatabase db = AppDatabase.getDatabase(mContext);

        new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteUCs");

        try {
            JSONArray jsonArray = ucsList;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UCs ucs = new UCs();
                ucs.Sync(jsonObjectUser);

                new CrudOperations(mContext, FormsDAO.class.getName(), "formsDao", "insertUcs", ucs).execute().get();
            }
            db.close();

        } catch (Exception e) {
        }
    }

}
