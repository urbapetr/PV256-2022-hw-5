package cz.muni.fi.pv256.hw5

import android.widget.Button
import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.launchActivity
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import java.lang.Integer.parseInt

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun testIncrementCounter() {
        val scenario = launchActivity<MainActivity>()
        scenario.onActivity { activity ->
            val counter = activity.findViewById<TextView>(R.id.counter)
            val result = Integer.parseInt(counter.text.toString())
            val incrementBtn = activity.findViewById<Button>(R.id.increment)
            incrementBtn.performClick()
            assert(Integer.parseInt(counter.text.toString()) == result + 1)
        }
    }

    @Test
    fun testDecrementCounter() {
        val scenario = launchActivity<MainActivity>()
        scenario.onActivity { activity ->
            val counter = activity.findViewById<TextView>(R.id.counter)
            val result = parseInt(counter.text.toString())
            val decrementBtn = activity.findViewById<Button>(R.id.decrement)
            decrementBtn.performClick()
            assert(parseInt(counter.text.toString()) == result - 1)
        }
    }

    @Test
    fun testCounterPersistance() {
        // TODO implement
    }
}
