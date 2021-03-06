package ru.samsung.itacademy.mdev.twoactivitiesespressotest

import junit.framework.TestCase

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityScenarioRule(MainActivity::class.java)
    val msgByFirstActivity = "Hello"

    @Test
    fun secondActivityIsDisplayed(){
        onView(withId(R.id.button_main)).perform(ViewActions.click())
        onView(withId(R.id.text_message)).check(matches(isDisplayed()))
    }

    @Test
    fun secondActivityTextIsDisplayed(){
        onView(withId(R.id.editText_main)).perform(ViewActions.typeText(msgByFirstActivity))
        onView(withId(R.id.button_main)).perform(ViewActions.click())
        onView(withId(R.id.text_message)).check(matches(withText(msgByFirstActivity)))
    }

    @Test
    fun secondActivityEditTextIsClear(){
        onView(withId(R.id.editText_main)).perform(ViewActions.typeText(msgByFirstActivity))
        onView(withId(R.id.button_main)).perform(ViewActions.click())
        onView(withId(R.id.editText_second)).check(matches(withText("")))
    }


    @Test
    fun launchSecondActivity() {
    }
}