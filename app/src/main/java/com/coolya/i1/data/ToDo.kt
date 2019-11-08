package com.coolya.i1.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.coolya.i1.room.MyTypeConverter
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class ToDo(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                val title: String = "",
                val quantity: Int = 0,
                @TypeConverters(MyTypeConverter::class)
                val type: Type = Type(),
                var progress: Int = 0,
                var currentProgress: Int = 0,
                var done: Boolean = false,
                val startTime: Long = 0,
                val endTime: Long= 0
                ) : Parcelable