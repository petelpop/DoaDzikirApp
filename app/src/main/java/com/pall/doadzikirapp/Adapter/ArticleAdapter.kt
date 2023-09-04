package com.pall.doadzikirapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pall.doadzikirapp.Interface.OnItemCallback
import com.pall.doadzikirapp.databinding.ItemArticleBinding
import com.pall.doadzikirapp.model.ArticleItem
import com.pall.doadzikirapp.presentation.DetailArticleActivity

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    // variable to store dataset
    private val listArticle = ArrayList<ArticleItem>()
    // variable to give event click of item in Activity through setOnClickCallback
    private var onItemCallback: OnItemCallback? = null

    fun setData(list: List<ArticleItem>) {
        listArticle.clear()
        listArticle.addAll(list)
    }

    // function to set event click in item using interface
    fun setOnItemClickCallback(onItemCallback: OnItemCallback) {
        this.onItemCallback = onItemCallback
    }
    inner class ArticleViewHolder(val view: ItemArticleBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder(
        ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArticle[position]
        holder.view.itemArticle.setImageResource(data.imageArticle)
        // this is give click event for each item in ViewPager
        holder.itemView.setOnClickListener {
            // set event cli
            onItemCallback?.onItemClicked(data)
            // provide context for Intent
            it.context.apply {
                // navigate to DetailActivity
                val intent = Intent(this, DetailArticleActivity::class.java)
                // navigate to DetailActivity with datas using putExtra
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_TITLE, data.titleArticle)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_CONTENT, data.descArticle)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_IMAGE, data.imageArticle)
                startActivity(intent)
            }
        }
    }


}