package com.mc10.bandaab.mc10codingassignment.UI.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mc10.bandaab.mc10codingassignment.Model.Study;
import com.mc10.bandaab.mc10codingassignment.R;
import com.mc10.bandaab.mc10codingassignment.UI.BaseFragment;
import com.mc10.bandaab.mc10codingassignment.Utils.ApiHelper;
import com.mc10.bandaab.mc10codingassignment.Utils.Constants;

import java.util.List;


/**
 * Created by bandaab on 1/16/18.
 */

public class StudiesFragment extends BaseFragment {

    private ListView mListView;
    private List<Study> mResponse;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.studies_fragment, container, false);
        mListView = view.findViewById(R.id.result_list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showList();
    }

    protected void showList() {
        if(getActivity().getIntent().hasExtra(Constants.STUDY_RESULT_RESPONSE)){
            mResponse = getActivity().getIntent().getParcelableArrayListExtra(Constants.STUDY_RESULT_RESPONSE);
            final ListAdapter listAdapter = new ListAdapter(getActivity(),mResponse);
            mListView.setAdapter(listAdapter);
        }
    }

    private class ListAdapter extends ArrayAdapter<Study> {
        List<Study> resultsListItems;
        Context listContext;

        public ListAdapter(@NonNull Context context, List<Study> resultsList) {
            super(context,-1, resultsList);
            resultsListItems = resultsList;
            listContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) listContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.study_item, parent, false);
            TextView displayname= rowView.findViewById(R.id.study_item_display_name);
            TextView date= rowView.findViewById(R.id.study_item_created_date);
            TextView displayTitle= rowView.findViewById(R.id.study_item_title_text);
            displayname.setText(resultsListItems.get(position).getDisplayName());
            date.setText(ApiHelper.CovertDate(resultsListItems.get(position).getCreatedTs()));
            displayTitle.setText(resultsListItems.get(position).getTitle());
            return rowView;
        }
    }
}
