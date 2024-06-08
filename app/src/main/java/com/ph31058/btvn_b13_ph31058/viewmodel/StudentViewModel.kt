package com.ph31058.btvn_b13_ph31058.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ph31058.btvn_b13_ph31058.repository.Repository
import com.ph31058.btvn_b13_ph31058.room.StudentEntity
import kotlinx.coroutines.launch

class StudentViewModel(val repository: Repository): ViewModel() {

    fun addStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.addStudentToRoom(student)
        }
    }

    val students = repository.getAllStudents()

    fun deleteStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.deleteStudentFromRoom(student)
        }
    }

    fun updateStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.updateStudent(student)
        }
    }
}