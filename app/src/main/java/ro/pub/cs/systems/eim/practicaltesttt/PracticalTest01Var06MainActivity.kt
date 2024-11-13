package ro.pub.cs.systems.eim.practicaltesttt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var06MainActivity : AppCompatActivity() {

    private var score = 0 // Variable to store the accumulated score

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var06_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val number3 = findViewById<EditText>(R.id.number3)

        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)

        val playButton = findViewById<Button>(R.id.playButton)

        // Set a listener on the "Play" button
        playButton.setOnClickListener {
            // Define the set of values {1, 2, 3, *} where * is represented by 4
            val values = listOf(1, 2, 3, "*")

            // Generate random values for each field
            val randomValue1 = values.random()
            val randomValue2 = values.random()
            val randomValue3 = values.random()

            // Only override the text field values if the corresponding checkbox is unchecked
            if (!checkBox1.isChecked) {
                number1.setText(randomValue1.toString())
            }
            if (!checkBox2.isChecked) {
                number2.setText(randomValue2.toString())
            }
            if (!checkBox3.isChecked) {
                number3.setText(randomValue3.toString())
            }

            // Count checked checkboxes
            val checkedCount = listOf(checkBox1, checkBox2, checkBox3).count { it.isChecked }

            // Start ResultActivity with intent data and await result
            val intent = Intent(this, PracticalTest01Var06SecondaryActivity::class.java).apply {
                putExtra("number1", number1.text.toString())
                putExtra("number2", number2.text.toString())
                putExtra("number3", number3.text.toString())
                putExtra("checkedCount", checkedCount)
            }
            startActivityForResult(intent, REQUEST_CODE_RESULT)
        }
    }

    // Receive the result from ResultActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_RESULT && resultCode == RESULT_OK) {
            val gain = data?.getIntExtra("gain", 0) ?: 0
            score += gain // Accumulate the score
            Toast.makeText(this, "Current Score: $score", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val REQUEST_CODE_RESULT = 1
    }
}