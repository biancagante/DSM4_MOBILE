package br.edu.fatecpg.mobile.kotlin.appimc.view

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
import br.edu.fatecpg.mobile.kotlin.appimc.R
import br.edu.fatecpg.mobile.kotlin.appimc.dao.IMCResultDAO
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

        val height = findViewById<EditText>(R.id.edt_height)
        val weight = findViewById<EditText>(R.id.edt_weight)

        val btnSave = findViewById<Button>(R.id.btn_save)
        val fabNext = findViewById<FloatingActionButton>(R.id.fab_next)

        var clicked = false

        btnSave.setOnClickListener {
            if (height.text.toString().isBlank() || weight.text.toString().isBlank()) {
                Toast.makeText(this, "Insira valores numéricos nos campos acima", Toast.LENGTH_SHORT).show()
            }
            else {
                val returnState = IMCResultDAO.save(height.text.toString().toDouble(), weight.text.toString().toDouble())
                Log.i("ESTADO", returnState)
                Toast.makeText(this, returnState, Toast.LENGTH_SHORT).show()
                clicked = true
                height.text.clear()
                weight.text.clear()
            }
        }

        fabNext.setOnClickListener {
            if (!clicked) {
                Toast.makeText(this, "Salve os dados antes de prosseguir", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
        }
    }
}