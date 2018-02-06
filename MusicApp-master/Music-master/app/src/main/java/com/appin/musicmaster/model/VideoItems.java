package com.appin.musicmaster.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class VideoItems implements Parcelable {
    List<VideoItem> searchResults;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(searchResults);
    }

    public VideoItems() {
    }

    protected VideoItems(Parcel in) {
        this.searchResults = in.createTypedArrayList(VideoItem.CREATOR);
    }

    public static final Parcelable.Creator<VideoItems> CREATOR = new Parcelable.Creator<VideoItems>() {
        public VideoItems createFromParcel(Parcel source) {
            return new VideoItems(source);
        }

        public VideoItems[] newArray(int size) {
            return new VideoItems[size];
        }
    };
}
