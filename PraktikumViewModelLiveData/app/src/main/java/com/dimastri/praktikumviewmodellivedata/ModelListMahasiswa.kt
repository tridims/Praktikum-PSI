package com.dimastri.praktikumviewmodellivedata

class ModelListMahasiswa {
  private val listMahasiswa = mutableListOf<ModelMahasiswa>()

  init {
    listMahasiswa.add(ModelMahasiswa("Dimas Tri", "205150200111049", "Teknik Informatika"))
    listMahasiswa.add(ModelMahasiswa("Mustakim", "205150200111049", "Teknik Informatika"))
  }

  fun getList(): List<ModelMahasiswa> = listMahasiswa

  fun addMahasiswa(newItem: ModelMahasiswa) {
    listMahasiswa.add(newItem)
  }
}