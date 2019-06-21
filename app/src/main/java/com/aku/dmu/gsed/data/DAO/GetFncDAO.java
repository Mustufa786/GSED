package com.aku.dmu.gsed.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.aku.dmu.gsed.data.Entities.Clusters;
import com.aku.dmu.gsed.data.Entities.Districts;
import com.aku.dmu.gsed.data.Entities.Forms;
import com.aku.dmu.gsed.data.Entities.UCs;
import com.aku.dmu.gsed.data.Entities.Users;
import com.aku.dmu.gsed.utils.Constant.RConstants;

import java.util.List;

@Dao
public interface GetFncDAO {

    @Query("SELECT * FROM " + RConstants.TABLE_FORMS + " WHERE synced = ''")
    List<Forms> getUnSyncedForms();

    @Query("SELECT * FROM " + RConstants.TABLE_FORMS)
    List<Forms> getForms();

    @Query("SELECT * FROM " + RConstants.TABLE_FORMS + " WHERE synced = '' AND formType = :formType")
    List<Forms> getUnSyncedForms(String formType);

    @Query("SELECT * FROM " + RConstants.TABLE_FORMS + " WHERE formType = :formType")
    List<Forms> getForms(String formType);

    @Query("SELECT * FROM " + RConstants.TABLE_FORMS + " WHERE formDate LIKE :date")
    List<Forms> getTodaysForms(String date);

    @Query("SELECT * FROM " + RConstants.TABLE_USERS + " where ROW_USERNAME=:username AND ROW_PASSWORD=:password")
    Users login(String username, String password);

    @Query("SELECT * FROM " + RConstants.TABLE_CLUSTERS + " where cluster_code=:clusterCode")
    Clusters getClusterRecord(String clusterCode);

    @Query("SELECT * FROM " + RConstants.TABLE_FORMS + " where participantID=:child_id and (formType = '1a' or formType = '1b') and istatus = '1' order by id DESC")
    Forms getChildRecord(String child_id);

    @Query("SELECT * FROM " + RConstants.TABLE_FORMS + " where participantID=:part_id and istatus = '1' and formType != '14' order by id DESC")
    Forms checkParticipantExist(String part_id);

    /*
     * Spinner Items
     */
    @Query("SELECT * FROM " + RConstants.TABLE_DISTRICTS)
    List<Districts> getAllDistricts();

    @Query("SELECT * FROM " + RConstants.TABLE_UCS + " where dist_code=:distCode")
    List<UCs> getAllUcsByDistricts(String distCode);

}
