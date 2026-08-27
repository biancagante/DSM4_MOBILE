package br.edu.fatecpg.cadastroaluno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val edt_name = findViewById<EditText>(R.id.edt_name)
        val btn_save_name = findViewById<Button>(R.id.btn_save)
        val intent = Intent(this, StudentInformation::class.java)

        var student_name : String = ""

        btn_save_name.setOnClickListener {
            if (edt_name.text.toString().isBlank()) {
                Toast.makeText(this, "Campo de nome vazio.", Toast.LENGTH_SHORT).show()
            }

            else {
                student_name = edt_name.text.toString()
                intent.putExtra("student_name", student_name)
                edt_name.text.clear()
                Toast.makeText(this, "Nome do aluno cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
        }
    }
}