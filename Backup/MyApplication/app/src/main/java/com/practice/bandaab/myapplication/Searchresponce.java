package com.practice.bandaab.myapplication;

import java.io.Serializable;

/**
 * Created by bandaab on 2/6/18.
 */

public class Searchresponce implements Serializable
{
    private Photos photos;

    private String stat;

    public Photos getPhotos ()
    {
        return photos;
    }

    public void setPhotos (Photos photos)
    {
        this.photos = photos;
    }

    public String getStat ()
    {
        return stat;
    }

    public void setStat (String stat)
    {
        this.stat = stat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [photos = "+photos+", stat = "+stat+"]";
    }
}
