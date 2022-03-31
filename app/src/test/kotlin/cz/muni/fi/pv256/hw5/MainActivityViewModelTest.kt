package cz.muni.fi.pv256.hw5

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito

class MainActivityViewModelTest {

    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var counter: Counter

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        savedStateHandle = Mockito.mock(SavedStateHandle::class.java)
        counter = MainActivityViewModel(savedStateHandle)
    }

    @Test
    fun incrementCount() {
        val expectResult: Int = counter.getCount() + 1
        counter.incrementCount()
        assert(expectResult == counter.getCount())
    }

    @Test
    fun decrementCount() {
        val expectResult: Int = counter.getCount() - 1
        counter.decrementCount()
        assert(expectResult == counter.getCount())
    }
}
