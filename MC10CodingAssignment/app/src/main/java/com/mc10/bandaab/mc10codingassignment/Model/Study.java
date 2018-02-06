package com.mc10.bandaab.mc10codingassignment.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by bandaab on 1/16/18.
 */

public class Study implements Parcelable{

    private String accountId;

    private String id;

    private String title;

    private String isArchived;

    private String lifecycleState;

    private String createdTs;

    private String displayName;

    private String[] flags;

    private String[] subjects;

    private String[] deviceConfigs;

    private String[] pipelines;

    private String[] diaries;

    private String[] activities;

    private String[] tags;

    private String[] programs;

    public String[] getTags ()
    {
        return tags;
    }

    public void setTags (String[] tags)
    {
        this.tags = tags;
    }

    public String[] getPrograms ()
    {
        return programs;
    }

    public void setPrograms (String[] programs)
    {
        this.programs = programs;
    }

    public String getAccountId ()
    {
        return accountId;
    }

    public void setAccountId (String accountId)
    {
        this.accountId = accountId;
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

    public String[] getSubjects ()
    {
        return subjects;
    }

    public void setSubjects (String[] subjects)
    {
        this.subjects = subjects;
    }

    public String[] getDeviceConfigs ()
    {
        return deviceConfigs;
    }

    public void setDeviceConfigs (String[] deviceConfigs)
    {
        this.deviceConfigs = deviceConfigs;
    }

    public String getIsArchived ()
    {
        return isArchived;
    }

    public void setIsArchived (String isArchived)
    {
        this.isArchived = isArchived;
    }

    public String getLifecycleState ()
    {
        return lifecycleState;
    }

    public void setLifecycleState (String lifecycleState)
    {
        this.lifecycleState = lifecycleState;
    }

    public String[] getPipelines ()
    {
        return pipelines;
    }

    public void setPipelines (String[] pipelines)
    {
        this.pipelines = pipelines;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String[] getDiaries ()
    {
        return diaries;
    }

    public void setDiaries (String[] diaries)
    {
        this.diaries = diaries;
    }

    public String[] getActivities ()
    {
        return activities;
    }

    public void setActivities (String[] activities)
    {
        this.activities = activities;
    }

    public String getDisplayName ()
    {
        return displayName;
    }

    public void setDisplayName (String displayName)
    {
        this.displayName = displayName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.accountId);
        dest.writeString(this.createdTs);
        dest.writeString(this.displayName);
        dest.writeString(this.id);
        dest.writeString(this.isArchived);
        dest.writeString(this.lifecycleState);
        dest.writeString(this.title);
        dest.writeArray(this.flags);
        dest.writeArray(this.subjects);
        dest.writeArray(this.deviceConfigs);
        dest.writeArray(this.pipelines);
        dest.writeArray(this.diaries);
        dest.writeArray(this.activities);
        dest.writeArray(this.tags);
        dest.writeArray(this.programs);
    }

    protected Study(Parcel in) {
        accountId = in.readString();
        id = in.readString();
        title = in.readString();
        isArchived = in.readString();
        lifecycleState = in.readString();
        createdTs = in.readString();
        displayName = in.readString();
        flags = in.createStringArray();
        subjects = in.createStringArray();
        deviceConfigs = in.createStringArray();
        pipelines = in.createStringArray();
        diaries = in.createStringArray();
        activities = in.createStringArray();
        tags = in.createStringArray();
        programs = in.createStringArray();
    }

    public static final Creator<Study> CREATOR = new Creator<Study>() {
        @Override
        public Study createFromParcel(Parcel in) {
            return new Study(in);
        }

        @Override
        public Study[] newArray(int size) {
            return new Study[size];
        }
    };
}

