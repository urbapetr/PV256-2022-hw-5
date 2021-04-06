package cz.muni.fi.pv256.hw5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm: MainActivityViewModel by viewModels()

        val counter = findViewById<TextView>(R.id.counter)

        vm.data.observe(
            this,
            {
                counter.text = it.toString()
            }
        )

        val decrementBtn = findViewById<Button>(R.id.decrement)
        decrementBtn.setOnClickListener {
            vm.decrementCount()
        }

        val incrementBtn = findViewById<Button>(R.id.increment)
        incrementBtn.setOnClickListener {
            vm.incrementCount()
        }
    }
}
