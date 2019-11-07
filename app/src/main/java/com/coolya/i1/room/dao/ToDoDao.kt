package com.coolya.i1.room.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.coolya.i1.data.ToDo

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(toDoList: List<ToDo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(toDo: ToDo)

    @Query("SELECT * FROM ToDo ORDER BY id DESC")
    fun getToDoList(): DataSource.Factory<Int, ToDo>

    @Query("SELECT * FROM ToDo WHERE id=:id")
    fun getById(id: Int): LiveData<ToDo>

    @Delete
    fun remove(todo: ToDo)

    @Update
    fun update(todo: ToDo)


}