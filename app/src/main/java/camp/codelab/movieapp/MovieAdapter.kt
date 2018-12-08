package camp.codelab.movieapp

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import camp.codelab.movieapp.models.Movie
import com.squareup.picasso.Picasso

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    val movieList: List<Movie>

    constructor(movieList: List<Movie>) {
        this.movieList = movieList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        viewHolder.setMovie(movieList[position])
    }


    inner class MovieViewHolder : RecyclerView.ViewHolder {
        val view: View

        constructor(view: View) : super(view) {
            this.view = view

            this.view.setOnClickListener {
                val movie = movieList[layoutPosition]
                val url = movie.url
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                it.context.startActivity(intent)
            }
        }

        fun setMovie(movie: Movie) {
            view.titleTextView.text = movie.title

            Picasso.get().load(movie.imageUrl).into(view.movieImageView)

            view.descriptionTextView.text = movie.descriptionMovie
        }
    }
}