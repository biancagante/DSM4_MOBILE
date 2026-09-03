package br.edu.fatecpg.appdao.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appdao.R
import br.edu.fatecpg.appdao.dao.ProdutoDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProdutoActivity : AppCompatActivity(R.layout.activity_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val product_name = findViewById<TextView>(R.id.txv_product_name)
        val product_price = findViewById<TextView>(R.id.txv_product_price)
        val fab_before = findViewById<FloatingActionButton>(R.id.fab_before)

        val produto = ProdutoDAO.buscar()

        product_name.append(produto.nome)
        product_price.append(produto.preco.toString())

        fab_before.setOnClickListener {
            finish()
        }
    }
}