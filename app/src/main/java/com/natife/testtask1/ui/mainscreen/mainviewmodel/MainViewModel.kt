package com.natife.testtask1.ui.mainscreen.mainviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.natife.testtask1.data.Item
import com.natife.testtask1.utils.Const
import com.natife.testtask1.utils.ItemHolder
import com.natife.testtask1.utils.PreferenceHelper
import com.natife.testtask1.utils.PreferenceHelper.id

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var _list = MutableLiveData<List<Item>>()
    val list = _list

    init {
        _list.postValue(ItemHolder.items)
    }

    fun saveItemId(id: Int) {
        val preferences = PreferenceHelper.customPreference(
            getApplication<Application>().applicationContext,
            Const.CUSTOM_PREF_NAME
        )
        preferences.id = id
    }
}
