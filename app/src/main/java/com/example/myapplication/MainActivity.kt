package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView //We used lateinit to avoid null checks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        val rollBtn: Button = findViewById(R.id.roll_button)

        var n: Int = 1 //this stores the number of times the dice were rolled

        rollBtn.text = "Let's Roll" //example of setting the text of the button from the kotlin activity
        rollBtn.setOnClickListener {
            Toast.makeText(this, "Dice Rolled $n times", Toast.LENGTH_SHORT).show()
            rollDice()
            n++
        }
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = Random().nextInt(6) + 1 //rolling the dice to generate a random number
        resultText.text = randomInt.toString() //set the text to be the value of the generated random integer
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}