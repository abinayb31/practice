package com.example.bandaab.musicapp.UI.fragments.searchResult;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bandaab.musicapp.R;
import com.example.bandaab.musicapp.UI.activities.TestActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

/**
 * Created by bandaab on 2/3/18.
 */
public class SearchResultFragmentTest {
    @Rule
    public ActivityTestRule<TestActivity> mActivityTestRule = new ActivityTestRule<>(TestActivity.class);
    TestActivity mTestActivity = null;

    @Before
    public void setUp() throws Exception {
        mTestActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        RelativeLayout rlContainer =  mTestActivity.findViewById(R.id.test_container);
        assertNotNull(rlContainer);
        SearchResultFragment mSearchResultFragment = new SearchResultFragment();
        mTestActivity.getFragmentManager().beginTransaction().add(rlContainer.getId(), mSearchResultFragment).commitAllowingStateLoss();
        getInstrumentation().waitForIdleSync();
        TextView searchResultTextView = mSearchResultFragment.getView().findViewById(R.id.search_result_textView);
        assertNotNull(searchResultTextView);
        RecyclerView searchRecyclerView = mSearchResultFragment.getView().findViewById(R.id.recycle_view);
        assertNotNull(searchRecyclerView);
    }

    @After
    public void tearDown() throws Exception {
        mTestActivity = null;
    }
}