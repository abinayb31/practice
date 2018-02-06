package com.example.bandaab.SplitwiseTest.UI.fragments.Search;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bandaab.SplitwiseTest.Model.Search.Response;
import com.example.bandaab.SplitwiseTest.Presenter.Search.SearchPresenter;
import com.example.bandaab.modelviewprespractice.R;
import com.example.bandaab.SplitwiseTest.UI.BaseFragment;
import com.example.bandaab.SplitwiseTest.UI.activities.SearchResultActivity;
import com.example.bandaab.SplitwiseTest.util.Constants;

import java.util.ArrayList;

/**
 * Created by bandaab on 1/13/18.
 */

public class Searchfragment extends BaseFragment implements ISearchView {
    TextView mSearchText;
    Button mSearchButton;

    ProgressDialog progressDialog;
    SearchPresenter searchPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment,container,false);
        searchPresenter = new SearchPresenter(this);
        mSearchText = view.findViewById(R.id.searchText);
        mSearchButton = view.findViewById(R.id.searchButton);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = ProgressDialog.show(getActivity(), "Searching...", null);
                String searchText = mSearchText.getText().toString();
                searchPresenter.attemptSearch(searchText);
            }
        });
    }

    @Override
    public void OnSearchSuccess(Response response) {
        progressDialog.dismiss();
        Intent searchResultIntent = new Intent(getActivity(), SearchResultActivity.class);
        searchResultIntent.putParcelableArrayListExtra(Constants.SEARCH_RESULT_RESPONSE, (ArrayList<? extends Parcelable>) response.getResults());
        startActivity(searchResultIntent);
    }

    @Override
    public void OnSearchFail(String message) {
        progressDialog.dismiss();
        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }
}
