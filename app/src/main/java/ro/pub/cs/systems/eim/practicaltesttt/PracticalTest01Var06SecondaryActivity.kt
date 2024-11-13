package ro.pub.cs.systems.eim.practicaltesttt

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var06SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var06_secondary)

        // Retrieve data from intent
        val number1 = intent.getStringExtra("number1") ?: "*"
        val number2 = intent.getStringExtra("number2") ?: "*"
        val number3 = intent.getStringExtra("number3") ?: "*"
        val checkedCount = intent.getIntExtra("checkedCount", 0)

        // Get references to the TextViews
        val resultText = findViewById<TextView>(R.id.resultText)
        val gainText = findViewById<TextView>(R.id.gainText)

        // Determine if "Gained"
        val isGained = (number1 == number2 && number2 == number3) ||
                (number1 == "*" && number2 == number3) ||
                (number2 == "*" && number1 == number3) ||
                (number3 == "*" && number1 == number2)

        if (isGained) {
            resultText.text = "Gained"
        } else {
            resultText.text = "Not Gained"
        }

        // Calculate gain based on the number of checked checkboxes
        val gain = when (checkedCount) {
            0 -> 100
            1 -> 50
            2 -> 10
            else -> 0
        }
        gainText.text = "Gain: $gain"

        // Return the gain value to MainActivity
        val resultIntent = Intent()
        resultIntent.putExtra("gain", gain)
        setResult(RESULT_OK, resultIntent)
        finish() // End the activity and return to MainActivity

    }
}