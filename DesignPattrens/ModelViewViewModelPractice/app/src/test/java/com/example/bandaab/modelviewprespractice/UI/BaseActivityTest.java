package com.example.bandaab.modelviewprespractice.UI;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import com.example.bandaab.musicapp.UI.BaseActivity;

/**
 * Created by bandaab on 2/3/18.
 */

public class BaseActivityTest extends ActivityInstrumentationTestCase2<BaseActivity> {

    public BaseActivityTest() {
        super(BaseActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testIsActivity(){
        assertEquals(4, 2 + 2);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
