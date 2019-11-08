package com.coolya.i1.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coolya.i1.R
import com.coolya.i1.databinding.ActivityMainBinding
import com.coolya.i1.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getNavigationGraph(): Int = R.navigation.main_navigation

    override fun getNavHostFragment(): Int = R.id.main_navigation





}