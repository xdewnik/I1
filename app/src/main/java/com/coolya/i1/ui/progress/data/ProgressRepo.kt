package com.coolya.i1.ui.progress.data

import androidx.lifecycle.LiveData
import com.coolya.i1.data.ToDo

class ProgressRepo(private val local: ProgressLocalDataSource)  {
    fun getTodo(id: Int): LiveData<ToDo> {
        return local.getTodo(id)
    }

    suspend fun updateTodo(todo: ToDo?) {
        local.updateTodo(todo)
    }
}