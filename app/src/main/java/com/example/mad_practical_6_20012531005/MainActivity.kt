package com.example.mad_practical_6_20012531005

import android.content.Intent
import android.media.MediaController2
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.widget.VideoView
import android.widget.MediaController
import androidx.core.view.WindowCompat
import com.example.mad_practical_6_20012531005.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        binding.btnSwitch.setOnClickListener {
            Intent(this,YoutubeActivity::class.java).also {
                startActivity(it)
            }
        }

    }
    private fun initVideoPlayer(){
        val mediaController = MediaController(this)
        val uri: Uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.thestoryoflight)
        binding.myvideoview.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myvideoview)
        binding.myvideoview.setVideoURI(uri)
        binding.myvideoview.requestFocus()
        binding.myvideoview.start()
    }

}

