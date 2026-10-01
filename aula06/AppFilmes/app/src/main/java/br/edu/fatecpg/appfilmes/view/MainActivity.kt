package br.edu.fatecpg.appfilmes.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appfilmes.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // variaveis do login
        val edtUser = findViewById<EditText>(R.id.edt_user)
        val edtPassword = findViewById<EditText>(R.id.edt_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        val user = "admin"
        val password = "abc123"

        btnLogin.setOnClickListener {
            if (edtUser.text.toString().isEmpty() || edtPassword.text.toString().isEmpty()) {
                Toast.makeText(this, "Algum campo está vazio!", Toast.LENGTH_SHORT).show()
            }
            else {
                if (edtUser.text.toString() == user && edtPassword.text.toString() == password) {
                    Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show()

                    edtUser.text.clear()
                    edtPassword.text.clear()

                    val intent = Intent(this, CadastroActivity::class.java)
                    startActivity(intent)
                }

                else {
                    Toast.makeText(this, "Credenciais não batem", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}