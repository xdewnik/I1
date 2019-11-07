package com.coolya.i1.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.coolya.i1.ui.activity.MainActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomFragment<VB : ViewDataBinding> : BottomSheetDialogFragment() {

    protected abstract fun setLayoutId(): Int

    protected lateinit var viewBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, setLayoutId(), container, false)
        viewBinding.lifecycleOwner = this
        return viewBinding.root
    }
}