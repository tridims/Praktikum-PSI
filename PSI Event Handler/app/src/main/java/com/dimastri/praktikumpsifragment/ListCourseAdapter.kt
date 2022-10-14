package com.dimastri.praktikumpsifragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ListCourseAdapter(private val listCourse: ArrayList<Course>) : RecyclerView.Adapter<ListCourseAdapter.ListViewHolder>() {
  inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvCategory: TextView = itemView.findViewById(R.id.Category)
    var tvName: TextView = itemView.findViewById(R.id.course)
    var tvLecturer: TextView = itemView.findViewById(R.id.instructor)
    var tvClassmates: TextView = itemView.findViewById(R.id.classmates)
    var tvTime: TextView = itemView.findViewById(R.id.time)
    var joinBtn: Button = itemView.findViewById(R.id.join_button)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.course_card, parent, false)
    return ListViewHolder(view)
  }

  override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
    val (category, name, lecturer, classmates, time) = listCourse[position]
    holder.tvCategory.text = category
    holder.tvName.text = name
    holder.tvLecturer.text = lecturer
    holder.tvClassmates.text = classmates
    holder.tvTime.text = time
    holder.joinBtn.setOnClickListener {
      when (holder.joinBtn.text) {
        holder.itemView.context.getString(R.string.join_class_button) -> {
          holder.joinBtn.setText(R.string.joined_class_button)
          Toast.makeText(holder.itemView.context, "Successfully joined $name", Toast.LENGTH_SHORT).show()
        }
        holder.itemView.context.getString(R.string.joined_class_button) -> {
          holder.joinBtn.setText(R.string.join_class_button)
          Toast.makeText(holder.itemView.context, "Canceled $name", Toast.LENGTH_SHORT).show()
        }
      }
    }
  }

  override fun getItemCount(): Int = listCourse.size
}