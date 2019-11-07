package com.coolya.i1.ui.create.data

import com.coolya.i1.data.ToDo

class CreateTodoRepository(private val local: CreateLocalDataSource) {


    suspend fun saveTodo(todo: ToDo) {
        local.saveTodo(todo)
    }


}