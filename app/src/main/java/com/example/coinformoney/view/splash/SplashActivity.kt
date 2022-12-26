package com.example.coinformoney.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import com.example.coinformoney.databinding.ActivitySplashBinding
import com.example.coinformoney.view.main.MainActivity


class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.checkFirstFlag()
        viewModel.first.observe(this, Observer {
            if(it){
                // 처음이 아닌 유저
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                // 처음 접속하는 유저
                binding.animationView.visibility = View.INVISIBLE
                binding.fragmentContainerView.visibility = View.VISIBLE
            }
        })

    }
}