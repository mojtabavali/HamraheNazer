package com.nezammohandesi.hamrehenazer.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.nezammohandesi.hamrehenazer.data.model.TbProject

@Dao
interface ProjectDao: BaseDao<TbProject> {

    @Query("Select * from TB_PROJECT where TB_PROJECT.ID=:id ")
    fun getProjectWithId(id:Int): TbProject
    @Query("Select * from TB_PROJECT where TB_PROJECT.TYPE=:type ")
    fun getProjectWithType(type:Int): List<TbProject>?
    @Query("DELETE from TB_PROJECT where TB_PROJECT.ID=:id ")
    fun deleteProjectWithId(id:Int)
}