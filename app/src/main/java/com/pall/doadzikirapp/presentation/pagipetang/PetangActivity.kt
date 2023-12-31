package com.pall.doadzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pall.doadzikirapp.Adapter.DoaDzikirAdapter
import com.pall.doadzikirapp.R
import com.pall.doadzikirapp.databinding.ActivityPetangBinding
import com.pall.doadzikirapp.model.DataDoaDzikir

class PetangActivity : AppCompatActivity() {
    private var _binding: ActivityPetangBinding? = null
    private val binding get() = _binding as ActivityPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        // show navigation button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        _binding = ActivityPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikirPetang())
        binding.rvDzikirPetang.adapter = mAdapter
        binding.rvDzikirPetang.layoutManager = LinearLayoutManager(this)

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
