package com.mc10.bandaab.mc10codingassignment.Model;

import java.io.Serializable;

/**
 * Created by bandaab on 1/16/18.
 */

class Accounts implements Serializable {
    private String isDisabled;

    private String id;

    private String[] flags;

    private String createdTs;

    private String type;

    private String displayName;

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

    public String[] getFlags ()
    {
        return flags;
    }

    public void setFlags (String[] flags)
    {
        this.flags = flags;
    }

    public String getCreatedTs ()
    {
        return createdTs;
    }

    public void setCreatedTs (String createdTs)
    {
        this.createdTs = createdTs;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getDisplayName ()
    {
        return displayName;
    }

    public void setDisplayName (String displayName)
    {
        this.displayName = displayName;
    }
}
