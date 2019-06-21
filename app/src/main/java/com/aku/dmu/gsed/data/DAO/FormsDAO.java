package com.aku.dmu.gsed.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.aku.dmu.gsed.data.Entities.Clusters;
import com.aku.dmu.gsed.data.Entities.Districts;
import com.aku.dmu.gsed.data.Entities.Forms;
import com.aku.dmu.gsed.data.Entities.UCs;
import com.aku.dmu.gsed.data.Entities.Users;
import com.aku.dmu.gsed.utils.Constant.RConstants;

@Dao
public interface FormsDAO {

    /*Form*/
    @Insert
    Long insertForm(Forms forms);

    @Update
    int updateForm(Forms forms);

    /*Others Sync*/
    @Insert
    Long insertUsers(Users users);

    @Insert
    Long insertClusters(Clusters clusters);

    @Insert
    Long insertDistricts(Districts dist);

    @Insert
    Long insertUcs(UCs uc);

    @Query("DELETE from " + RConstants.TABLE_USERS)
    int deleteUsers();

    @Query("DELETE from " + RConstants.TABLE_CLUSTERS)
    int deleteClusters();

    @Query("DELETE from " + RConstants.TABLE_UCS)
    int deleteUCs();

    @Query("DELETE from " + RConstants.TABLE_DISTRICTS)
    int deleteDistricts();

    /*Update methods after upload on server*/

    /**
     * Updating only sync and syncDate
     * By order id
     */
    @Query("UPDATE Forms SET synced = '1' , synced_date= :synced_date WHERE id =:id")
    int updateSyncedForms(String synced_date, int id);


}
