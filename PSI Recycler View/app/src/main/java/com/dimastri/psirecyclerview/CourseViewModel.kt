package com.dimastri.psirecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CourseViewModel : ViewModel() {
  private val listCourse = ListCourse()
  private val lvListCourse = MutableLiveData<List<Course>>()

  fun getListCourse(): LiveData<List<Course>> {
    lvListCourse.value = listCourse.getList()
    return lvListCourse
  }
}