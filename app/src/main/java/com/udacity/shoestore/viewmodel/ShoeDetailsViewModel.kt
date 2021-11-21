package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailsViewModel: ViewModel() {

    var shoe = Shoe()

    private val shoeList: MutableList<Shoe> = ArrayList()

    private val _shoeListLiveData = MutableLiveData<List<Shoe>>()
    val shoeListLiveData: LiveData<List<Shoe>>
        get() = _shoeListLiveData

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        _shoeListLiveData.value = shoeList
    }

    fun clearData() {
        shoeList.clear()
    }
}