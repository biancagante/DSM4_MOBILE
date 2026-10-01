package br.edu.fatecpg.appfilmes.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appfilmes.R
import br.edu.fatecpg.appfilmes.dao.FilmeDAO
import br.edu.fatecpg.appfilmes.model.Filme
import java.util.concurrent.Executors

class FilmeAdapter (private val movies : List<Filme>) : RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {
    val executor = Executors.newSingleThreadExecutor()
    val handler = Handler(Looper.getMainLooper())
    var image : Bitmap? = null

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle = itemView.findViewById<TextView>(R.id.txv_item_title)
        val movieGender = itemView.findViewById<TextView>(R.id.txv_item_gender)
        val moviePoster = itemView.findViewById<ImageView>(R.id.img_item_poster)
        val btnRemove = itemView.findViewById<Button>(R.id.btn_delete)
        //val moviePoster = itemView.findViewById<TextView>(R.id.txv_link)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movies_list, parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].title
        holder.movieGender.text = movies[position].gender
        //holder.moviePoster.setImageDrawable(movies[position].url)
        //holder.moviePoster.text = movies[position].url
        holder.btnRemove.setOnClickListener {
            FilmeDAO.excluir(holder.movieTitle.text.toString(), holder.movieGender.text.toString(), movies[position].url)
        }

        executor.execute {
            try {
                val stream = java.net.URL(movies[position].url).openStream()
                image = BitmapFactory.decodeStream(stream)

                handler.post {
                    holder.moviePoster.setImageBitmap(image)
                }
            }

            catch (error : Exception) {
                error.printStackTrace()
            }
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }
}