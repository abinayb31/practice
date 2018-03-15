package com.example.bandaab.musicapp.UI.activities;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.bandaab.musicapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bandaab on 2/3/18.
 */
public class SearchResultActivityTest {
    @Rule
    public ActivityTestRule<SearchResultActivity> mActivityTestRule = new ActivityTestRule<>(SearchResultActivity.class);
    SearchResultActivity mSearchResultActivity = null;

    @Before
    public void setUp() throws Exception {
        mSearchResultActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view = mSearchResultActivity.findViewById(R.id.search_result_fragment);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mSearchResultActivity = null;
    }

}