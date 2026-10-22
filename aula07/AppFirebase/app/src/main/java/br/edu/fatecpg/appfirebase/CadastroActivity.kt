package br.edu.fatecpg.appfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class CadastroActivity : AppCompatActivity(R.layout.activity_cadastro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val auth = FirebaseAuth.getInstance()

        val edtUser = findViewById<EditText>(R.id.edt_cadastro_user)
        val edtSenha = findViewById<EditText>(R.id.edt_cadastro_senha)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val pageLogin = findViewById<TextView>(R.id.link_login)

        btnCadastrar.setOnClickListener {
            auth.createUserWithEmailAndPassword(edtUser.text.toString(), edtSenha.text.toString()).addOnCompleteListener {
                task -> if (task.isSuccessful) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}