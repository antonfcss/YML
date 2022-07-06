package com.example.yml.presentation.features.popular.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yml.databinding.RecyclerviewItemMovieBinding
import com.example.yml.domain.movie.MovieModel

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(
        val binding: RecyclerviewItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root)

    var movies: List<MovieModel> = emptyList()
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
        val movie = movies[position]
        with(holder.binding) {
            nameMovie.text = movie.title
        }
    }

    override fun getItemCount(): Int = movies.size

}