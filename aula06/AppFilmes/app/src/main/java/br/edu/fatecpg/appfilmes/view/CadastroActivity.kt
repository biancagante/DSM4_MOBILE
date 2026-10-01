package br.edu.fatecpg.appfilmes.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appfilmes.R
import br.edu.fatecpg.appfilmes.dao.FilmeDAO

class CadastroActivity : AppCompatActivity(R.layout.activity_cadastro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val movieTitle = findViewById<EditText>(R.id.edt_movie_title)
        val movieGender = findViewById<EditText>(R.id.edt_movie_gender)
        val movieUrl = findViewById<EditText>(R.id.edt_movie_url)
        val btnSaveMovie = findViewById<Button>(R.id.btn_save_movie)
        val linkToList = findViewById<TextView>(R.id.link_list_movies)

        btnSaveMovie.setOnClickListener {
            if (movieTitle.text.isEmpty() || movieGender.text.isEmpty() || movieUrl.text.isEmpty()) {
                Toast.makeText(this, "Algum campo está vazio!", Toast.LENGTH_SHORT).show()
            }

            else {
                val title = movieTitle.text.toString()
                val gender = movieGender.text.toString()
                val url = movieUrl.text.toString()

                movieTitle.text.clear()
                movieGender.text.clear()
                movieUrl.text.clear()

                val retorno = FilmeDAO.salvar(title, gender, url)

                Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
            }
        }

        linkToList.setOnClickListener {
            var intent = Intent(this, FilmesActivity::class.java)
            startActivity(intent)
            //finish()
        }
    }
}