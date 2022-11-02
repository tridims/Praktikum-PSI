package com.dimastri.praktikumviewmodellivedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class AdapterListMahasiswa (var listMahasiswa: LiveData<List<ModelMahasiswa>>) : RecyclerView.Adapter<AdapterListMahasiswa.ViewHolder>() {
  inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val mahasiswa = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
    return ViewHolder(mahasiswa)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.itemView.apply {
      findViewById<TextView>(R.id.nama).text = listMahasiswa.value?.get(position)?.nama
      findViewById<TextView>(R.id.nim).text = listMahasiswa.value?.get(position)?.nim
      findViewById<TextView>(R.id.prodi).text = listMahasiswa.value?.get(position)?.prodi
    }
  }

  override fun getItemCount(): Int {
    return listMahasiswa.value?.size?:0
  }
}