package com.pall.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pall.doadzikirapp.DoaDzikirAdapter
import com.pall.doadzikirapp.R
import com.pall.doadzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import com.pall.doadzikirapp.databinding.ActivityQauliyahShalatBinding
import com.pall.doadzikirapp.model.DataDoaDzikir

class DzikirSetiapSaatActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirSetiapSaatBinding? = null
    private val binding get() = _binding as ActivityDzikirSetiapSaatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // show navigation button home
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // initialize property of _binding with layoutInflater to get the layout
        _binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        // replace argument of setContentView using viewBinding
        // this is for connect the view using view binding
        setContentView(binding.root)

        // set recyclerView
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikir())
        binding.rvDzikir.adapter = mAdapter
        // layoutManager is a class to set our structure of recyclerview to display dataset
        binding.rvDzikir.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}