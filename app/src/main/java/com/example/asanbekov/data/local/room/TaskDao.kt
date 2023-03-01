package com.example.asanbekov.data.local.room

import androidx.room.*
import com.example.asanbekov.model.Task

@Dao
interface TaskDao {

    @Query("select * from task order by id desc")
    fun getAll(): List<Task>

    /*Save task*/
    @Insert
    fun insert(task: Task)

    /*Delete task*/
    @Delete
    fun delete(task: Task)

    /*Save task*/
    @Update
    fun update(task: Task)
}
