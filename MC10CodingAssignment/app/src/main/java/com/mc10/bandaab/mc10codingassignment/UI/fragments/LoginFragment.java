package com.mc10.bandaab.mc10codingassignment.UI.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mc10.bandaab.mc10codingassignment.Model.Login;
import com.mc10.bandaab.mc10codingassignment.Presenter.Login.LoginPresenter;
import com.mc10.bandaab.mc10codingassignment.R;
import com.mc10.bandaab.mc10codingassignment.UI.BaseFragment;
import com.mc10.bandaab.mc10codingassignment.UI.activities.SplashScreenActivity;
import com.mc10.bandaab.mc10codingassignment.UI.fragments.Login.ILoginView;
import com.mc10.bandaab.mc10codingassignment.Utils.Constants;

/**
 * Created by bandaab on 1/16/18.
 */

public class LoginFragment extends BaseFragment implements ILoginView {

    private EditText mEmailText;
    private EditText mPasswordText;
    private Button mLoginButton;
    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        mEmailText = view.findViewById(R.id.login_email);
        mPasswordText = view.findViewById(R.id.login_password);
        mLoginButton = view.findViewById(R.id.login_button);
        loginPresenter = new LoginPresenter(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = ProgressDialog.show(getActivity(), "Authenticating...", null);
                String email = String.valueOf(mEmailText.getText());
                String password = String.valueOf(mPasswordText.getText());
                loginPresenter.attemptLogin("amartin+mobiletest@mc10inc.com", "yf9C79%AY9");
            }
        });
    }

    @Override
    public void OnLoginSuccess(Login loginResponse) {
        progressDialog.dismiss();
        Intent splashIntent = new Intent(getActivity(), SplashScreenActivity.class);
        splashIntent.putExtra(Constants.LOGIN_RESULT_RESPONSE, loginResponse);
        startActivity(splashIntent);
    }

    @Override
    public void OnLoginFail() {
        progressDialog.dismiss();
        showDialog();
    }

    private void showDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("Unable to login");
        alertDialog.setMessage("Please enter valid email and password");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
