package com.example.bandaab.musicapp.Presenter.Search;

import android.os.AsyncTask;

import com.example.bandaab.musicapp.Model.Search.Response;
import com.example.bandaab.musicapp.UI.fragments.Search.ISearchView;
import com.example.bandaab.musicapp.util.ApiClient;
import com.example.bandaab.musicapp.util.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by bandaab on 1/13/18.
 */

public class SearchPresenter implements ISearchPresenter, OnSearchFinishedListener {

    private SearchValidator mSearchValidator;
    ISearchView mSearchView;
    private String mSearchText;

    public SearchPresenter(ISearchView searchView, SearchValidator searchValidator){
        mSearchValidator = searchValidator;
        mSearchView = searchView;
    }

    @Override
    public void attemptSearch(String searchText) {
        this.mSearchText = searchText;
        mSearchValidator.validateSearch(this, searchText);
    }

    @Override
    public void onError() {
        mSearchView.OnSearchFail("Please enter a valid artist/song name");
    }

    @Override
    public void onSuccess() {
        String searchKeyword = mSearchText.replaceAll("\\s", "");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Response> call = apiService.getAlbums(searchKeyword);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    mSearchView.OnSearchSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                mSearchView.OnSearchFail("Search failed please try again");
            }
        });
    }
}
