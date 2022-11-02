package com.dimastri.praktikumviewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val viewModel = ViewModelProvider(this)[ViewModelMahasiswa::class.java]
    val adapter = AdapterListMahasiswa(viewModel.getListMahasiswa())
    val rvMahasiswa = findViewById<RecyclerView>(R.id.list_mahasiswa)
    rvMahasiswa.adapter = adapter
    rvMahasiswa.layoutManager = LinearLayoutManager(this)

    val btnTambah: Button = findViewById<Button>(R.id.btnTambah)

    btnTambah.setOnClickListener() {
      val tvNama = findViewById<TextView>(R.id.inputNama)
      val tvNim = findViewById<TextView>(R.id.inputNim)
      val tvProdi = findViewById<TextView>(R.id.inputProdi)

      val nama = tvNama.text.toString()
      val nim = tvNim.text.toString()
      val prodi = tvProdi.text.toString()

      viewModel.addList(ModelMahasiswa(nama, nim, prodi))
      rvMahasiswa.adapter = adapter
      rvMahasiswa.layoutManager = LinearLayoutManager(this)

      tvNama.text = ""
      tvNim.text = ""
      tvProdi.text = ""

      Toast.makeText(this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()

      tvNama.clearFocus()
      tvNim.clearFocus()
      tvProdi.clearFocus()
    }
  }
}