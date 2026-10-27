package br.edu.fatecpg.appfirebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

        val edtUsuario = findViewById<EditText>(R.id.edt_cadastro_user)
        val edtSenha = findViewById<EditText>(R.id.edt_cadastro_senha)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val pageLogin = findViewById<TextView>(R.id.link_login)

        btnCadastrar.setOnClickListener {
//            auth.createUserWithEmailAndPassword(edtUser.text.toString(), edtSenha.text.toString()).addOnCompleteListener {
//                task -> if (task.isSuccessful) {
//                        val intent = Intent(this, HomeActivity::class.java)
//                        startActivity(intent)
//                    }
//                    else {
//                        if (edtUser.text.isNullOrEmpty() || edtSenha.text.isNullOrEmpty()) {
//                            Toast.makeText(this, "Algum campo está vazio", Toast.LENGTH_SHORT).show()
//                        }
//
//                        else if (!edtUser.text.toString().contains("@") || !edtUser.text.toString().contains(".com")) {
//                            Toast.makeText(this, "Usuário inválido", Toast.LENGTH_SHORT).show()
//                        }
//
//                        else {
//                            Toast.makeText(this, "Não foi possível efetuar login", Toast.LENGTH_SHORT).show()
//                            Log.i("Login error", "Não foi possível logar com firebase")
//                        }
//                    }
            val intent = Intent(this, HomeActivity::class.java)

            if (edtUsuario.text.toString().isNotEmpty() && edtSenha.text.toString().isNotEmpty()) {
                auth.createUserWithEmailAndPassword(
                    edtUsuario.text.toString(),
                    edtSenha.text.toString()
                ).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    }
                    else {
                        if (!edtUsuario.text.toString().contains("@") || !edtUsuario.text.toString().contains(".com")) {
                            Toast.makeText(this, "Usuário inválido", Toast.LENGTH_SHORT).show()
                        }

                        else {
                            Toast.makeText(this, "Não foi possível criar conta", Toast.LENGTH_SHORT).show()
                            Log.i("FIREBASE_CREATE_ACCOUNT_ERROR", "Não foi possível criar novo usuário $edtUsuario")
                        }
                    }
                }
            }
            else {
                Toast.makeText(this, "Algum campo não está preenchido", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
        }

        pageLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}