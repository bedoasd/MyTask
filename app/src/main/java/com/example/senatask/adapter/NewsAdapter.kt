package com.example.senatask.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.senatask.BR
import com.example.senatask.databinding.ItemArticleBinding
import kotlinx.android.synthetic.main.item_article.view.*
import com.example.senatask.model.Result
class NewsAdapter: PagingDataAdapter<Result, NewsAdapter.MyViewHolder>(Diff_Utils) {



    companion object{
        val Diff_Utils=object : DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem==newItem
            }

        }
    }
    val differ = AsyncListDiffer(this, Diff_Utils)

    inner class MyViewHolder(var previewBinding: ItemArticleBinding): RecyclerView.ViewHolder(previewBinding.root) {


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val data =getItem(position)


        holder.itemView.apply {

            Glide.with(ivArticleImage).load(data?.media?.get(0)?.media_metadata?.get(0)?.url).into(ivArticleImage)

            tvTitle.text= data?.title
            tvPublisheddate.text= data?.published_date
            tvWriter.text= data?.byline



            setOnClickListener {

                onItemClickListener?.let { it(data!!) }
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)

    }

    private var onItemClickListener : ((Result)->Unit )?=null

    fun setOnItemClickListener(listener: (Result)->Unit){
        onItemClickListener=listener
    }
}