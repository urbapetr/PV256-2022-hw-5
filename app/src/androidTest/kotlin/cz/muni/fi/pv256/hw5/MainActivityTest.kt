package cz.muni.fi.pv256.hw5

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun testIncrementCounter() {
        // TODO implement
        val scenario = launchActivity<MainActivity>()
        onView(withId(R.id.increment))
            .perform(click())

    }

    @Test
    fun testDecrementCounter() {
        // TODO implement
    }

    @Test
    fun testCounterPersistance() {
        // TODO implement
    }
}
