package com.pall.doadzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.card.MaterialCardView
import com.pall.doadzikirapp.databinding.ActivityMainBinding
import com.pall.doadzikirapp.presentation.DzikirHarianActivity
import com.pall.doadzikirapp.presentation.DzikirSetiapSaatActivity
import com.pall.doadzikirapp.presentation.pagipetang.PagiPetangActivity
import com.pall.doadzikirapp.presentation.QauliyahShalatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // this method is from dependencies splash screen API 12
        installSplashScreen()
        // setContentView is use to choose or display layout in activity
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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