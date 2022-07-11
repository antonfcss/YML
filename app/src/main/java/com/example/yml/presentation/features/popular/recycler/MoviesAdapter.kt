package com.example.yml.presentation.features.popular.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yml.databinding.RecyclerviewItemMovieBinding
import com.example.yml.domain.api.DomainRetrofitModel
import com.example.yml.domain.movie.MovieModel

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(
        private val binding: RecyclerviewItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieModel: DomainRetrofitModel) {
            binding.nameMovie.text = movieModel.url
        }
    }

    var movies: List<DomainRetrofitModel> = emptyList()
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
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

}