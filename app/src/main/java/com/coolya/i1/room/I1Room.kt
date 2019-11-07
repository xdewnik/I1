package com.coolya.i1.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.coolya.i1.data.ToDo
import com.coolya.i1.room.dao.ToDoDao
import org.koin.dsl.module

@Database(entities = arrayOf(ToDo::class), version = 1)
abstract class I1Room : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}

val DBModule = module {
    single {
        Room.databaseBuilder(get(), I1Room::class.java, "i1_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}