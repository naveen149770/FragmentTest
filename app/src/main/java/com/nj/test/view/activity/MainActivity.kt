package com.nj.test.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nj.test.R
import com.nj.test.viewmodel.MainActivityVM

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityVM::class.java)
    }

}