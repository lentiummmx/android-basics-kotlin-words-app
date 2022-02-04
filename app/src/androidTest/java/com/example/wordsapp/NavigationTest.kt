package com.example.wordsapp

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    lateinit var navController: TestNavHostController
    lateinit var letterListScenario: FragmentScenario<LetterListFragment>

        @Before
    fun setup() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        letterListScenario = launchFragmentInContainer<LetterListFragment>(themeResId = R.style.Theme_Words)

        letterListScenario.onFragment { itFragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(itFragment.requireView(), navController)
        }
    }

    @Test
    fun navigate_to_words_nav_component() {

        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))

        assertEquals(navController.currentDestination?.id, R.id.wordListFragment)
    }

}