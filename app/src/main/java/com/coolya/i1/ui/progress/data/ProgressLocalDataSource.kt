package com.coolya.i1.ui.progress.data

import androidx.lifecycle.LiveData
import com.coolya.i1.data.ToDo
import com.coolya.i1.room.I1Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProgressLocalDataSource(private val db: I1Room) {
    fun getTodo(id: Int): LiveData<ToDo> {
        return db.toDoDao().getById(id)
    }

    suspend fun updateTodo(todo: ToDo?) {
        withContext(Dispatchers.IO) {
            db.toDoDao().update(todo!!)
        }
    }
}