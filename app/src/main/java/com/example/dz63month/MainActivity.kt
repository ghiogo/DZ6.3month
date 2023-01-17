package com.example.dz63month

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dz63month.fragments.TextFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view,TextFragment())
            .commit()
    }
}