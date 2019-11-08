package com.coolya.i1.ui.progress.ui

import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import android.R.attr.start
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import android.animation.ValueAnimator
import androidx.appcompat.widget.AppCompatImageView
import com.coolya.i1.R


@BindingAdapter("number")
fun MaterialTextView.bindNumbarAnimation(number: Int) {
    val startNumber = if (text.isNotEmpty()) {
        text.toString().toInt()
    } else {
        0
    }
    val animator = ValueAnimator.ofInt(startNumber, number)
    animator.duration = 1000
    animator.addUpdateListener { animation -> this.text = animation.animatedValue.toString() }
    animator.start()
}

@BindingAdapter("done_background")
fun AppCompatImageView.changeBackground(isDone: Boolean){
    if(isDone){
        setBackgroundResource(R.drawable.done)
    }else{
        setBackgroundResource(R.drawable.notdone)
    }
}