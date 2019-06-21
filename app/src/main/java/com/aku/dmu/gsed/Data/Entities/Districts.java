package com.aku.dmu.gsed.Data.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.aku.dmu.gsed.Utils.Constant.RConstants;

import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = RConstants.TABLE_DISTRICTS)
public class Districts {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String dist_code = "";
    private String dist_name = "";

    @Ignore
    public Districts(Districts dist) {
        this.dist_code = dist.dist_code;
        this.dist_name = dist.dist_name;
    }

    @Ignore
    public Districts(String dist_code, String dist_name) {
        this.dist_code = dist_code;
        this.dist_name = dist_name;
    }

    public Districts() {
    }

    public String getDist_code() {
        return dist_code;
    }

    public void setDist_code(String dist_code) {
        this.dist_code = dist_code;
    }

    public String getDist_name() {
        return dist_name;
    }

    public void setDist_name(String dist_name) {
        this.dist_name = dist_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Districts Sync(JSONObject jsonObjectCls) throws JSONException {

        this.dist_code = jsonObjectCls.getString("dist_code");
        this.dist_name = jsonObjectCls.getString("dist_name");
        return this;
    }

}
