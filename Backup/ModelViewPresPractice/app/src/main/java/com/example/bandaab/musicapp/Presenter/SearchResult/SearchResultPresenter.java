package com.example.bandaab.musicapp.Presenter.SearchResult;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.bandaab.musicapp.UI.fragments.searchResult.ISearchResultView;

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
    public void onImageDownload(ImageView imageView, String url) {
        new DownloadImageTask(imageView).execute(url);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView trackImage;

        public DownloadImageTask(ImageView image) {
            this.trackImage = image;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap icon = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                icon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return icon;
        }

        protected void onPostExecute(Bitmap result) {
            if(result != null){
                mSearchResultView.OnImageDownloadedSucess(trackImage, result);
            } else{
                mSearchResultView.OnImageDownloadedFail();
            }
        }
    }
}
