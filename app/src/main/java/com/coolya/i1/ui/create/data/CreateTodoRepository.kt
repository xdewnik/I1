package com.coolya.i1.ui.create.data

import androidx.lifecycle.LiveData
import com.coolya.i1.data.ToDo
import com.coolya.i1.data.Type

class CreateTodoRepository(private val local: CreateLocalDataSource) {


    suspend fun saveTodo(todo: ToDo) {
        local.saveTodo(todo)
    }

    fun getTypeList(): LiveData<List<Type>> {
        return local.getTypeList()
    }

    suspend fun saveType(type: Type) {
        local.saveType(type)
    }


}