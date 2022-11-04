package com.dimastri.psirecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.dimastri.psirecyclerview.R


class ListCourseAdapter(var listCourse: LiveData<List<Course>>) : RecyclerView.Adapter<ListCourseAdapter.ListViewHolder>() {
  inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvCategory: TextView = itemView.findViewById(R.id.Category)
    var tvName: TextView = itemView.findViewById(R.id.course)
    var tvLecturer: TextView = itemView.findViewById(R.id.instructor)
    var tvClassmates: TextView = itemView.findViewById(R.id.classmates)
    var tvTime: TextView = itemView.findViewById(R.id.time)
    var joinBtn: Button = itemView.findViewById(R.id.join_button)
    var courseImage: ImageView = itemView.findViewById(R.id.course_image)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.course_card, parent, false)
    return ListViewHolder(view)
  }

  override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
    val (category, name, lecturer, classmates, time, image) = listCourse.value?.get(position)!!

    holder.tvCategory.text = category
    holder.tvName.text = name
    holder.tvLecturer.text = lecturer
    holder.tvClassmates.text = classmates
    holder.tvTime.text = time
    holder.courseImage.setImageResource(image)

    // click listener
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

    holder.courseImage.setOnClickListener {
      Toast.makeText(holder.itemView.context, "Clicked $name", Toast.LENGTH_SHORT).show()
    }
  }

  override fun getItemCount(): Int = listCourse.value?.size?:0
}