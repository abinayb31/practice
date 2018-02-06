package com.mc10.bandaab.mc10codingassignment.UI.fragments.Login;

import com.mc10.bandaab.mc10codingassignment.Model.Login;

/**
 * Created by bandaab on 1/16/18.
 */

public interface ILoginView {
    void OnLoginSuccess(Login loginResponse);
    void OnLoginFail();
}
