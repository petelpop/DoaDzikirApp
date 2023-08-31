package com.pall.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pall.doadzikirapp.DoaDzikirAdapter
import com.pall.doadzikirapp.R
import com.pall.doadzikirapp.databinding.ActivityQauliyahShalatBinding
import com.pall.doadzikirapp.model.DataDoaDzikir

class QauliyahShalatActivity : AppCompatActivity() {

    private var _binding: ActivityQauliyahShalatBinding? = null
    private val binding get() = _binding as ActivityQauliyahShalatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // show navigation button home
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // initialize property of _binding with layoutInflater to get the layout
        _binding = ActivityQauliyahShalatBinding.inflate(layoutInflater)
        // replace argument of setContentView using viewBinding
        // this is for connect the view using view binding
        setContentView(binding.root)

        // set recyclerView
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDataQauliyah)
        binding.rvQauliyahShalat.adapter = mAdapter
        // layoutManager is a class to set our structure of recyclerview to display dataset
        binding.rvQauliyahShalat.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}