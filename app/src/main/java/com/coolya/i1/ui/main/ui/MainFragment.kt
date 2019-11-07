package com.coolya.i1.ui.main.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.coolya.i1.R
import com.coolya.i1.databinding.FragmentMainBinding
import com.coolya.i1.ui.base.BaseFragment
import com.coolya.i1.ui.main.adapter.ToDoAdapter
import com.coolya.i1.ui.main.vm.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun setAppBarTitle(): String? = "i1 todos"

    override fun setLayoutId(): Int = R.layout.fragment_main

    val viewModel by viewModel<MainViewModel> { parametersOf(this@MainFragment) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.delegate = MainFragmentDelegate(viewModel, ToDoAdapter(), findNavController())
    }
}