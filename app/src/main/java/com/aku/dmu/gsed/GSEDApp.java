package com.aku.dmu.gsed;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;

import com.aku.dmu.gsed.customServices.LocationService;

public class GSEDApp extends Application {

    public static String deviceId;
    public static Boolean admin = false;
    public static int versionCode;
    public static String versionName;
    public static long installedOn;
    public static String[] loginMem;
    public static String IMEI;

    @Override
    public void onCreate() {
        super.onCreate();
//        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/JameelNooriNastaleeq.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
//        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/JameelNooriNastaleeq.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf

        // Device Id
        deviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        // Versioning
        try {
            String packageName = getApplicationContext().getPackageName();
            installedOn = this
                    .getPackageManager()
                    .getPackageInfo(packageName, 0)
                    .lastUpdateTime;
            versionCode = this
                    .getPackageManager()
                    .getPackageInfo(packageName, 0)
                    .versionCode;
            versionName = this
                    .getPackageManager()
                    .getPackageInfo(packageName, 0)
                    .versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        // Start Loc Service
        startService(new Intent(this, LocationService.class));

    }


}
