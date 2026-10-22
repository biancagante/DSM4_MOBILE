package br.edu.fatecpg.appfirebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = FirebaseAuth.getInstance()
//        auth.signInWithEmailAndPassword("ale@fatec.br", "ale12345").addOnCompleteListener {
//                task -> if (task.isSuccessful) {
//            Log.i("FIREBASE", "Logado com sucesso!")
//        }
//        else {
//            Log.i("FIREBASE", "Erro ao logar ${task.exception}")
//        }
//        }

        val pageCadastro = findViewById<TextView>(R.id.link_cadastro)
        val edtUsuario = findViewById<EditText>(R.id.edt_login_user)
        val edtSenha = findViewById<EditText>(R.id.edt_login_password)
        val btnLogin = findViewById<Button>(R.id.btn_login_auth)

        btnLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(edtUsuario.text.toString(), edtSenha.text.toString()).addOnCompleteListener {
                    task -> if (task.isSuccessful) {
                        Log.i("FIREBASE", "Logado com sucesso!")
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    }
                    else {
                        Log.i("FIREBASE", "Erro ao logar ${task.exception}")
                    }
            }
        }

        pageCadastro.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}