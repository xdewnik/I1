package com.coolya.i1.ui.create.ui

import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import com.coolya.i1.R
import com.coolya.i1.data.Type
import timber.log.Timber

@BindingAdapter("typeList")
fun AppCompatSpinner.bindTypelist(typeList: List<Type>?) {
    typeList?.let {
        adapter = ArrayAdapter<Type>(
            this.context,
            R.layout.support_simple_spinner_dropdown_item,
            typeList
        )
    }

}

@BindingAdapter("onClick")
fun AppCompatImageView.bindOnClick(listener: View.OnClickListener) {
    setOnClickListener { Timber.d("click") }
}