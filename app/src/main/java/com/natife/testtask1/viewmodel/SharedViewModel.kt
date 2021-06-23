package com.natife.testtask1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natife.testtask1.data.Item
import com.natife.testtask1.utils.ItemHolder

class SharedViewModel : ViewModel() {
    private var _list = MutableLiveData<List<Item>>()
    val list = _list

    init {
        _list.postValue(ItemHolder.items)
    }
}
