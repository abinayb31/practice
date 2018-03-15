package com.example.bandaab.mvvmmusicapp.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bandaab.mvvmmusicapp.R;

/**
 * Created by bandaab on 3/4/18.
 */

public class SearchFragment extends Fragment {

    TextView mSearchText;
    Button mSearchButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment,container,false);
        mSearchText = view.findViewById(R.id.searchText);
        mSearchButton = view.findViewById(R.id.searchButton);
        return view;
    }
}
