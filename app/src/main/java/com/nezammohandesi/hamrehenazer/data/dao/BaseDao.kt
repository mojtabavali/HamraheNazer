package com.nezammohandesi.hamrehenazer.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 * Created by rahmati on 2/15/2018.
 */
interface BaseDao<T> {
    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     */
    @Insert
    fun insert(obj: T)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(obj: T)
    @Insert
    fun insert(obj: MutableList<T>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateList(vararg obj: T)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrIgnoreList(vararg obj: T)  /**
     * Insert an array of objects in the database.
     *
     * @param obj the objects to be inserted.
     */
    @Insert
    fun insert(vararg obj: T)
    @Delete
    fun deleteList(vararg obj: T)
    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    fun update(obj: T)

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */
    @Delete
    fun delete(obj: T)


    @Delete
    fun delete(vararg obj: T)
}