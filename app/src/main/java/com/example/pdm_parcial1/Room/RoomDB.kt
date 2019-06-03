package com.example.pdm_parcial1.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pdm_parcial1.Room.Daos.MatchDao
import com.example.pdm_parcial1.Room.Entities.MatchEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [MatchEntity::class],version = 1, exportSchema = false)
public abstract class RoomDB: RoomDatabase(){
    abstract fun matchDao() : MatchDao

    companion object{
        @Volatile
        private var INSTANCE : RoomDB? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "Match_DB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class DataBaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase( database.matchDao() )
                }
            }
        }
        suspend fun populateDatabase(
            matchDao: MatchDao
        ){
            var match1 = MatchEntity(
                "Partido Liceo vs Chaleco",
                "Liceo",
                20,
                "Chaleco",
                18,
                true)
        }
    }
}