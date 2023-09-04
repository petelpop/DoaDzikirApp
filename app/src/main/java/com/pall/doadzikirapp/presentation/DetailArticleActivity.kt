package com.pall.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pall.doadzikirapp.R
import com.pall.doadzikirapp.databinding.ActivityDetailArticleBinding
import com.pall.doadzikirapp.databinding.ActivityMainBinding

class DetailArticleActivity : AppCompatActivity() {
    private var _binding: ActivityDetailArticleBinding? = null
    private val binding get() = _binding as ActivityDetailArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        setContentView(R.layout.activity_detail_article)
        _binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleArticle = intent.getStringExtra(EXTRA_DATA_TITLE)
        val contentArticle = intent.getStringExtra(EXTRA_DATA_CONTENT)
        val imageArticle = intent.getIntExtra(EXTRA_DATA_IMAGE, 1)

        binding.apply {
            tvDetailTitle.text = titleArticle
            tvDetailContent.text = contentArticle
            imgDetailArticle.setImageResource(imageArticle)

        }
    }

    // object used in this activity which can access by the other class
    companion object {
        // constant for save KEY of data transaction
        const val EXTRA_DATA_TITLE = "title"
        const val EXTRA_DATA_CONTENT = "content"
        const val EXTRA_DATA_IMAGE = "image"

    }
}