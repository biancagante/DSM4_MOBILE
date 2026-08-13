package br.edu.fatecpg.meuapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        val txt_nome = findViewById<TextView>(R.id.txt_nome)
        val input_nome = findViewById<EditText>(R.id.input_nome)
        val btn_enviar = findViewById<Button>(R.id.btn_enviar)

        btn_enviar.setOnClickListener {
            val nome = input_nome.text.toString()
            txt_nome.setText("Bem-vindo, $nome")
            input_nome.text.clear()
        }
    }
}