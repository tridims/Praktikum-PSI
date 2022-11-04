package com.dimastri.psirecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dimastri.psirecyclerview.R

class FragmentSecondary : Fragment(R.layout.fragment_secondary) {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_secondary, container, false);

    val courseViewModel = ViewModelProvider(this)[CourseViewModel::class.java]
    val rvCourse: RecyclerView = view.findViewById<RecyclerView>(R.id.list_class)
    val listCourseAdapter = ListCourseAdapter(courseViewModel.getListCourse())
    rvCourse.adapter = listCourseAdapter
    rvCourse.layoutManager = LinearLayoutManager(view.context)

    return view
  }

}