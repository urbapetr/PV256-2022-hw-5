package cz.muni.fi.pv256.hw5

import android.view.View
import android.widget.TextView
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matcher
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun testIncrementCounter() {
        launchActivity<MainActivity>()
        val result = getText(withId(R.id.counter))?.toInt()
        onView(withId(R.id.increment)).perform(click())
        if (result != null) {
            onView(withId(R.id.counter)).check(matches(withText((result + 1).toString())))
        }
    }

    @Test
    fun testDecrementCounter() {
        launchActivity<MainActivity>()
        val result = getText(withId(R.id.counter))?.toInt()
        onView(withId(R.id.decrement)).perform(click())
        if (result != null) {
            onView(withId(R.id.counter)).check(matches(withText((result - 1).toString())))
        }
    }

    @Test
    fun testCounterPersistance() {
        val scenario = launchActivity<MainActivity>()
        val result = getText(withId(R.id.counter))?.toInt()
        onView(withId(R.id.decrement)).perform(click())
        scenario.recreate()
        if (result != null) {
            onView(withId(R.id.counter)).check(matches(withText((result - 1).toString())))
        }
    }

    private fun getText(matcher: Matcher<View?>?): String? {
        val stringHolder = arrayOf<String?>(null)
        onView(matcher).perform(
            object : ViewAction {
                override fun getConstraints(): Matcher<View> {
                    return isAssignableFrom(TextView::class.java)
                }
                override fun getDescription(): String {
                    return "getting text from a TextView"
                }

                override fun perform(uiController: UiController?, view: View) {
                    val tv = view as TextView // Save, because of check in getConstraints()
                    stringHolder[0] = tv.text.toString()
                }
            }
        )
        return stringHolder[0]
    }
}
