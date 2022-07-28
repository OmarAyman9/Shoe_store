package com.oa.shoestore.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oa.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private var _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    var added = MutableLiveData(false)

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    init {
        _shoesList.value?.add(Shoe("Shoe1", "Nike", "5", "Black Shoe"))
        _shoesList.value?.add(Shoe("Shoe2", "Puma", "6", "White Shoe"))
        _shoesList.value?.add(Shoe("Shoe3", "Adidas", "7", "Red Shoe"))
    }

    fun addToShoesList(shoe: Shoe) {
        _shoesList.value?.add(shoe)
        added.value = true
    }
    fun setAddedToFalse(){
     added.value=false
    }
}
