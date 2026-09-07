package br.edu.fatecpg.mobile.kotlin.appimc.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.mobile.kotlin.appimc.R
import br.edu.fatecpg.mobile.kotlin.appimc.dao.IMCResultDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ResultActivity : AppCompatActivity(R.layout.activity_result) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txv_imc_result = findViewById<TextView>(R.id.txv_imc_result)
        val txv_imc_category = findViewById<TextView>(R.id.txv_imc_category)
        val fabBefore = findViewById<FloatingActionButton>(R.id.fab_before)

        val imcResult = IMCResultDAO.result()
        val imcCategory = IMCResultDAO.category()

        txv_imc_result.text = imcResult.toString()
        txv_imc_category.text = imcCategory

        fabBefore.setOnClickListener {
            finish()
        }
    }
}