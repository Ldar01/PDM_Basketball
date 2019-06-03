package com.example.pdm_parcial1.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MatchTable")
data class MatchEntity (

    @ColumnInfo(name = "matchName")
    var MatchName: String = "N/A",

    @ColumnInfo(name = "teamA")
    var TeamA: String = "N/A",

    @ColumnInfo(name = "scoreTeamA")
    var ScoreTeamA: Int = 0,

    @ColumnInfo(name = "teamB")
    var TeamB: String = "N/A",

    @ColumnInfo(name = "scoreTeamB")
    var ScoreTeamB: Int = 0,

    @ColumnInfo(name = "finished")
    var Finished : Boolean = false
){
    @PrimaryKey(autoGenerate = true)
    var id_match : Int = 0
}
