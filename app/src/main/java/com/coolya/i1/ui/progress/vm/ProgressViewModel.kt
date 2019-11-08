package com.coolya.i1.ui.progress.vm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.coolya.i1.data.ToDo
import com.coolya.i1.ui.base.BaseViewModel
import com.coolya.i1.ui.progress.data.ProgressRepo
import kotlinx.coroutines.launch

class ProgressViewModel(app: Application, private val repo: ProgressRepo, todoBundle: ToDo): BaseViewModel(app) {


    val todo: LiveData<ToDo>

    init {
        todo = repo.getTodo(todoBundle.id)
    }

    fun updateTodo(progress: Int){
        with(todo.value!!){
            this.progress = progress
            this.currentProgress = quantity * progress / 100
            this.done = progress == 100
        }
        viewModelScope.launch {
            repo.updateTodo(todo.value)
        }
    }
}