package cz.muni.fi.pv256.hw5

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainActivityViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var counter: Counter

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
