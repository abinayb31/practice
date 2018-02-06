package com.example.bandaab.musicapp.UI.fragments.Search;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.bandaab.musicapp.R;
import com.example.bandaab.musicapp.UI.activities.SearchResultActivity;
import com.example.bandaab.musicapp.UI.activities.TestActivity;
import com.example.bandaab.musicapp.UI.fragments.searchResult.SearchResultFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by bandaab on 2/3/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchfragmentTest {
    @Rule
    public ActivityTestRule<TestActivity> mActivityTestRule = new ActivityTestRule<>(TestActivity.class);
    TestActivity mTestActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SearchResultActivity.class.getName(), null,false);

    @Before
    public void setUp() throws Exception {
        mTestActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        RelativeLayout rlContainer =  mTestActivity.findViewById(R.id.test_container);
        assertNotNull(rlContainer);
        Searchfragment mSearchFragment = new Searchfragment();
        mTestActivity.getFragmentManager().beginTransaction().add(rlContainer.getId(), mSearchFragment).commitAllowingStateLoss();
        getInstrumentation().waitForIdleSync();
        EditText searchEditTextView = mSearchFragment.getView().findViewById(R.id.searchText);
        assertNotNull(searchEditTextView);
        Button searchButton = mSearchFragment.getView().findViewById(R.id.searchButton);
        assertNotNull(searchButton);
        onView(withId(R.id.searchText)).perform(typeText("sugar"), closeSoftKeyboard());;
        onView(withId(R.id.searchButton)).perform(click());
        Activity searchResultActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(searchResultActivity);
    }

    @After
    public void tearDown() throws Exception {
        mTestActivity = null;
    }

}