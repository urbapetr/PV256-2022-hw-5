package cz.muni.fi.pv256.hw5

import androidx.lifecycle.SavedStateHandle
import org.junit.Before
import org.junit.Test

class MainActivityViewModelTest {

    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var counter: Counter

    @Before
    fun setUp() {
        counter = MainActivityViewModel(savedStateHandle)
    }

    @Test
    fun incrementCount() {
        // TODO implement
        val expectResult: Int = counter.getCount() + 1
        counter.incrementCount()
        assert(expectResult == counter.getCount())
    }

    @Test
    fun decrementCount() {
        // TODO implement
        val expectResult: Int = counter.getCount() - 1
        counter.incrementCount()
        assert(expectResult == counter.getCount())
    }
}
