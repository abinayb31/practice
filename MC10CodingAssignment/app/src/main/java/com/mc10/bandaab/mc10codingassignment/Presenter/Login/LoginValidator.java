package com.mc10.bandaab.mc10codingassignment.Presenter.Login;

/**
 * Created by bandaab on 1/13/18.
 */

public class LoginValidator implements ILoginValidator {

    @Override
    public void validateLogin(OnLoginValidationFinishedListener listener, String Email, String Password) {
        if(Email.length()>0 && Password.length()>0){
            listener.onSuccess(Email, Password);
        }else{
            listener.onError();
        }
    }
}
