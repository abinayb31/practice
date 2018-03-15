package com.example.bandaab.musicapp.util;

import com.example.bandaab.musicapp.Model.Search.Response;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by bandaab on 2/19/18.
 */

public interface ApiInterface {

//    @GET("search?")
//    Call<Response> getAlbums(@Query("term") String songName);

    @GET("search?")
    Observable<Response> getAlbums(@Query("term") String songName);
}
