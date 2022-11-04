package com.dimastri.psirecyclerview

import com.dimastri.psirecyclerview.R

class ListCourse {
  private val listCourse = mutableListOf<Course>()

  init {
    listCourse.add(Course("Physics", "Discovery of Light Spectrum", "By Mr. Albert Einstein", "99+ Members Joined", "18 Sep | 2.00 PM", R.drawable.albert))
    listCourse.add(Course("Mathematics", "The Collatz conjecture", "By Mr. Armstrong, J. Scott", "50 Members Joined", "19 Oct | 3.00 PM", R.drawable.math))
    listCourse.add(Course("Chemistry", "High-temperature Superconductors", "By Mr. Ayers, Bill", "99 Members Joined", "20 Nov | 4.00 PM", R.drawable.chemist))
    listCourse.add(Course("English", "100+ Hardest Words", "By Mr. Albright, Madeleine", "9 Members Joined", "11 Dec | 5.00 PM", R.drawable.english))
    listCourse.add(Course("German", "Going Native", "By Mr. Tobias Wolff", "10 Members Joined", "12 Jan | 6.00 PM", R.drawable.german))
  }

  fun getList(): List<Course> = listCourse
}