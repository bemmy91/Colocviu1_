package ro.pub.cs.systems.eim.testcolocviu01

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstTextView = findViewById<TextView>(R.id.firstTextView)
        val secondTextView = findViewById<TextView>(R.id.secondTextView)
        val counterButton = findViewById<Button>(R.id.counterButton)

        counterButton.setOnClickListener {
            count++
            firstTextView.text = count.toString()
            secondTextView.text = count.toString()
        }
    }
}