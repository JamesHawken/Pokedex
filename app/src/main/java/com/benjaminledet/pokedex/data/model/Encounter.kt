package com.benjaminledet.pokedex.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Encounter.TABLE_NAME)

data class Encounter(

    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Int,

    @ColumnInfo(name = NAME)
    val name: String,

    @ColumnInfo(name = ORDER)
    val order: Int,

    @ColumnInfo(name = NAMES)
    val names: List<String>



) {

    override fun toString(): String = name

    companion object {

        const val TABLE_NAME = "Encounter"
        const val ID = "id"
        const val NAME = "name"
        const val ORDER ="order"
        const val NAMES ="names"

    }
}