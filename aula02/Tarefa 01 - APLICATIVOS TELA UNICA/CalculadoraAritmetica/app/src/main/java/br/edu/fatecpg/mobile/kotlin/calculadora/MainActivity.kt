package br.edu.fatecpg.mobile.kotlin.calculadora

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

        // definir os ids dos componentes
        val inputValues = findViewById<EditText>(R.id.edt_input)

        // operações
        val plus = findViewById<Button>(R.id.btn_plus)
        val minus = findViewById<Button>(R.id.btn_minus)
        val division = findViewById<Button>(R.id.btn_division)
        val multiply = findViewById<Button>(R.id.btn_multiply)

        // ações e resultado
        val calculate = findViewById<Button>(R.id.btn_calculate_result)
        val clearField = findViewById<Button>(R.id.btn_clear_field)
        var result = findViewById<TextView>(R.id.txv_result)

        plus.setOnClickListener {
            inputValues.text.append("+")
        }

        minus.setOnClickListener {
            inputValues.text.append("-")
        }

        division.setOnClickListener {
            inputValues.text.append("÷")
        }

        multiply.setOnClickListener {
            inputValues.text.append("×")
        }

        fun calcular(): Double {
            // values é um array os números inseridos e symbols é um array dos operadores, que foram  inseridos como texto no inputValues
            val values = inputValues.text.split("[+\\-÷×]".toRegex()).map { it.toDouble() }.toMutableList()
            val symbols = "[+\\-÷×]".toRegex().findAll(inputValues.text).map { it.value }.toMutableList()

            var c = 0
            while (c < symbols.size) {
                if (symbols[c] == "×" || symbols[c] == "÷") {
                    // vai pegar no array de números, o número antes do operador (casa definida como c) e depois do operador
                    var number1 = values[c]
                    var number2 = values[c+1]
                    var resultNumber = 0.0

                    if (symbols[c] == "×") resultNumber = number1 * number2

                    else {
                        if (number2 == 0.0) {
                            Toast.makeText(this, "Não foi possível dividir por zero", Toast.LENGTH_SHORT).show()
                        }
                        else resultNumber = number1 / number2
                    }
                    // o número antes do operador passa a ser o resultado, e o número depois é removido, assim como o operador que já foi utilizado
                    values[c] = resultNumber
                    values.removeAt(c+1)
                    symbols.removeAt(c)
                }

                c++
            }
            // aqui o for percorre pelos simbolos restantes (+ e -)
            var finalResult = values[0]
            for(d in 0 until (symbols.size)) {
                if (symbols[d] == "+") {
                    finalResult += values[d+1]
                }

                else if (symbols[d] == "-") {
                    finalResult -= values[d+1]
                }
            }

            return finalResult
        }

        calculate.setOnClickListener {
            if (inputValues.text.isNullOrBlank()) {
                Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show()
            }
            else {
                result.text = calcular().toString()
            }
        }

        clearField.setOnClickListener {
            inputValues.text.clear()
            result.text = ""
        }
    }
}