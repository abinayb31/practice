package com.mc10.bandaab.mc10codingassignment.Presenter.Login;

/**
 * Created by bandaab on 1/13/18.
 */

public interface ILoginValidator {
    void validateLogin(OnLoginValidationFinishedListener listener, String email, String Password);
}
