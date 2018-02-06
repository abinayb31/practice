package com.mc10.bandaab.mc10codingassignment.UI.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mc10.bandaab.mc10codingassignment.Model.Login;
import com.mc10.bandaab.mc10codingassignment.Model.Study;
import com.mc10.bandaab.mc10codingassignment.Presenter.Splash.SplashPresenter;
import com.mc10.bandaab.mc10codingassignment.R;
import com.mc10.bandaab.mc10codingassignment.UI.BaseFragment;
import com.mc10.bandaab.mc10codingassignment.UI.activities.LoginActivity;
import com.mc10.bandaab.mc10codingassignment.UI.activities.StudiesActivity;
import com.mc10.bandaab.mc10codingassignment.UI.fragments.SplashView.ISpashView;
import com.mc10.bandaab.mc10codingassignment.Utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bandaab on 1/16/18.
 */

public class SplashScreenFragment extends BaseFragment implements ISpashView {

    private Login mLoginResponse;
    private SplashPresenter mSplashPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash_fragment,container,false);
        mSplashPresenter = new SplashPresenter(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mLoginResponse = (Login) getActivity().getIntent().getSerializableExtra(Constants.LOGIN_RESULT_RESPONSE);
        mSplashPresenter.retrieveStudies(mLoginResponse);
    }

    @Override
    public void onStudiesSuccess(ArrayList<Study> mStudiesResponce) {
        Intent studyIntent = new Intent(getActivity(), StudiesActivity.class);
        studyIntent.putParcelableArrayListExtra(Constants.STUDY_RESULT_RESPONSE,mStudiesResponce);
        startActivity(studyIntent);
    }

    @Override
    public void onStudiesFailed(String errorMessgae) {
        showDialog(errorMessgae);
    }

    @Override
    public void onLogout() {
        Intent logoutIntent = new Intent(getActivity(), LoginActivity.class);
        logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(logoutIntent);
    }

    private void showDialog(String message){
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("Unable to login");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        mSplashPresenter.logout();
                    }
                });
        alertDialog.show();
    }
}
