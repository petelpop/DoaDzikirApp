package com.pall.doadzikirapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pall.doadzikirapp.R
import com.pall.doadzikirapp.databinding.ItemArticleBinding
import com.pall.doadzikirapp.model.ArticleItem

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private val listArticle = ArrayList<ArticleItem>()

    fun setData(list: List<ArticleItem>){
        listArticle.clear()
        listArticle.addAll(list
        )
    }
    inner class ArticleViewHolder(view: ItemArticleBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder (
        ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}