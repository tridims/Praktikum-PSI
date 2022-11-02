package com.dimastri.praktikumviewmodellivedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModelMahasiswa : ViewModel() {
  private val listMahasiswa = ModelListMahasiswa()
  private val lvListMahasiswa = MutableLiveData<List<ModelMahasiswa>>()

  fun getListMahasiswa(): LiveData<List<ModelMahasiswa>> {
    lvListMahasiswa.value = listMahasiswa.getList()
    return lvListMahasiswa
  }

  fun addList(newItem: ModelMahasiswa) {
    listMahasiswa.addMahasiswa(newItem)
    lvListMahasiswa.value = listMahasiswa.getList()
  }
}