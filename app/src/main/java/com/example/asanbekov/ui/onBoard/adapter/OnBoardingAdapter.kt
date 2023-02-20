package com.example.asanbekov.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.asanbekov.databinding.ItemOnBoardingBinding
import com.example.asanbekov.model.OnBoard
import com.example.asanbekov.ui.utils.loadImage

class OnBoardingAdapter (private val onStartClick:()-> Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    val data = arrayListOf<OnBoard>(
        OnBoard("Fresh Food",
            "Lorem ipsum dolor sit amet,consectetuer adipiscing elit.Aenean commodo ligula eget dolor." ,
            "https://www.pngitem.com/pimgs/m/415-4153227_hamburger-fast-food-junk-food-breakfast-clip-art.png"
        ),
        OnBoard("Fast Delivery",
            "Loren ipsum dolor sit amet,consectetuer adipiscing elit.Aenean commodo ligula eget dolor." ,
            "https://en.pimg.jp/065/648/893/1/65648893.jpg"
        ),
        OnBoard("Easy Payment",
            "Loren ipsum dolor sit amet,consectetuer adipiscing elit.Aenean commodo ligula eget dolor." ,
            "https://www.shutterstock.com/image-vector/online-card-payment-concept-easy-260nw-1306465405.jpg"
        ),
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount() = data.size

    inner class OnBoardingViewHolder(private val binding:ItemOnBoardingBinding) : ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {

            binding.btnStart.isVisible = adapterPosition == 2
            binding.btnSkip.isVisible = adapterPosition != 2

            binding.btnStart.setOnClickListener {
                onStartClick()
            }
            binding.btnSkip.setOnClickListener {
                onStartClick()
            }
            binding.title.text=onBoard.title
            binding.description.text=onBoard.desc
            binding.ivBoard.loadImage(onBoard.image.toString())
        }

    }

}