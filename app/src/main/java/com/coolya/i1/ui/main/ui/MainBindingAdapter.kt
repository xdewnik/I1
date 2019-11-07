package com.coolya.i1.ui.main.ui

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.coolya.i1.data.ToDo
import com.coolya.i1.ui.main.adapter.OnTodoClick
import com.coolya.i1.ui.main.adapter.ToDoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("adapter", "todoList", "onTodoClick", requireAll = false)
fun RecyclerView.bindTodoList(
    outputAdapter: ToDoAdapter,
    data: PagedList<ToDo>?,
    onTodoClick: OnTodoClick
) {
    if (adapter == null) {
        outputAdapter.onTodoClick = onTodoClick
        adapter = outputAdapter
    }
    data?.let {
        with(this.adapter as ToDoAdapter) {
            submitList(it)
        }
    }
}

@BindingAdapter("onClick")
fun FloatingActionButton.bindOnClick(onClickListener: View.OnClickListener) {
    this.setOnClickListener(onClickListener)
}