package com.sabin.sastofurniture

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SignUpTest {

    @get:Rule
    val testRule = ActivityScenarioRule(SignupActivity::class.java)

    @Test
    fun signUpCustomer() {
        Espresso.onView(ViewMatchers.withId(R.id.fullname))
                .perform(ViewActions.typeText("Kiran Rana"))
        Espresso.onView(ViewMatchers.withId(R.id.email))
                .perform(ViewActions.typeText("kiran12345@gmail.com"))
        Espresso.onView(ViewMatchers.withId(R.id.etpassword))
                .perform(ViewActions.typeText("kiran123"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.cPassword))
                .perform(ViewActions.typeText("kiran123"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.mobileno))
                .perform(ViewActions.typeText("9811328418"))
        Thread.sleep(200)
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.signup))
                .perform(ViewActions.click())
        Thread.sleep(2000)



    }
}