package com.example.bandaab.SplitwiseTest.Model.Search;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Response implements Parcelable {

    private Integer resultCount;
    private ArrayList<MusicResponse> results = new ArrayList<MusicResponse>();

    /**
     * @return The resultCount
     */
    public Integer getResultCount() {
        return resultCount;
    }

    /**
     * @param resultCount The resultCount
     */
    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * @return The results
     */
    public List<MusicResponse> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(ArrayList<MusicResponse> results) {
        this.results = results;
    }

    protected Response(Parcel in) {
        if (in.readByte() == 0) {
            resultCount = null;
        } else {
            resultCount = in.readInt();
        }

        if (in.readByte() == 0) {
            results = null;
        } else {
            in.readList(results,null);
        }
    }

    public static final Creator<Response> CREATOR = new Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel in) {
            return new Response(in);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (resultCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(resultCount);
        }
    }
}
