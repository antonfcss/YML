package com.example.yml.presentation.features.mytop.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yml.databinding.RecyclerviewItemMyTopBinding
import com.example.yml.domain.popular.PopularFilmModel

class MyTopAdapter : RecyclerView.Adapter<MyTopAdapter.MyTopViewHolder>() {

    var onItemClick: ((PopularFilmModel) -> Unit)? = null

    var movies: List<PopularFilmModel> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTopViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewItemMyTopBinding.inflate(inflater, parent, false)
        return MyTopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyTopViewHolder, position: Int) {
        holder.itemView.rootView.setOnClickListener {
            onItemClick?.invoke(movies[position])
        }
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    class MyTopViewHolder(
        private val binding: RecyclerviewItemMyTopBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieModel: PopularFilmModel) {
            binding.textViewMyTopNameMovie.text = movieModel.name
            binding.myTopImage.setImageBitmap(movieModel.poster)
            binding.textViewRelease.text = movieModel.year.toString()
        }
    }
}