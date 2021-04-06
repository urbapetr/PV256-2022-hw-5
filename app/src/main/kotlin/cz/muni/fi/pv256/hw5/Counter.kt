package cz.muni.fi.pv256.hw5

interface Counter {
    fun incrementCount()
    fun decrementCount()
    fun getCount(): Int
}
