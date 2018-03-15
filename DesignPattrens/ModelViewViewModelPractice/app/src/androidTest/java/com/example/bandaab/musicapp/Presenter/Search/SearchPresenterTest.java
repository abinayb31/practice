package com.example.bandaab.musicapp.Presenter.Search;

import com.example.bandaab.musicapp.Model.Search.Response;
import com.example.bandaab.musicapp.UI.fragments.Search.ISearchView;
import com.example.bandaab.musicapp.UI.fragments.Search.Searchfragment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bandaab on 2/4/18.
 */
public class SearchPresenterTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldPass(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void shouldPassData(){
        //given
        MockView view = new MockView();
        MockSearchTextValidator mockSearchTextValidator = new MockSearchTextValidator();

        //when
        SearchPresenter presenter = new SearchPresenter(view, new SearchValidator());
        presenter.attemptSearch("sugar");
        //then
        Assert.assertEquals(true, view.passed);

    }

    @After
    public void tearDown() throws Exception {
    }

    private class MockView implements ISearchView {
        boolean passed = true;
        @Override
        public void OnSearchSuccess(Response responce) {
            passed = true;
        }

        @Override
        public void OnSearchFail(String message) {
            passed = false;
        }
    }

    private class MockSearchTextValidator implements OnSearchFinishedListener {
        boolean passed;
        @Override
        public void onError() {
            passed = false;
        }

        @Override
        public void onSuccess() {
            passed = true;
        }
    }
}