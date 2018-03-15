package com.example.bandaab.musicapp.UI.fragments.searchResult;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by bandaab on 1/14/18.
 */

public interface ISearchResultView {
    void OnImageDownloadedSucess(ImageView imageView, Bitmap bitMapImage);
    void OnImageDownloadedFail();
}
