package br.edu.fatecpg.appfilmes.view

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appfilmes.R
import br.edu.fatecpg.appfilmes.adapter.FilmeAdapter
import br.edu.fatecpg.appfilmes.dao.FilmeDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FilmesActivity : AppCompatActivity(R.layout.activity_filmes) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvMovies = findViewById<RecyclerView>(R.id.rv_movies)
        val fabBefore = findViewById<FloatingActionButton>(R.id.fab_before)
        val btnRemove = findViewById<Button>(R.id.btn_delete)

        rvMovies.adapter = FilmeAdapter(FilmeDAO.buscar())
        rvMovies.layoutManager = LinearLayoutManager(this)

        fabBefore.setOnClickListener {
            finish()
        }
    }
}