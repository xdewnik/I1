package com.coolya.i1.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                val title: String = "",
                val quantity: Int = 0,
                val type: String = "",
                val progress: Int = 0,
                val done: Boolean = false,
                val startTime: Long = 0,
                val endTime: Long= 0
                )