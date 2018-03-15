package com.example.bandaab.musicapp.UI.fragments.Search;

import com.example.bandaab.musicapp.Model.Search.Response;

/**
 * Created by bandaab on 1/13/18.
 */

public interface ISearchView {
    void OnSearchSuccess(Response responce);
    void OnSearchFail(String message);
}
