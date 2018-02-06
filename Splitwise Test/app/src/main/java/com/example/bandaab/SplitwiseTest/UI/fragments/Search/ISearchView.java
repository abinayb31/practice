package com.example.bandaab.SplitwiseTest.UI.fragments.Search;

import com.example.bandaab.SplitwiseTest.Model.Search.Response;

/**
 * Created by bandaab on 1/13/18.
 */

public interface ISearchView {
    void OnSearchSuccess(Response responce);
    void OnSearchFail(String message);
}
