package com.example.bandaab.musicapp.Presenter.SearchResult;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by bandaab on 1/14/18.
 */

public interface ISearchResultPresenter {
    void onImageDownload(ImageView imageView, String url, Context context);
}
