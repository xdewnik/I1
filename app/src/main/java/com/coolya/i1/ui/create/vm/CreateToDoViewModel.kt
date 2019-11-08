package com.coolya.i1.ui.create.vm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.coolya.i1.data.ToDo
import com.coolya.i1.data.Type
import com.coolya.i1.ui.base.BaseViewModel
import com.coolya.i1.ui.create.data.CreateTodoRepository
import kotlinx.coroutines.launch

class CreateToDoViewModel(app: Application, private val repo: CreateTodoRepository) :
    BaseViewModel(app) {


    val typeList: LiveData<List<Type>> = repo.getTypeList()

    fun saveTodo(todo: ToDo) {
        viewModelScope.launch { repo.saveTodo(todo) }
    }

    fun saveType(type: Type) {
        viewModelScope.launch { repo.saveType(type) }
    }

}