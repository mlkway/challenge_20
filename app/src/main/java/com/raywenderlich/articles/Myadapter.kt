package com.raywenderlich.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raywenderlich.articles.databinding.ArticlesItemBinding
import com.raywenderlich.models.ArticlesItem
import kotlin.math.abs

class Myadapter:RecyclerView.Adapter<Myadapter.ViewHolder>() {

    var data = mutableListOf<ArticlesItem>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter.ViewHolder {
        return ViewHolder(ArticlesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Myadapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()=data.size

    inner class ViewHolder(private val binding: ArticlesItemBinding):RecyclerView.ViewHolder(binding.root){
        private lateinit var currentItem: ArticlesItem
        fun bind(){
            currentItem = data[absoluteAdapterPosition]
                Glide.with(itemView.context).load(currentItem.imageUrl)
                    .into(binding.imageView)

            binding.apply {
                textView2.text = currentItem.title
                textView3.text = currentItem.updatedAt
                descriptionText.text = currentItem.summary
                timeLineTxt.text = listToString(currentItem.events)
            }
        }
    }


    private fun listToString(str:List<String>):String{


        var stringForReturn = ""

        for (i in str){
            stringForReturn + i + ","
        }

        return stringForReturn

    }




}