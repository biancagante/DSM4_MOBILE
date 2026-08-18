package br.edu.fatecpg.mobile.kotlin.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.set
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.stream.Stream

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

        // definir os ids dos componentes
        val inputValues = findViewById<EditText>(R.id.edt_input)

        // operações
        val plus = findViewById<Button>(R.id.btn_plus)
//        val minus = findViewById<Button>(R.id.btn_minus)
//        val division = findViewById<Button>(R.id.btn_division)
//        val multiply = findViewById<Button>(R.id.btn_multiply)

        // ações e resultado
        val calculate = findViewById<Button>(R.id.btn_calculate_result)
        val clearField = findViewById<Button>(R.id.btn_clear_field)
        var result = findViewById<TextView>(R.id.txv_result)

        plus.setOnClickListener {
            inputValues.text.append("+")
        }

        fun getSymbol() : Char {
            for (a in inputValues.text) {
                if (a.equals('+') || a.equals('-')) {
                    return a
                }
            }

            return ' '
        }

        calculate.setOnClickListener {
            var teste = inputValues.text.split("+", "-", "/", "*")
//            var soma = 0
//            for (i in 0 until(teste.size)) {
//                soma += teste[i].toInt()
//            }
//            result.text = soma.toString()
            result.text = getSymbol().toString()
        }

        clearField.setOnClickListener {
            inputValues.text.clear()
            result.text = ""
        }
    }
}