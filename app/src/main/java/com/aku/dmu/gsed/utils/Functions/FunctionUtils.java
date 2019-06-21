package com.aku.dmu.gsed.utils.Functions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import com.aku.dmu.gsed.utils.Constant.RConstants;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class FunctionUtils {

    public final static String getTagName(Context mContext) {
        SharedPreferences sharedPref = mContext.getSharedPreferences("tagName", MODE_PRIVATE);
        return sharedPref.getString("tagName", null);
    }

    public final static Calendar getCalendarDate(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(value);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public final static long ageInYear_MonthByDOB(String dateStr, char type) {
        Calendar cal = getCalendarDate(dateStr);
        long ageInYears;

        if (type == 'y')
            ageInYears = Calendar.getInstance().get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        else
            ageInYears = Calendar.getInstance().get(Calendar.MONTH) - cal.get(Calendar.MONTH);

        return ageInYears;
    }

    public final static void stActivity(final Context currentContext, final Activity currentActivity, final Class nextActivity, final Object currentFormInstance) {
        currentActivity.finish();
        Intent end_intent = new Intent(currentContext, nextActivity);
        end_intent.putExtra(RConstants._URI_FC_OBJ, (Serializable) currentFormInstance);
        currentContext.startActivity(end_intent);
    }

    public final static void setParamValues(final Context mContext, final String key, final String value) {
        SharedPreferences shared = mContext.getSharedPreferences("DataParams", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public final static String getParamValue(final Context mContext, final String key) {
        SharedPreferences shared = mContext.getSharedPreferences("DataParams", MODE_PRIVATE);
        return shared.getString(key, "0");
    }

    public final static void endActivitySetRouting(final Context context, final Activity activity, final Class EndActivityClass, final boolean complete, final Object objectData) {
        activity.finish();
        Intent end_intent = new Intent(context, EndActivityClass);
        end_intent.putExtra(RConstants._URI_END_FLAG, complete);
        end_intent.putExtra(RConstants._URI_FC_OBJ, (Serializable) objectData);
        context.startActivity(end_intent);
    }

    public final static void endActivityDirectRouting(final Context context, final Activity activity, final Class EndActivityClass, final boolean complete, final Object objectData) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder
                .setTitle("END INTERVIEW")
                .setCancelable(false)
                .setMessage("Do you want to " + (complete ? "End Interview!!" : "Exit??"))
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                endActivitySetRouting(context, activity, EndActivityClass, complete, objectData);
                            }
                        });
        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
