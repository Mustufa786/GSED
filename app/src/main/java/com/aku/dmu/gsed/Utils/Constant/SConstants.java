package com.aku.dmu.gsed.Utils.Constant;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SConstants {

    public final static String _HOST_URL_1 = "http://43.245.131.159:8080/kmc/api/";
    public final static String _HOST_URL_2 = "http://58.65.211.13:8080/kmc/api/";
    public final static String _TEST_URL = "http://10.1.42.30/kmc/api/";
    public final static String[] HOST = new String[]{_HOST_URL_1, _HOST_URL_2/*,_TEST_URL*/};
    private final static String _IP = "43.245.131.159"; // Server 1
    private final static String _ALTERNATE_IP = "58.65.211.13"; // Server 2
    private final static Integer _PORT = 8080; // Port - with colon (:)
    @ComplaintReason
    int complaintReason;

    public void setComplaintReason(@ComplaintReason int complaintReason) {
        this.complaintReason = complaintReason;
    }

    @StringDef({
            _HOST_URL_1,
            _HOST_URL_2,
            _TEST_URL
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplaintReason {
    }

}
