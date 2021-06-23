package com.natife.testtask1.ui.descriptionscreen.descriptionviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natife.testtask1.data.Item
import com.natife.testtask1.utils.ItemHolder

class DescriptionViewModel : ViewModel() {

    private val _item = MutableLiveData<Item>()
    val item = _item

    fun setId(id: Int) {
        _item.postValue(ItemHolder.items.firstOrNull { item -> item.id == id })
    }
}
