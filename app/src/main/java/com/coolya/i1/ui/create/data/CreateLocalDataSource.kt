package com.coolya.i1.ui.create.data

import com.coolya.i1.data.ToDo
import com.coolya.i1.room.I1Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CreateLocalDataSource(private val db: I1Room) {


    suspend fun saveTodo(todo:ToDo){
        withContext(Dispatchers.IO){
            db.toDoDao().insert(todo)
        }
    }

}