package br.edu.fatecpg.cadastrolivros

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BookInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_information)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val info_book_title = findViewById<TextView>(R.id.txv_book_title)
        val info_book_author = findViewById<TextView>(R.id.txv_book_author)
        val fab_back = findViewById<FloatingActionButton>(R.id.fab_back)

        val book_title = intent.getStringExtra("book_title")
        val book_author = intent.getStringExtra("book_author")

        info_book_title.append(book_title)
        info_book_author.append(book_author)

        fab_back.setOnClickListener {
            finish()
        }
    }
}