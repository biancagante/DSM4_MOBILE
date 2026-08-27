package br.edu.fatecpg.apptelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtName = findViewById<EditText>(R.id.edt_username)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val fabNext = findViewById<FloatingActionButton>(R.id.fab_next)

        var userName:String = ""

        btnSave.setOnClickListener {
            userName = edtName.text.toString()
            edtName.text.clear()
            Toast.makeText(this, "Nome enviado com sucesso", Toast.LENGTH_SHORT).show()
        }

        fabNext.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            if (userName.isNotBlank()) {
                intent.putExtra("username", userName)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Nome vazio", Toast.LENGTH_SHORT).show()
            }
        }
    }
}