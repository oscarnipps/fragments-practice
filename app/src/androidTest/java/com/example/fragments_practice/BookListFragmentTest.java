package com.example.fragments_practice;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class BookListFragmentTest {



    @Test
    public void fragment_is_displayed_with_passed_args() {

        FragmentScenario<BookListFragment> scenario = FragmentScenario.launchInContainer(
                BookListFragment.class,
                null,
                R.style.Theme_MaterialComponents_Light_NoActionBar
        );

        onView(withId(R.id.book_list_toolbar)).check(matches(isDisplayed()));
    }


    @Test
    public void bundle_result_is_received() {
        Context context = ApplicationProvider.getApplicationContext();

        boolean expectedResult = context.getResources().getBoolean(R.bool.non_premium_user);

        Bundle args = new Bundle();
        args.putBoolean(Constants.ARG_PREMIUM_USER_KEY, expectedResult);

        FragmentScenario<BookListFragment> scenario = FragmentScenario.launchInContainer(
                BookListFragment.class,
                args,
                R.style.Theme_MaterialComponents_Light_NoActionBar
        );

        scenario.onFragment(bookListFragment -> {

            bookListFragment.getParentFragmentManager().setFragmentResult(Constants.BOOK_LIST_RESULT_KEY,args);

            boolean actualResult = bookListFragment.mIsPremiumUser;

            assertFalse(actualResult);

        });

       onView(withId(R.id.recyclerview)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));

    }

    @Test
    public void dialog_is_shown_when_menu_item_is_clicked_and_dismissed_when_ok_is_clicked() {
        FragmentScenario<BookListFragment> scenario = FragmentScenario.launchInContainer(
                BookListFragment.class,
                null,
                R.style.Theme_MaterialComponents_Light_NoActionBar);

           try {
                //click on the menu item
                onView(withId(R.id.delete)).perform(click());
            } catch (NoMatchingViewException e) {
                openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());
                onView(withText(R.string.delete_all)).perform(click());
            }

        onView(withText(R.string.premium_request_dialog_title)).check(matches(isDisplayed()));
    }
}