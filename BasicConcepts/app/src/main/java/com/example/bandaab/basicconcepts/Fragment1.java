package com.example.bandaab.basicconcepts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bandaab on 1/15/18.
 */

public class Fragment1 extends Fragment{

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,container,false);
        textView = view.findViewById(R.id.fragmentText1);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getArguments() != null && getArguments().getString("fragment1")!= null){
            String strtext = getArguments().getString("fragment1");
            textView.setText(strtext);
        }
    }
}
