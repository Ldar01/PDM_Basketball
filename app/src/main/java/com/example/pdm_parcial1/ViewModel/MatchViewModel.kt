package com.example.pdm_parcial1.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdm_parcial1.Repository.MatchRepository
import com.example.pdm_parcial1.Room.Entities.MatchEntity
import com.example.pdm_parcial1.Room.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchViewModel(application: Application) : AndroidViewModel(application){
    private val repository : MatchRepository

    init {
        val matchDao = RoomDB.getInstance(application,viewModelScope).matchDao()
        repository = MatchRepository(matchDao)
    }

    fun allMatches() = repository.allMatches()
    fun getMatchByName(name: String) = repository.getMatchkByName(name)
    fun nuke() = repository.nuke()

    fun insertMatch(match : MatchEntity) = viewModelScope.launch ( Dispatchers.IO ){
        repository.insertMatch(match)
    }
}