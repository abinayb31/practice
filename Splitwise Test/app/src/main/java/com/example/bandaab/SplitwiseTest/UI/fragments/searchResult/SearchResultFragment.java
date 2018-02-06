package com.example.bandaab.SplitwiseTest.UI.fragments.searchResult;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bandaab.SplitwiseTest.Model.Search.MusicResponse;
import com.example.bandaab.SplitwiseTest.Model.Search.Response;
import com.example.bandaab.SplitwiseTest.UI.BaseFragment;
import com.example.bandaab.SplitwiseTest.UI.adapters.SearchResultAdapter;
import com.example.bandaab.modelviewprespractice.R;
import com.example.bandaab.SplitwiseTest.util.Constants;
import com.example.bandaab.SplitwiseTest.util.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bandaab on 1/14/18.
 */

public class SearchResultFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private Response mResponse;
    private List<MusicResponse> mMusicResponseList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_result_fragment,container,false);
        mRecyclerView = view.findViewById(R.id.recycle_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showSearchResults();
    }

    protected void showSearchResults() {
        if(getActivity().getIntent().hasExtra(Constants.SEARCH_RESULT_RESPONSE)){
            mMusicResponseList = getActivity().getIntent().getParcelableArrayListExtra(Constants.SEARCH_RESULT_RESPONSE);
            if(!mMusicResponseList.isEmpty() && mRecyclerView != null){
                final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
                gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(6));
                mRecyclerView.setAdapter(new SearchResultAdapter(getActivity(),mMusicResponseList));
            }
        }
    }

}
