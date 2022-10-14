package com.dimastri.praktikumpsifragment

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentSecondary : Fragment(R.layout.fragment_secondary) {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_secondary, container, false);
    val listCourse = ArrayList<Course>()
    val listCategory = view.resources.getStringArray(R.array.course)
    val listLecturer = view.resources.getStringArray(R.array.lecturer)
    val listActivities = view.resources.getStringArray(R.array.activities)
    val listTimes = view.resources.getStringArray(R.array.times)
    val classmate = view.resources.getText(R.string.members_maincard).toString()
    for (i in 0..4) {
      listCourse.add(Course(
        listCategory[i],
        listActivities[i],
        listLecturer[i],
        classmate,
        listTimes[i]
      ))
    }

    val rvCourse: RecyclerView = view.findViewById<RecyclerView>(R.id.list_class)
    val listCourseAdapter = ListCourseAdapter(listCourse)
    rvCourse.adapter = listCourseAdapter
    rvCourse.layoutManager = LinearLayoutManager(view.context)

    return view
  }

}