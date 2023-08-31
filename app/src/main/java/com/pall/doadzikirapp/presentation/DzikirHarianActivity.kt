package com.pall.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pall.doadzikirapp.DoaDzikirAdapter
import com.pall.doadzikirapp.R
import com.pall.doadzikirapp.databinding.ActivityDzikirHarianBinding
import com.pall.doadzikirapp.databinding.ActivityQauliyahShalatBinding
import com.pall.doadzikirapp.model.DoaDzikirItem

class DzikirHarianActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirHarianBinding? = null
    private val binding get() = _binding as ActivityDzikirHarianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // show navigation button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        _binding = ActivityDzikirHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirDatas()
        initView()
    }

    private fun initView() {
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(providingDzikirDatas())
        binding.rvDzikirHarian.adapter = mAdapter
        binding.rvDzikirHarian.layoutManager = LinearLayoutManager(this)
    }

    private fun providingDzikirDatas() : List<DoaDzikirItem> {
        // data set of dzikir is located in strings.xml
        // we need to get string array from strings.xml put into a variable
        // resources is a variable from AppCompat which getting access to Resource directory
        // from resources we can call resources directory like as drawable, layout ( strings, theme, color )
        // so, now variable titleDzikir containing datas as Array-String arr_dzikir_doa_harian
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabicDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val translateDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDzikirItem>()
        for (i in titleDzikir.indices) {
            val data = DoaDzikirItem(
                titleDzikir[i],
                arabicDzikir[i],
                translateDzikir[i],
            )
            listData.add(data)
        }
        return listData
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}