package ru.samsung.itacademy.mdev.twoactivitiesespressotest

import junit.framework.TestCase

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
class SecondActivityTest {


    @Rule
    @JvmField
    var activityRule = ActivityScenarioRule(SecondActivity::class.java)
    val msgBySecondActivity = "Hey"



    @Test
    fun messageIsDisplayed(){
        onView(withId(R.id.editText_second)).check(matches(withText("")))
        onView(withId(R.id.editText_second)).perform(ViewActions.typeText(msgBySecondActivity))
        onView(withId(R.id.editText_second)).check(matches(withText(msgBySecondActivity)))
    }

    @Test
    fun buttonIsClicked(){
        onView(withId(R.id.button_second)).perform(ViewActions.click())
    }

}