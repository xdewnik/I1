package com.coolya.i1.ui.main.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.coolya.i1.data.ToDo
import com.coolya.i1.platform.toPagedList
import com.coolya.i1.room.I1Room

class MainLocalDataSource(private val db: I1Room) {

    fun fetchPagedListFromDb(): LiveData<PagedList<ToDo>> {
        return db.toDoDao().getToDoList().toPagedList()
    }

    fun removeFromDb(toDo: ToDo){
        db.toDoDao().remove(toDo)
    }

}