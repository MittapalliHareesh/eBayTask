package com.adevinta.ebay.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adevinta.ebay.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}