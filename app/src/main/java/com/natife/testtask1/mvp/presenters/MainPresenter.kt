package com.natife.testtask1.mvp.presenters

import android.content.SharedPreferences
import com.natife.testtask1.mvp.views.MainView
import com.natife.testtask1.utils.ItemHolder
import com.natife.testtask1.utils.PreferenceHelper.id

class MainPresenter {

    private var view: MainView? = null

    fun attach(view: MainView) {
        this.view = view
    }

    fun requestList() {
        val list = ItemHolder.items
        view?.showList(list)
    }

    fun detach() {
        view = null
    }

    fun saveId(preferences: SharedPreferences, id: Int) {
        preferences.id = id
    }
}
