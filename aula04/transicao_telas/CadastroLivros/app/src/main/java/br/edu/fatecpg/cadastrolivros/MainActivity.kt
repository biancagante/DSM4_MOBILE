package br.edu.fatecpg.cadastrolivros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inp_book_title = findViewById<EditText>(R.id.edt_name)
        val inp_book_author = findViewById<EditText>(R.id.edt_author)
        val btn_save = findViewById<Button>(R.id.btn_save)

        var book_title : String = ""
        var book_author : String = ""
        val intent = Intent(this, BookInformation::class.java)

        btn_save.setOnClickListener {
            if (inp_book_title.text.toString().isBlank() || inp_book_author.text.toString().isBlank()) {
                Toast.makeText(this, "Insira os valores do livro!", Toast.LENGTH_SHORT).show()
            }

            else {
                book_title = inp_book_title.text.toString()
                book_author = inp_book_author.text.toString()

                intent.putExtra("book_title", book_title)
                intent.putExtra("book_author", book_author)

                inp_book_title.text.clear()
                inp_book_author.text.clear()

                Toast.makeText(this, "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

                startActivity(intent)
            }
        }
    }
}