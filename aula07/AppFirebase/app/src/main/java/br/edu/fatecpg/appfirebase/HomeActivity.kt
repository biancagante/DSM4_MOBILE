package br.edu.fatecpg.appfirebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore
import com.google.firebase.Firebase
import java.util.UUID

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val auth = FirebaseAuth.getInstance()
        val logout = findViewById<Button>(R.id.btnLogout)
        val deletarConta = findViewById<Button>(R.id.btnDeletarConta)
        val intent = Intent(this@HomeActivity, MainActivity::class.java)

        val clienteNome = findViewById<EditText>(R.id.edtClienteNome)
        val clienteCPF = findViewById<EditText>(R.id.edtClienteCPF)
        val btnSalvarCliente = findViewById<Button>(R.id.btnSalvarCliente)

        val db = Firebase.firestore
        val stamp = FieldValue.serverTimestamp()

        val hashUsuario = hashMapOf(
            "nome" to "Jesus",
            "cpf" to "222.222.222-22",
            "data_compra" to stamp
        )

        db.collection("colecao_cliente")
            .document("002")
            .set(hashUsuario)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("FIRESTORE", "SUCESSO")
                }
                else {
                    Log.d("FIRESTORE", "FALHA ${task.exception}")
                }
            }

        btnSalvarCliente.setOnClickListener {
            if (clienteNome.text.toString().isNotEmpty() && clienteCPF.text.toString().isNotEmpty()) {
                val hashCliente = hashMapOf(
                    "nome" to clienteNome.text.toString(),
                    "cpf" to clienteCPF.text.toString(),
                    "data_compra" to stamp
                )

                db.collection("colecao_cliente").document(UUID.randomUUID().toString()).set(hashCliente).addOnCompleteListener {
                    task -> {
                        if(task.isSuccessful) {
                            Log.d("FIRESTORE_COLLECTION", "Novo cliente adicionado com sucesso")
                            Toast.makeText(this, "Novo cliente adicionado.", Toast.LENGTH_SHORT).show()
                        }
                        else {
                            Log.d("FIRESTORE_COLLECTION", "Não foi possível adicionar cliente ${task.exception}")
                            Toast.makeText(this, "Não foi possível adicionar cliente.", Toast.LENGTH_SHORT).show()
                        }
                }
                }
            }
        }

        logout.setOnClickListener {
            auth.signOut()
            startActivity(intent)
        }

        deletarConta.setOnClickListener {
            auth.currentUser?.delete()
            finish()
        }
    }

}