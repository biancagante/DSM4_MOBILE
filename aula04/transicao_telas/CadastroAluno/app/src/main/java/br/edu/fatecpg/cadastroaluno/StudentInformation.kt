package br.edu.fatecpg.cadastroaluno

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text
import java.time.LocalDate
import java.util.Calendar
import java.util.UUID

class StudentInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_information)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txv_student_name = findViewById<TextView>(R.id.txv_name)
        val txv_student_id = findViewById<TextView>(R.id.txv_id_number)

        val btn_gen_id_number = findViewById<Button>(R.id.btn_generate_id)
        val fab_back = findViewById<FloatingActionButton>(R.id.fab_back)

        var counter = 0;

        txv_student_name.append(intent.getStringExtra("student_name"))
        //txv_student_id.append("Matrícula não foi definida")

        btn_gen_id_number.setOnClickListener {
            while (counter == 0) {
                val id = "${UUID.randomUUID().toString().substring(0, 6)}${Calendar.getInstance().get(
                    Calendar.YEAR)}"
                //txv_student_id.text = txv_student_id.text.toString().replace { "Matrícula não foi definida"; " " }
                txv_student_id.append(id)
                btn_gen_id_number.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#888888"))
                counter += 1
            }

            Toast.makeText(this, "Matrícula já foi definida.", Toast.LENGTH_SHORT).show()
        }

        fab_back.setOnClickListener {
            finish()
        }
    }
}