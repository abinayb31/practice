package com.appin.musicmaster.model;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoItem implements Parcelable {
    private String title;
    private String description;
    private String thumbnailURL;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnail) {
        this.thumbnailURL = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.thumbnailURL);
        dest.writeString(this.id);
    }

    public VideoItem() {
    }

    protected VideoItem(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.thumbnailURL = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<VideoItem> CREATOR = new Parcelable.Creator<VideoItem>() {
        public VideoItem createFromParcel(Parcel source) {
            return new VideoItem(source);
        }

        public VideoItem[] newArray(int size) {
            return new VideoItem[size];
        }
    };
}
