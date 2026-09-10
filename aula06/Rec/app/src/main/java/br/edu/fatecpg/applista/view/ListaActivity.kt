package br.edu.fatecpg.applista.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.applista.R
import br.edu.fatecpg.applista.adapter.UsuarioAdapter
import br.edu.fatecpg.applista.dao.UsuarioDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity(R.layout.activity_lista) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvUsuarios = findViewById<RecyclerView>(R.id.rv_usuarios)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)

        rvUsuarios.adapter = UsuarioAdapter(UsuarioDAO.buscar())
        rvUsuarios.layoutManager = LinearLayoutManager(this)

        fabVolta.setOnClickListener {
            finish()
        }
    }
}