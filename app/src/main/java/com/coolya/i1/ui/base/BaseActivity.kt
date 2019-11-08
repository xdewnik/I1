package com.coolya.i1.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController


abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {

    protected abstract fun getLayoutId(): Int

    protected lateinit var viewBinding: VB

    protected abstract fun getNavigationGraph(): Int

    protected abstract fun getNavHostFragment(): Int


    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, getLayoutId())

        Navigation.findNavController(this, getNavHostFragment()).apply {
            setGraph(getNavigationGraph())
        }

        setupActionBarWithNavController(this, findNavController(getNavHostFragment()))
        onActivityCreated(savedInstanceState)

    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, getNavHostFragment()).navigateUp()
    }

    fun navigateTo(action: Int) {
        Navigation.findNavController(this, getNavHostFragment()).navigate(action)
    }

    open fun onActivityCreated(savedInstanceState: Bundle?) {
    }


}