package com.nezammohandesi.hamrehenazer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nezammohandesi.hamrehenazer.data.dao.ProjectDao
import com.nezammohandesi.hamrehenazer.data.model.TbProject

@Database(
    entities = [
        TbProject::class
    ],
    version = 1,
    exportSchema = false
)
abstract class NazerDb : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: NazerDb? = null
        @JvmStatic
        fun getDbName(context: Context): String {
            return "NazerDb"
        }
        fun getInstance(context: Context): NazerDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }
        private fun buildDatabase(context: Context): NazerDb {
            return Room.databaseBuilder(context, NazerDb::class.java, getDbName(context))
                .allowMainThreadQueries()
                .build()
        }
        fun resetInstance() {
            instance = null
        }



    }
    abstract fun ProjectDao(): ProjectDao
}