package cz.muni.fi.pv256.hw5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainActivityViewModel(private val handle: SavedStateHandle) : ViewModel(), Counter {
    companion object {
        private const val KEY_COUNT = "key_count"
    }

    private val _count: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply { value = handle[KEY_COUNT] ?: 0 }
    }

    val data: LiveData<Int>
        get() = _count

    override fun incrementCount() {
        _count.value = _count.value?.inc()
        saveCountState()
    }

    override fun decrementCount() {
        _count.value = _count.value?.dec()
        saveCountState()
    }

    override fun getCount(): Int {
        return _count.value!!
    }

    /**
     * Use this function for saving state
     */
    private fun saveCountState() {
        handle[KEY_COUNT] = _count.value
    }
}
