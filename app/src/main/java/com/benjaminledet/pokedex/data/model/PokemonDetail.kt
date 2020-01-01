package com.benjaminledet.pokedex.data.model

import androidx.room.ColumnInfo

data class PokemonDetail(

    @ColumnInfo(name = WEIGHT)
    val weight: Double,

    @ColumnInfo(name = HEIGHT)
    val height: Double,

    @ColumnInfo(name = BASE_EXPERIENCE)
    val base_experience: String,

    @ColumnInfo(name = TYPES)
    val types: List<String>,
    val moves: List <String>,

    @ColumnInfo(name= ENCOUNTERS)
    val encounters: List<String>
) {

    companion object {
        const val WEIGHT = "weight"
        const val HEIGHT = "height"
        const val TYPES = "types"
        const val BASE_EXPERIENCE = "base_experience"
        const val ENCOUNTERS = "encounters"
    }
}