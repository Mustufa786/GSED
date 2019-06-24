package com.aku.dmu.gsed.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.aku.dmu.gsed.GSEDApp;
import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.data.AppDatabase;
import com.aku.dmu.gsed.data.DAO.GetFncDAO;
import com.aku.dmu.gsed.data.Entities.Forms;
import com.aku.dmu.gsed.databinding.ActivityMainBinding;
import com.aku.dmu.gsed.getUtils.db.GetAllDBData;
import com.aku.dmu.gsed.syncUtils.SyncAllData;
import com.aku.dmu.gsed.ui.gsedCRF2.GSEDCRF2Activity;
import com.aku.dmu.gsed.ui.ultrasound.UltrasoundActivity;
import com.aku.dmu.gsed.utils.Constant.RConstants;
import com.aku.dmu.gsed.utils.Constant.SConstants;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import im.dino.dbinspector.activities.DbInspectorActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    AlertDialog.Builder builder;
    String m_Text = "", preVer = "", newVer = "";
    ActivityMainBinding mainBinding;
    private Boolean exit = false;
    private String rSumText = "";
    private boolean updata = false;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setCallback(this);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        mainBinding.lblheader.setText("Welcome!");

        //Setting Database
        db = AppDatabase.getDatabase(this);

//        Admin checking
        if (GSEDApp.admin) {
            mainBinding.adminsec.setVisibility(View.VISIBLE);

            Collection<Forms> todaysForms = null;
            Collection<Forms> unsyncedForms = null;
            try {
                unsyncedForms = (Collection<Forms>) new GetAllDBData(this, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms").execute().get();
                todaysForms = (Collection<Forms>) new GetAllDBData(this, GetFncDAO.class.getName(), "getFncDao", "getTodaysForms").execute(dtToday).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            rSumText += "TODAY'S RECORDS SUMMARY\r\n";

            rSumText += "=======================\r\n";
            rSumText += "\r\n";
            rSumText += "Total Forms Today: " + todaysForms.size() + "\r\n";
            rSumText += "\r\n";
            if (todaysForms.size() > 0) {
                rSumText += "\tFORMS' LIST: \r\n";
                String iStatus;
                rSumText += "--------------------------------------------------\r\n";
                rSumText += "[ Form_ID ] \t[Form Status] \t[Sync Status]----------\r\n";
                rSumText += "--------------------------------------------------\r\n";

                for (Forms fc : todaysForms) {
                    if (fc.getIstatus() != null) {
                        switch (fc.getIstatus()) {
                            case "1":
                                iStatus = "\tComplete";
                                break;
                            case "2":
                                iStatus = "\tIncomplete";
                                break;
                            case "3":
                                iStatus = "\tRefused";
                                break;
                            case "4":
                                iStatus = "\tRefused";
                                break;
                            default:
                                iStatus = "\tN/A";
                        }
                    } else {
                        iStatus = "\tN/A";
                    }

                    rSumText += fc.getId();

                    rSumText += " " + iStatus + " ";

                    rSumText += (fc.getSynced() == null ? "\t\tNot Synced" : "\t\tSynced");
                    rSumText += "\r\n";
                    rSumText += "--------------------------------------------------\r\n";
                }
            }

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            rSumText += "Last Data Download: \t" + syncPref.getString("LastDownSyncServer", "Never Updated");
            rSumText += "\r\n";
            rSumText += "Last Data Upload: \t" + syncPref.getString("LastUpSyncServer", "Never Synced");
            rSumText += "\r\n";
            rSumText += "\r\n";
            rSumText += "Unsynced Forms: \t" + unsyncedForms.size();
            rSumText += "\r\n";

            Log.d(TAG, "onCreate: " + rSumText);
            mainBinding.recordSummary.setText(rSumText);

        } else {
            mainBinding.adminsec.setVisibility(View.GONE);
        }

        /*Add data in Serial date wrt date*/
//        Testing visibility
        if (Integer.valueOf(GSEDApp.versionName.split("\\.")[0]) > 0) {
            mainBinding.testing.setVisibility(View.GONE);
        } else {
            mainBinding.testing.setVisibility(View.VISIBLE);
        }

    }

    public void openForm(String fType) {
        final Intent oF = new Intent(MainActivity.this, selectedForm(fType));

        if (sharedPref.getString("tagName", null) != "" && sharedPref.getString("tagName", null) != null) {
            startActivity(oF);
        } else {

            builder = new AlertDialog.Builder(MainActivity.this);
            ImageView img = new ImageView(getApplicationContext());
            img.setImageResource(R.drawable.tagimg);
            img.setPadding(0, 15, 0, 15);
            builder.setCustomTitle(img);

            final EditText input = new EditText(MainActivity.this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();
                    if (!m_Text.equals("")) {
                        editor.putString("tagName", m_Text);
                        editor.commit();

                        startActivity(oF);
                    }
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
    }

    private Class<?> selectedForm(String fType) {

        Class retClass = null;

        switch (fType) {
            case "t1":
                retClass = UltrasoundActivity.class;
                break;
            case "t2":
                retClass = GSEDCRF2Activity.class;
                break;
        }

        return retClass;
    }

    public void openDB() {
        Intent dbmanager = new Intent(getApplicationContext(), DbInspectorActivity.class);
        startActivity(dbmanager);
    }

    public void testGPS(View v) {

        SharedPreferences sharedPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        Log.d("MAP", "testGPS: " + sharedPref.getAll().toString());
        Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("Map", entry.getKey() + ": " + entry.getValue().toString());
        }

    }

    public void openDB(View v) {
        Intent dbmanager = new Intent(getApplicationContext(), DbInspectorActivity.class);
        startActivity(dbmanager);
    }

    public void uploadData() {

        if (!updata) {
            updata = true;

            // Require permissions INTERNET & ACCESS_NETWORK_STATE
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {

                Toast.makeText(MainActivity.this, "Syncing Forms", Toast.LENGTH_SHORT).show();

                /*Upload Form TOOL 1*/
                Collection collection1 = null;
                try {
                    collection1 = new GetAllDBData(this, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms").execute(RConstants._URI_FORM_TOOL1).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new SyncAllData(
                        this,
                        "Ultrasound",
                        "updateSyncedForms",
                        Forms.class,
                        SConstants._HOST_URL_1 + RConstants.URL_FORMS.replace(".php", RConstants._URI_FORM_TOOL1 + ".php"), collection1
                ).execute();

                SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = syncPref.edit();

                editor.putString("LastUpSyncServer", dtToday);

                editor.apply();

            } else {
                Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
            }
            updata = false;
        }
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity

//            startActivity(new Intent(this, LoginActivity.class));

        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }

}