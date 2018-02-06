package com.mc10.bandaab.mc10codingassignment.Presenter.Splash;

import com.mc10.bandaab.mc10codingassignment.Model.Login;

/**
 * Created by bandaab on 1/16/18.
 */

public interface ISplashPresenter {
    void retrieveStudies(Login loginResponse);
    void logout();
}
