package com.example.coinformoney.view.main

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coinformoney.R
import com.example.coinformoney.databinding.ActivityMainBinding
import com.example.coinformoney.service.PriceForegroundService


class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.setting.setOnClickListener {
            showDialog()
        }

        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragmentContainerView)

        bottomNavigationView.setupWithNavController(navController)

    }
    private fun showDialog() {


        // custom_dialog를 뷰 객체로 반환
        val dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)

        // 대화상자 생성
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)



//         대화상자 띄움
        val alertDialog = builder.show()
        val backBtn = alertDialog.findViewById<ImageView>(R.id.backBtn)
        val startBtn = alertDialog.findViewById<ConstraintLayout>(R.id.startForeground)
        val stopBtn = alertDialog.findViewById<ConstraintLayout>(R.id.stopForeground)

        backBtn.setOnClickListener {
            alertDialog.dismiss()
        }
        startBtn.setOnClickListener {
            val intent = Intent(this, PriceForegroundService::class.java)
            intent.action = "START"
            startService(intent)
            alertDialog.dismiss()

        }

        stopBtn.setOnClickListener {
            val intent = Intent(this, PriceForegroundService::class.java)
            intent.action = "STOP"
            startService(intent)
            alertDialog.dismiss()

        }
    }

}