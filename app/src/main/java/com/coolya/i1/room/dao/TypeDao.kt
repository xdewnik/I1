package com.coolya.i1.room.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.coolya.i1.data.ToDo
import com.coolya.i1.data.Type


@Dao
interface TypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(type: Type)

    @Query("SELECT * FROM Type ORDER BY type ASC")
    fun getTypeList(): LiveData<List<Type>>

    @Delete
    fun remove(type: Type)

    @Update
    fun update(type: Type)
}