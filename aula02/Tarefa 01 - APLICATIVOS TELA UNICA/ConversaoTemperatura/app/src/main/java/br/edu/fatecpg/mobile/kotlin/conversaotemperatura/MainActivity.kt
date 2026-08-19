package br.edu.fatecpg.mobile.kotlin.conversaotemperatura

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

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

        // calculo: F = (C * 1.8 + 32)
        val input = findViewById<TextInputEditText>(R.id.edt_input)
        val btnCalc = findViewById<Button>(R.id.btn_calc)
        val output = findViewById<TextView>(R.id.txv_output)

        btnCalc.setOnClickListener {
            if (input.text.isNullOrBlank() || input.text.contentEquals(".")) {
                Toast.makeText(this, "Insira um valor válido.", Toast.LENGTH_SHORT).show()
            }
            else {
                val value : Double = input.text.toString().toDouble()
                val result = ((value * 1.8) + 32)
                output.text = "O resultado é ${String.format("%.2f", result)}°F"
            }
        }
    }
}