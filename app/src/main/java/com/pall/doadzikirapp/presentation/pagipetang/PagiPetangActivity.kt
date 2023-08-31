package com.pall.doadzikirapp.presentation.pagipetang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.pall.doadzikirapp.R

class PagiPetangActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagi_petang)

        val btnPagi = findViewById<ImageButton>(R.id.img_btn_pagi)
        val btnPetang = findViewById<ImageButton>(R.id.img_btn_petang)

        btnPagi.setOnClickListener(this)
        btnPetang.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.img_btn_pagi -> startActivity(Intent(this, PagiActivity::class.java))
            R.id.img_btn_petang -> startActivity(Intent(this, PetangActivity::class.java))

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}