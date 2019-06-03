package com.example.pdm_parcial1.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MatchTable")
data class MatchEntity (

    @ColumnInfo(name = "match")
    var MatchName: String = "N/A",
    @ColumnInfo(name = "teamA")
    var TeamA: String = "N/A",
    @ColumnInfo(name = "scoreTeamA")
    var ScoreTeamA: Int = 0,
    @ColumnInfo(name = "teamB")
    var TeamB: String = "N/A",
    @ColumnInfo(name = "scoreTeamB")
    var ScoreTeamB: Int = 0
){
    @PrimaryKey(autoGenerate = true)
    val _id : Int = 0
}
