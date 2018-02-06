package com.mc10.bandaab.mc10codingassignment.Model;

import java.io.Serializable;

/**
 * Created by bandaab on 1/16/18.
 */

public class Login implements Serializable {
    private String accessToken;

    private String expiration;

    private User user;

    public String getAccessToken ()
    {
        return accessToken;
    }

    public void setAccessToken (String accessToken)
    {
        this.accessToken = accessToken;
    }

    public String getExpiration ()
    {
        return expiration;
    }

    public void setExpiration (String expiration)
    {
        this.expiration = expiration;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }
}

