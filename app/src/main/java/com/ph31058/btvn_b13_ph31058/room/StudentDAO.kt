package com.ph31058.btvn_b13_ph31058.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDAO {

    @Insert
    suspend fun addStudent(studentEntity: StudentEntity)

    @Query("SELECT * FROM StudentEntity")
    fun getALlStudents(): Flow<List<StudentEntity>>

    @Delete
    suspend fun deleteStudent(studentEntity: StudentEntity)

    @Update
    suspend fun updateStudent(studentEntity: StudentEntity)
}