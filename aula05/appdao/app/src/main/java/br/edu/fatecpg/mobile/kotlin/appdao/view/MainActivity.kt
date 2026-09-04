package br.edu.fatecpg.mobile.kotlin.appdao.view

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
import br.edu.fatecpg.mobile.kotlin.appdao.R
import br.edu.fatecpg.mobile.kotlin.appdao.dao.ProdutoDAO
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

        val input_product_name = findViewById<EditText>(R.id.edt_product_name)
        val input_product_price = findViewById<EditText>(R.id.edt_product_price)
        val btn_save = findViewById<Button>(R.id.btn_save)
        val fab_next_view = findViewById<FloatingActionButton>(R.id.fab_send)

        btn_save.setOnClickListener {
            val nomeProduto = input_product_name.text.toString()
            val precoProduto = input_product_price.text.toString().toDouble()
            val retorno = ProdutoDAO.salvar(nomeProduto, precoProduto)
            Log.i("ESTADO", retorno)
            Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
            input_product_name.text.clear()
            input_product_price.text.clear()
        }

        fab_next_view.setOnClickListener {
            val intent = Intent(this, ProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}