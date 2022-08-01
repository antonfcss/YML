package com.example.yml.presentation.features.search.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yml.databinding.RecyclerviewItemSearchBinding
import com.example.yml.domain.popular.PopularFilmModel

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    var onItemClick: ((PopularFilmModel) -> Unit)? = null

    var movies: List<PopularFilmModel> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewItemSearchBinding.inflate(inflater, parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.itemView.rootView.setOnClickListener {
            onItemClick?.invoke(movies[position])
        }
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    class SearchViewHolder(
        private val binding: RecyclerviewItemSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieModel: PopularFilmModel) {
            binding.textViewSearchNameMovie.text = movieModel.name
            binding.searchImage.setImageBitmap(movieModel.poster)
            binding.textViewRelease.text = movieModel.year.toString()
        }
    }
}