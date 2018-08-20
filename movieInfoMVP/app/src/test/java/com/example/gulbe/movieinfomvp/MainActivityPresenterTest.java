package com.example.gulbe.movieinfomvp;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowApplication;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by gulbe on 16.08.2018.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityPresenterTest {

    private EditText searchBar;
    private Button searchButton;


    @Before
    public void setUp() throws Exception {

        Activity activity = Robolectric.setupActivity(MainActivity.class);
        searchButton = (Button) activity.findViewById(R.id.searchBtn);
        searchBar = (EditText) activity.findViewById(R.id.searchBar);

    }

    @Test
    public void showErrorWhenSearchBarIsEmpty() throws Exception {
        searchButton.performClick();

        ShadowApplication application = shadowOf(RuntimeEnvironment.application);
        assertThat("Show error for search field ", searchBar.getError(), is(CoreMatchers.notNullValue()));

    }
}