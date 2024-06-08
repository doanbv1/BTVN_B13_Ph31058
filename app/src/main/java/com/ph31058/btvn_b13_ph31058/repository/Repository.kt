package com.ph31058.btvn_b13_ph31058.repository

import com.ph31058.btvn_b13_ph31058.room.StudentEntity
import com.ph31058.btvn_b13_ph31058.room.StudentsDB

class Repository(val studentsDB: StudentsDB) {
    suspend fun addStudentToRoom(studentEntity: StudentEntity){
        studentsDB.studentDao().addStudent(studentEntity)
    }

    fun getAllStudents() = studentsDB.studentDao().getALlStudents()

    suspend fun deleteStudentFromRoom(studentEntity: StudentEntity) {
        studentsDB.studentDao().deleteStudent(studentEntity)
    }

    suspend fun updateStudent(studentEntity: StudentEntity){
        studentsDB.studentDao().updateStudent(studentEntity)
    }
}