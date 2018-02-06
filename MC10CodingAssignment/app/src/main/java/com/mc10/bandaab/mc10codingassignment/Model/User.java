package com.mc10.bandaab.mc10codingassignment.Model;

import java.io.Serializable;

/**
 * Created by bandaab on 1/16/18.
 */

public class User implements Serializable
{
    private String isDisabled;

    private String id;

    private String lastName;

    private String legaleseVersionAccepted;

    private String timezone;

    private Accounts[] accounts;

    private String accountId;

    private String createdTs;

    private String email;

    private String locale;

    private String legaleseVersionRequired;

    private String firstName;

    public String getIsDisabled ()
    {
        return isDisabled;
    }

    public void setIsDisabled (String isDisabled)
    {
        this.isDisabled = isDisabled;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public String getLegaleseVersionAccepted ()
    {
        return legaleseVersionAccepted;
    }

    public void setLegaleseVersionAccepted (String legaleseVersionAccepted)
    {
        this.legaleseVersionAccepted = legaleseVersionAccepted;
    }

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public Accounts[] getAccounts ()
    {
        return accounts;
    }

    public void setAccounts (Accounts[] accounts)
    {
        this.accounts = accounts;
    }

    public String getAccountId ()
    {
        return accountId;
    }

    public void setAccountId (String accountId)
    {
        this.accountId = accountId;
    }

    public String getCreatedTs ()
    {
        return createdTs;
    }

    public void setCreatedTs (String createdTs)
    {
        this.createdTs = createdTs;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getLocale ()
    {
        return locale;
    }

    public void setLocale (String locale)
    {
        this.locale = locale;
    }

    public String getLegaleseVersionRequired ()
    {
        return legaleseVersionRequired;
    }

    public void setLegaleseVersionRequired (String legaleseVersionRequired)
    {
        this.legaleseVersionRequired = legaleseVersionRequired;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }
}