package com.example.bandaab.musicapp.Presenter.Search;

import android.os.AsyncTask;

import com.example.bandaab.musicapp.Model.Search.Response;
import com.example.bandaab.musicapp.UI.fragments.Search.ISearchView;
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


/**
 * Created by bandaab on 1/13/18.
 */

public class SearchPresenter implements ISearchPresenter, OnSearchFinishedListener {

    private SearchValidator mSearchValidator;
    ISearchView mSearchView;
    private String jsonResponse = "";
    private Response response;
    private String SEARCH_URL = "https://itunes.apple.com/search?term=";
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
//        mSearchView.OnSearchSuccess();
        FetchData data = new FetchData();
        String searchKeyword = mSearchText.replaceAll("\\s", "");
        // concatenate user input to the url
        data.JSON_URL = SEARCH_URL + searchKeyword;
        data.execute();
    }

    protected String convertInputStreamToString(InputStream inputstream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream), 1024);
        try {
            return readLines(reader);
        } finally {
            reader.close();
        }
    }

    protected String readLines(BufferedReader reader) throws IOException {
        //Read response line by line
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line + '\n');
        }
        return builder.toString();
    }

    protected Response jsonToResponse(String jsonResponse) {
        // convert Json object to java object
        Gson gson = new GsonBuilder().create();
        Type type = new TypeToken<Response>() {}.getType();
        return gson.fromJson(jsonResponse, type);
    }

    protected class FetchData extends AsyncTask<Void, Void, Void> {
        protected String JSON_URL = "";
        private InputStream inputStream;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL url = new URL(JSON_URL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                jsonResponse = convertInputStreamToString(inputStream);
                response = jsonToResponse(jsonResponse);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (response != null) {
                mSearchView.OnSearchSuccess(response);
            } else {
                mSearchView.OnSearchFail("Search failed please try again");
            }

        }
    }
}
