package com.aku.dmu.gsed.data.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.aku.dmu.gsed.utils.Constant.RConstants;

import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = RConstants.TABLE_UCS)
public class UCs {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String dist_code = "";
    private String uc_code = "";
    private String uc_name = "";

    @Ignore
    public UCs(UCs ucs) {
        this.dist_code = ucs.dist_code;
        this.uc_code = ucs.uc_code;
        this.uc_name = ucs.uc_name;
    }

    @Ignore
    public UCs(String dist_code, String uc_code, String uc_name) {
        this.dist_code = dist_code;
        this.uc_code = uc_code;
        this.uc_name = uc_name;
    }

    public UCs() {
    }

    public UCs Sync(JSONObject jsonObjectCls) throws JSONException {

        this.dist_code = jsonObjectCls.getString("dist_code");
        this.uc_code = jsonObjectCls.getString("uc_code");
        this.uc_name = jsonObjectCls.getString("uc_name");
        return this;
    }

    public String getDist_code() {
        return dist_code;
    }

    public void setDist_code(String dist_code) {
        this.dist_code = dist_code;
    }

    public String getUc_code() {
        return uc_code;
    }

    public void setUc_code(String uc_code) {
        this.uc_code = uc_code;
    }

    public String getUc_name() {
        return uc_name;
    }

    public void setUc_name(String uc_name) {
        this.uc_name = uc_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
