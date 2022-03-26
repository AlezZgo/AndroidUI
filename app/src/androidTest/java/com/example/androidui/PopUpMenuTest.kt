/*
 * *
 *  * Created by Alexander on 3/23/22, 11:17 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 3/23/22, 11:17 PM
 *
 */

package com.example.androidui

import android.support.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PopUpMenuTest {

    @Rule
    var activityActivityTestRule = ActivityTestRule(
        MainActivity::class.java)

    @Test
    fun clickPopUpMenuButton_openMenu() {
        onView(withId(R.id.popup_btn))
            .perform(click())

        onView(withId(R.id.menugroup1))
            .check(matches(isDisplayed()))

    }
}