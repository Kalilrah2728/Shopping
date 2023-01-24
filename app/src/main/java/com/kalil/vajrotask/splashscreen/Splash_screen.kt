package com.kalil.vajrotask.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kalil.vajrotask.R
import com.kalil.vajrotask.databinding.ActivitySplashScreenBinding
import com.kalil.vajrotask.productlist.ProductlistActivity
import com.kalil.vajrotask.splashscreen.viewmodel.SplashscreenviewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Splash_screen : AppCompatActivity() {

    lateinit var dataBinding: ActivitySplashScreenBinding
    lateinit var viewModel: SplashscreenviewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)
        viewModel = ViewModelProvider(this)[SplashscreenviewModel::class.java]
        dataBinding.apply {
            this.lifecycleOwner = this@Splash_screen
            this.splashviewmodel = viewModel
        }

        lifecycleScope.launch {
            delay(2000)
            loadActivity()
        }
    }



    private fun loadActivity() {
        startActivity(Intent(this@Splash_screen, ProductlistActivity::class.java))
        finish()
    }
}