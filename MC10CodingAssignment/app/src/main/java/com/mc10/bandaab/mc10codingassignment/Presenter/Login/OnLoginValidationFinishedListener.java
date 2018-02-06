package com.mc10.bandaab.mc10codingassignment.Presenter.Login;

/**
 * Created by jpotts18 on 5/11/15.
 */
public interface OnLoginValidationFinishedListener {
    void onError();
    void onSuccess(String email, String password);
}
