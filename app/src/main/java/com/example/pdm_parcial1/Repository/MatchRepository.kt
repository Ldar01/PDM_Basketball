package com.example.pdm_parcial1.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.pdm_parcial1.Room.Daos.MatchDao
import com.example.pdm_parcial1.Room.Entities.MatchEntity

class MatchRepository (private val matchDao: MatchDao){


    fun allMatches(): LiveData<List<MatchEntity>> = matchDao.getAll()

    //Funciones de MatchDao
    fun getMatchkByName(name: String) = matchDao.getByName(name)
    fun nuke() = matchDao.nuke()

    @WorkerThread
    suspend fun insertMatch(matchEntity: MatchEntity){
        matchDao.insert(matchEntity)
    }
}