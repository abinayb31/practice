package com.mc10.bandaab.mc10codingassignment.Presenter.Splash;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import com.mc10.bandaab.mc10codingassignment.Model.Login;
import com.mc10.bandaab.mc10codingassignment.Model.Studies;
import com.mc10.bandaab.mc10codingassignment.Model.Study;
import com.mc10.bandaab.mc10codingassignment.UI.fragments.SplashView.ISpashView;
import com.mc10.bandaab.mc10codingassignment.Utils.ApiHelper;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bandaab on 1/16/18.
 */

public class SplashPresenter implements ISplashPresenter, ICheckBluetoothConnectionListener {

    private ISpashView mSplashView;
    private CheckBluetoothConnection mCheckBluetoothConnection;
    private Login mLoginResponse;
    private Study[] mStudiesResponce;
    private String jsonResponse = "";
    public SplashPresenter(ISpashView splashView){
        mSplashView =splashView;
        mCheckBluetoothConnection = new CheckBluetoothConnection();
    }

    @Override
    public void retrieveStudies(Login loginResponse) {
        mLoginResponse = loginResponse;
        mCheckBluetoothConnection.checkBluetooth(this);
    }

    @Override
    public void logout() {
        LogoutRest logoutRestData = new LogoutRest();
        logoutRestData.JSON_URL = String.valueOf("https://qa.mc10cloud.com/api/v1/users/logout");
        logoutRestData.execute();
    }

    @Override
    public void OnBluetoothConnected() {
        FetchStudiesData data = new FetchStudiesData();
        StringBuilder url  = new StringBuilder();
        url.append("https://qa.mc10cloud.com/api/v1/accounts/");
        url.append(mLoginResponse.getUser().getAccountId());
        url.append("/studies");
        data.JSON_URL = String.valueOf(url);
        data.execute();
    }

    @Override
    public void OnBluetoothNotConnected() {
        mSplashView.onStudiesFailed("Your bluetooth is not enabled please enable and try to login again");
    }

    @Override
    public void OnNOBluetooth() {
        mSplashView.onStudiesFailed("No Bluetooth available for this mobile device");
    }

    protected class FetchStudiesData extends AsyncTask<Void, Void, Void> {
        protected String JSON_URL = "";
        private InputStream inputStream;
        HttpURLConnection urlConnection = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL url = new URL(JSON_URL);
                urlConnection = (HttpURLConnection) url.openConnection();
                String user = mLoginResponse.getUser().getId();
                String token = mLoginResponse.getAccessToken();
                urlConnection.setRequestProperty("Authorization", "Basic " + Base64.encodeToString((user + ":" + token).getBytes(), Base64.NO_WRAP));
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                jsonResponse = ApiHelper.convertInputStreamToString(inputStream);
                mStudiesResponce = ApiHelper.studiesJsonToResponse(jsonResponse);

            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                if(urlConnection != null ){
                    urlConnection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (mStudiesResponce != null) {
                mSplashView.onStudiesSuccess(mStudiesResponce);
            } else {
                mSplashView.onStudiesFailed("Some thing went wrong please try  to login again");
            }

        }
    }

    protected class LogoutRest extends AsyncTask<Void, Void, Void> {
        protected String JSON_URL = "";
        private InputStream inputStream;
        private HttpURLConnection urlConnection = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL url = new URL(JSON_URL);
                urlConnection = (HttpURLConnection) url.openConnection();
                String user = mLoginResponse.getUser().getId();
                String token = mLoginResponse.getAccessToken();
                urlConnection.setRequestProperty("Authorization", "Basic " + Base64.encodeToString((user + ":" + token).getBytes(), Base64.NO_WRAP));
                urlConnection.setRequestMethod("POST");;
                int logoutResponseCode = urlConnection.getResponseCode();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                if(urlConnection != null ){
                    urlConnection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            mSplashView.onLogout();
        }
    }


}
