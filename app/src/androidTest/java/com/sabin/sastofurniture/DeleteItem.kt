package com.sabin.sastofurniture

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test


class  DeleteItem {

    @get:Rule
    val testRule = ActivityScenarioRule(LoginActivity::class.java)
    val dash = ActivityScenarioRule(DashboardActivity::class.java)


    @Test
    fun DeleteItem() {

        Espresso.onView(ViewMatchers.withId(R.id.email))
            .perform(ViewActions.typeText("sabin123@gmail.com"))
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.typeText("sabin123"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.login)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.layout.activity_show__product)).perform(ViewActions.click())
//        Espresso.onView(ViewMatchers.withId(R.id.)).perform(ViewActions.click())



//        Espresso.onView(ViewMatchers.withId(R.id.removefromcart)).perform(ViewActions.click())
        Thread.sleep(3000)
//        Espresso.onView(ViewMatchers.withId(R.id.navigation_cart)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}



