package com.coolya.i1.ui.create.vm

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.coolya.i1.data.ToDo
import com.coolya.i1.ui.base.BaseViewModel
import com.coolya.i1.ui.create.data.CreateTodoRepository
import kotlinx.coroutines.launch

class CreateToDoViewModel(app: Application, private val repo: CreateTodoRepository) :
    BaseViewModel(app) {


    fun saveTodo(todo: ToDo) {
        viewModelScope.launch { repo.saveTodo(todo) }
    }

}