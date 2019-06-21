package com.aku.dmu.gsed.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.aku.dmu.gsed.Data.DAO.FormsDAO;
import com.aku.dmu.gsed.Data.DAO.GetFncDAO;
import com.aku.dmu.gsed.Data.Entities.Clusters;
import com.aku.dmu.gsed.Data.Entities.Districts;
import com.aku.dmu.gsed.Data.Entities.Forms;
import com.aku.dmu.gsed.Data.Entities.UCs;
import com.aku.dmu.gsed.Data.Entities.Users;
import com.aku.dmu.gsed.Utils.Constant.RConstants;

@Database(entities = {Forms.class, Clusters.class, Users.class, Districts.class, UCs.class}, version = RConstants.DATABASE_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    public static AppDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, AppDatabase.class, RConstants.DATABASE_NAME)
                            .setJournalMode(JournalMode.TRUNCATE)
                            .build();
                }
            }
        }
        return sInstance;
    }

    public abstract FormsDAO formsDao();

    public abstract GetFncDAO getFncDao();

}
