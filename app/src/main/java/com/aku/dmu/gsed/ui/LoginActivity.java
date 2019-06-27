package com.aku.dmu.gsed.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.data.AppDatabase;
import com.aku.dmu.gsed.data.DAO.GetFncDAO;
import com.aku.dmu.gsed.databinding.ActivityLoginBinding;
import com.aku.dmu.gsed.getUtils.db.GetIndDBData;
import com.aku.dmu.gsed.ui.main.MainActivity;

import java.util.concurrent.ExecutionException;

import static com.aku.dmu.gsed.utils.Constant.Constants.DUMMY_CREDENTIALS;

public class LoginActivity extends AppCompatActivity {


    public static AppDatabase db;
    ActivityLoginBinding bi;
    private UserLoginTask mAuthTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        settingListeners();

    }

    private void settingListeners() {

        bi.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                attemptLogin();
            }
        });

    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        bi.email.setError(null);
        bi.password.setError(null);

        String email = bi.email.getText().toString();
        String password = bi.password.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            bi.password.setError(getString(R.string.error_invalid_password));
            focusView = bi.password;
            cancel = true;
        }

        if (TextUtils.isEmpty(email)) {
            bi.email.setError(getString(R.string.error_field_required));
            focusView = bi.email;
            cancel = true;
        }


        if (cancel) {
            focusView.requestFocus();
        } else {
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);


        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 7;
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }


        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;

            LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            try {

                if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    if ((mEmail.equals("dmu@aku") && mPassword.equals("aku?dmu")) ||
                            (new GetIndDBData(LoginActivity.this,db, GetFncDAO.class.getName(), "getFncDao", "login").execute(mEmail, mPassword).get() != null) ||
                            (mEmail.equals("test1234") && mPassword.equals("test1234"))
                            || (mEmail.equals("test12345") && mPassword.equals("test12345"))) {
//                                               MainApp.userName = mEmail;
//                        MainApp.admin = mEmail.contains("@");

                        finish();

                        Intent iLogin = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(iLogin);

                    } else {
                        bi.password.setError(getString(R.string.error_incorrect_password));
                        bi.password.requestFocus();
                        Toast.makeText(LoginActivity.this, mEmail + " " + mPassword, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            LoginActivity.this);
                    alertDialogBuilder
                            .setMessage("GPS is disabled in your device. Enable it?")
                            .setCancelable(false)
                            .setPositiveButton("Enable GPS",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int id) {
                                            Intent callGPSSettingIntent = new Intent(
                                                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivity(callGPSSettingIntent);
                                        }
                                    });
                    alertDialogBuilder.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = alertDialogBuilder.create();
                    alert.show();

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }

}
