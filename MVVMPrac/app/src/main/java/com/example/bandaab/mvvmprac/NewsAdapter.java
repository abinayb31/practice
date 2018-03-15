package com.example.bandaab.mvvmprac;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.bandaab.mvvmprac.databinding.ListRowBinding;
import com.example.bandaab.mvvmprac.viewmodel.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bandaab on 2/20/18.
 */

public class NewsAdapter extends ArrayAdapter<NewsModel> {

    private ArrayList<NewsModel> mList;
    private Context mContext;

    public NewsAdapter(@NonNull Context context, ArrayList<NewsModel> list) {
        super(context,R.layout.list_row,list);
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListRowBinding listRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_row, parent,false);
        listRowBinding.setNewslist(mList.get(position));
        return listRowBinding.getRoot();
    }
}
