package com.coolya.i1.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.coolya.i1.ui.activity.MainActivity

abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {

    protected abstract fun setAppBarTitle(): String?

    protected abstract fun setLayoutId(): Int

    protected lateinit var viewBinding: VB


    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, setLayoutId(), container, false)
        viewBinding.lifecycleOwner = this
        (activity as MainActivity)?.let { it.supportActionBar?.let { it.title = setAppBarTitle() } }
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}