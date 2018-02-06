package com.mc10.bandaab.mc10codingassignment.Presenter.Login;

import android.os.AsyncTask;

import com.mc10.bandaab.mc10codingassignment.Model.Login;
import com.mc10.bandaab.mc10codingassignment.UI.fragments.Login.ILoginView;
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

public class LoginPresenter implements ILoginPresenter, OnLoginValidationFinishedListener {

    ILoginView mLoginView;
    LoginValidator mLoginValidator;
    String mEmail, Password;
    private String jsonResponse = "";
    private Login loginResponse;
    String LOGIN_URL = "https://qa.mc10cloud.com/api/v1/user/login/email";

    public LoginPresenter(ILoginView loginView){
        mLoginView = loginView;
        mLoginValidator = new LoginValidator();
    }

    @Override
    public void attemptLogin(String email, String password) {
        mLoginValidator.validateLogin(this,email,password);
    }

    @Override
    public void onError() {
        mLoginView.OnLoginFail();
    }

    @Override
    public void onSuccess(String email, String password) {
        FetchLoginData data = new FetchLoginData();
        data.JSON_URL = LOGIN_URL;
        data.EMAIL = email;
        data.PASSWORD = password;
        data.execute();
    }

    protected class FetchLoginData extends AsyncTask<Void, Void, Void> {
        protected String JSON_URL = "";
        protected String EMAIL = "";
        protected String PASSWORD = "";
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
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("email", EMAIL);
                postDataParams.put("password", PASSWORD);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(ApiHelper.getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                jsonResponse = ApiHelper.convertInputStreamToString(inputStream);
                loginResponse = ApiHelper.jsonToResponse(jsonResponse);
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
            if (loginResponse != null) {
                mLoginView.OnLoginSuccess(loginResponse);
            } else {
                mLoginView.OnLoginFail();
            }
        }
    }
}
