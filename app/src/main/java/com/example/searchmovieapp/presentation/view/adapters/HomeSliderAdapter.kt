package com.example.searchmovieapp.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchmovieapp.databinding.ItemHomeCarouselBinding
import com.example.searchmovieapp.presentation.utils.ImageUtil
import com.example.searchmovieapp.domain.model.CarouselItemBM

class HomeSliderAdapter(ls: List<CarouselItemBM>, var mListener: (CarouselItemBM) -> Unit) :
    RecyclerView.Adapter<HomeSliderAdapter.SliderViewHolder>() {

    private var list = ls as ArrayList<CarouselItemBM>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val _view =
            ItemHomeCarouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(_view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bindData(list[position])
        holder.itemView.setOnClickListener { mListener(list[position]) }
    }

    fun getCarouselList(): ArrayList<CarouselItemBM> {
        return list
    }

    class SliderViewHolder(itemView: ItemHomeCarouselBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val binding = itemView

        fun bindData(carouselItemBM: CarouselItemBM) {
            binding.imgCarousal.setImageResource(
                ImageUtil.getImageIdFromName(
                    context = itemView.context,
                    carouselItemBM.movieGenreImage!!
                )
            )

            binding.tvCarousal.text = carouselItemBM.movieGenre
        }
    }


}