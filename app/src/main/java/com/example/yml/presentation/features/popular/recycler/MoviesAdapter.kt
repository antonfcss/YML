package com.example.yml.presentation.features.popular.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yml.databinding.RecyclerviewItemMovieBinding
import com.example.yml.domain.popular.PopularFilmModel

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    var onItemClick: ((PopularFilmModel) -> Unit)? = null

    var movies: List<PopularFilmModel> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewItemMovieBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.rootView.setOnClickListener {
            onItemClick?.invoke(movies[position])
        }
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    class MoviesViewHolder(
        private val binding: RecyclerviewItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieModel: PopularFilmModel) {
            binding.nameMovie.text = movieModel.name
            binding.movieImageView.setImageBitmap(movieModel.poster)
        }
    }
}