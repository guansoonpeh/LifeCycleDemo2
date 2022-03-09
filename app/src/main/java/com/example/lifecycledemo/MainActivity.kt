package com.example.lifecycledemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecycledemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var x : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("MainActivity", "onCreate")


        binding.tvResult.text = x.toString()

        binding.btnOk.setOnClickListener(){
            x += 1

            binding.tvResult.text = x.toString()
        }

        binding.btnSent.setOnClickListener(){
            val uri = Uri.parse("smsto:012345678")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "The SMS text")
            startActivity(intent)
//
//            val intent = Intent(Intent.ACTION_SEND)
//            intent.setType("text/plain")
//            intent.putExtra(Intent.EXTRA_TEXT, "The SMS text")
//            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }
}