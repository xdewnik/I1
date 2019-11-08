package com.coolya.i1.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Type(
    @PrimaryKey var type: String = ""
) : Parcelable {

    override fun toString(): String {
        return type
    }
}