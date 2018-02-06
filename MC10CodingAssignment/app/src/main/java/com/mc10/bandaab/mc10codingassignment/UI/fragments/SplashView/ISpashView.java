package com.mc10.bandaab.mc10codingassignment.UI.fragments.SplashView;

import com.mc10.bandaab.mc10codingassignment.Model.Study;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bandaab on 1/16/18.
 */

public interface ISpashView {
    void onStudiesSuccess(ArrayList<Study> mStudiesResponce);
    void onStudiesFailed(String errorMessage);
    void onLogout();
}
