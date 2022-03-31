package com.example.tacom

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain


class UsersActivityTest {


    private var mainScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    private var usersScenarioRule: ActivityScenarioRule<UsersActivity> =
        ActivityScenarioRule(UsersActivity::class.java)

    @Rule
    val chain: RuleChain = RuleChain
        .outerRule(mainScenarioRule)
        .around(usersScenarioRule)



    @Test
    fun writeNameAndPerformerAction(){
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName))
            .perform(ViewActions.typeText(NAME))
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName2))
            .perform(ViewActions.typeText(LAST_NAME))
        Espresso.onView(ViewMatchers.withId(R.id.buttonAdd))
            .perform(ViewActions.click())
    }

    companion object {
        const val NAME = "Guilherme"
        const val LAST_NAME = "Machado"

    }

}