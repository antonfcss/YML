package com.example.yml.presentation.features.search.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yml.databinding.RecyclerviewItemMovieBinding
import com.example.yml.databinding.RecyclerviewItemSearchBinding
import com.example.yml.domain.popular.PopularFilmModel

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    //Обработка кликок с изменяемой лямдой
    var onItemClick: ((PopularFilmModel) -> Unit)? = null

     var movies: List<PopularFilmModel> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    //метод для создания нового элемента списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewItemSearchBinding.inflate(inflater, parent, false)
        return SearchViewHolder(binding)
    }

    //Обновление элемента списка
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        //Нажатие на
        holder.itemView.rootView.setOnClickListener {
            onItemClick?.invoke(movies[position])
        }
        holder.bind(movies[position])
    }

    //Возвращает количество элементов в списке, чтобы адаптер знал их количество
    override fun getItemCount(): Int = movies.size

    class SearchViewHolder(
        private val binding: RecyclerviewItemSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieModel: PopularFilmModel) {
            binding.textViewSearchNameMovie.text = movieModel.name
            binding.searchImage.setImageBitmap(movieModel.poster)
        }
    }
}