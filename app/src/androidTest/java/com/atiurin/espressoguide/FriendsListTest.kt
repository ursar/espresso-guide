package com.atiurin.espressoguide

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.atiurin.espressoguide.activity.MainActivity
import com.atiurin.espressoguide.idlingresources.SingletonIdlingResource
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FriendsListTest{
    val idlingRes = SingletonIdlingResource

    @Rule @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun registerResource(){
        IdlingRegistry.getInstance().register(idlingRes)
    }

    @Test
    fun testIdlingResource(){
        onView(withText("Chandler Bing")).check(matches(isDisplayed()))
    }
}