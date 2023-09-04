package com.pall.doadzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.card.MaterialCardView
import com.pall.doadzikirapp.Adapter.ArticleAdapter
import com.pall.doadzikirapp.Interface.OnItemCallback
import com.pall.doadzikirapp.databinding.ActivityMainBinding
import com.pall.doadzikirapp.model.ArticleItem
import com.pall.doadzikirapp.presentation.DetailArticleActivity
import com.pall.doadzikirapp.presentation.DzikirHarianActivity
import com.pall.doadzikirapp.presentation.DzikirSetiapSaatActivity
import com.pall.doadzikirapp.presentation.pagipetang.PagiPetangActivity
import com.pall.doadzikirapp.presentation.QauliyahShalatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var dotSliderIndicator = arrayOf<ImageView?>()

    // OnPageChangeCallback is subClass from ViewPager2 for
    // responding to changing state of the selected page
    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        // instance onPageSelected give you access to setting behavior state of selected page
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Toast.makeText(this@MainActivity, "Page $position", Toast.LENGTH_SHORT).show()
            for (i in initData().indices) {
                dotSliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.inactive_dot)
                )
            }

            dotSliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.active_dot)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // this method is from dependencies splash screen API 12
        installSplashScreen()
        // setContentView is use to choose or display layout in activity
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setUpViewPager()
    }

    private fun setUpViewPager() {
        dotSliderIndicator = arrayOfNulls(initData().size)

        for (i in initData().indices) {
            dotSliderIndicator[i] = ImageView(this)
            dotSliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.inactive_dot)
            )

            val params =  LinearLayoutCompat.LayoutParams(35, 35)
            params.marginStart = 8
            params.marginEnd = 8
            binding.dots.addView(dotSliderIndicator[i], params)

        }
    }

    private fun initView() {
        // declare variable to get in touch with view in layout activity_main
        // use findViewById to communicate with the view
        val cardQauliyahShalat = findViewById<MaterialCardView>(R.id.card_qauliyah_shalat)
        val cardDzikir = findViewById<MaterialCardView>(R.id.card_dzikir)
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.card_dzikir_harian)
        val cardDzikirPagiPetang = findViewById<MaterialCardView>(R.id.card_pagi_petang)


        // when cardview clicked it will be navigate to other page
        // Intent is use for navigate to other activit by clicking cardView
        cardQauliyahShalat.setOnClickListener {
            // Intent(argument content, which Activity you want to go)
            val intent = Intent(this, QauliyahShalatActivity::class.java)
            // start to go to destination activity
            startActivity(intent)
        }
        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardDzikirPagiPetang.setOnClickListener(this)

        val mAdapter = ArticleAdapter()
        mAdapter.setData(initData())
        mAdapter.setOnItemClickCallback(object: OnItemCallback {
            override fun onItemClicked(item: ArticleItem) {
                // navigate to DetailActivity
                val intent = Intent(this@MainActivity, DetailArticleActivity::class.java)
                // navigate to DetailActivity with datas using putExtra
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_TITLE, item.titleArticle)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_CONTENT, item.descArticle)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_IMAGE, item.imageArticle)
                startActivity(intent)
            }
        })
        binding.vpArticle.adapter = mAdapter
        binding.vpArticle.registerOnPageChangeCallback(slidingCallback)

    }

    private fun initData(): List<ArticleItem> {
        val titleArticle = resources.getStringArray(R.array.arr_title_artikel)
        val contentArticle = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArticle = resources.obtainTypedArray(R.array.arr_img_artikel)

        val listData = arrayListOf<ArticleItem>()
        for (i in titleArticle.indices) {
            val data = ArticleItem(
                titleArticle[i],
                imageArticle.getResourceId(i, 0),
                contentArticle[i]
            )
            listData.add(data)
        }
        imageArticle.recycle()
        return listData
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.card_dzikir -> startActivity(Intent(this, DzikirSetiapSaatActivity::class.java))
            R.id.card_dzikir_harian -> startActivity(Intent(this, DzikirHarianActivity::class.java))
            R.id.card_pagi_petang -> startActivity(Intent(this, PagiPetangActivity::class.java))

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}