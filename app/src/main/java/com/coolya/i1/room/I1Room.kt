package com.coolya.i1.room

import androidx.room.*
import androidx.room.TypeConverter
import com.coolya.i1.data.ToDo
import com.coolya.i1.data.Type
import com.coolya.i1.room.dao.ToDoDao
import com.coolya.i1.room.dao.TypeDao
import com.google.gson.Gson
import org.koin.dsl.module
import java.util.Arrays.asList


@Database(entities = [ToDo::class, Type::class], version = 1)
@TypeConverters(MyTypeConverter::class)
abstract class I1Room : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
    abstract fun typeDao(): TypeDao
}

val DBModule = module {
    single {
        Room.databaseBuilder(get(), I1Room::class.java, "i1_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}

class MyTypeConverter {

    @TypeConverter
    fun fromObject(value: Type): String {
        return value.toString()
    }

    @TypeConverter
    fun toObject(date: String): Type {
        return Type(date)
    }

}