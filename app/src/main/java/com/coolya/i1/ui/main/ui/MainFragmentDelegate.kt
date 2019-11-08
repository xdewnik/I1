package com.coolya.i1.ui.main.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import com.coolya.i1.R
import com.coolya.i1.data.ToDo
import com.coolya.i1.ui.main.adapter.ToDoAdapter
import com.coolya.i1.ui.main.vm.MainViewModel
import timber.log.Timber

class MainFragmentDelegate(
    val viewModel: MainViewModel,
    val adapter: ToDoAdapter,
    val navigation: NavController
) {


    fun onTodoClick(todo: ToDo) {
        navigation.navigate(
            R.id.action_mainFragment_to_progressFragment,
            Bundle().apply { putParcelable("todo", todo) })
    }

    fun createTodoPage(view: View) {
        navigation.navigate(R.id.action_mainFragment_to_createTodoFragment)
    }

}