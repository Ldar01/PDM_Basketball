package com.example.pdm_parcial1.Room.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pdm_parcial1.Room.Entities.MatchEntity

@Dao
interface MatchDao {

    @Query("SELECT * FROM MatchTable")
    fun getAll(): LiveData<List<MatchEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(table: MatchEntity)

    @Query("DELETE FROM MatchTable")
    fun nuke()

    @Query("SELECT * FROM MatchTable WHERE matchName = :name")
    fun getByName(name: String) : LiveData<MatchEntity>
}