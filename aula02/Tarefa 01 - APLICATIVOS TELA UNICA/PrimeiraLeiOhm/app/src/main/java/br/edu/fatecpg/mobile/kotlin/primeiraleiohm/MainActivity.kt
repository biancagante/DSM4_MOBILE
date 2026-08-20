package br.edu.fatecpg.mobile.kotlin.primeiraleiohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // voltage = tensão, resistance = resistencia e current = corrente
        val voltage = findViewById<EditText>(R.id.edt_voltage)
        val resistance = findViewById<EditText>(R.id.edt_resistance)
        val current = findViewById<EditText>(R.id.edt_current)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val output = findViewById<TextView>(R.id.txv_output)

        btnCalculate.setOnClickListener {
            output.text = ""
            var voltageValue = 0.0
            var resistanceValue = 0.0
            var currentValue = 0.0
            val voltageIsNullOrBlank = voltage.text.isNullOrBlank()
            val resistanceIsNullOrBlank = resistance.text.isNullOrBlank()
            val currentIsNullOrBlank = current.text.isNullOrBlank()

            val filledFields = listOf(!voltageIsNullOrBlank, !resistanceIsNullOrBlank, !currentIsNullOrBlank).count()

            // se a quantidade de campos preenchidos diferente de 2 campos exatos
            if (filledFields < 2) {
                Toast.makeText(this, "Insira valores em dois campos", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            else {
                if (!voltageIsNullOrBlank && !resistanceIsNullOrBlank) {
                    currentValue = voltage.text.toString().toDouble() / resistance.text.toString().toDouble()
                    output.append("\nA corrente é $currentValue A")
                }

                if (!voltageIsNullOrBlank && !currentIsNullOrBlank) {
                    resistanceValue = voltage.text.toString().toDouble() / current.text.toString().toDouble()
                    output.append("\nA resistência é $resistanceValue Ohm")
                }

                if (!resistanceIsNullOrBlank && !currentIsNullOrBlank) {
                    voltageValue = resistance.text.toString().toDouble() * current.text.toString().toDouble()
                    output.append("\nA tensão é de $voltageValue V")
                }
            }
        }
    }
}