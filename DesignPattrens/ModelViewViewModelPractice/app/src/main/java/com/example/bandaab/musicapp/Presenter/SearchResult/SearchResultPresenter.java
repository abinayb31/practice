package com.example.bandaab.musicapp.Presenter.SearchResult;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.bandaab.musicapp.R;
import com.example.bandaab.musicapp.UI.fragments.searchResult.ISearchResultView;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

/**
 * Created by bandaab on 1/14/18.
 */

public class SearchResultPresenter implements ISearchResultPresenter{

    ISearchResultView mSearchResultView;

    public SearchResultPresenter(ISearchResultView searchResultView) {
        mSearchResultView = searchResultView;
    }

    @Override
    public void onImageDownload(ImageView imageView, String url, Context context) {
        Picasso.with(context).load(url).placeholder(R.mipmap.ic_launcher).into(imageView);
    }
}
