package com.example.bandaab.musicapp.Presenter.Search;

/**
 * Created by bandaab on 1/13/18.
 */

public class SearchValidator implements ISearchValidator {
    @Override
    public void validateSearch(final OnSearchFinishedListener listener, final String Text) {
        if(Text.length()>0){
            listener.onSuccess();
        }else{
            listener.onError();
        }
    }
}
