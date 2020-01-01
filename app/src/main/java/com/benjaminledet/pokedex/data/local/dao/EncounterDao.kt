package com.benjaminledet.pokedex.data.local.dao


import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.benjaminledet.pokedex.data.model.Encounter

@Dao
abstract class EncounterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(data: List<Encounter>): List<Long>

    @Delete
    abstract suspend fun delete(data: List<Encounter>)

    @Query("DELETE FROM ${Encounter.TABLE_NAME}")
    abstract suspend fun deleteAll()

    @Query("SELECT * FROM ${Encounter.TABLE_NAME} WHERE ${Encounter.ID} = :id")
    abstract suspend fun getById(id: Int?): Encounter?

    @Query("SELECT * FROM ${Encounter.TABLE_NAME} WHERE ${Encounter.ID} = :id")
    abstract fun getByIdObservable(id: Int?): LiveData<Encounter?>

    @Query("SELECT * FROM ${Encounter.TABLE_NAME}")
    abstract suspend fun getAll(): List<Encounter>

    @Query("SELECT * FROM ${Encounter.TABLE_NAME} WHERE ${Encounter.NAME} in (:names)")
    abstract fun getAllObservable(names:List<String>): LiveData<List<Encounter>>

    @Query("SELECT * FROM ${Encounter.TABLE_NAME}")
    abstract fun getAllPaged(): DataSource.Factory<Int, Encounter>
}