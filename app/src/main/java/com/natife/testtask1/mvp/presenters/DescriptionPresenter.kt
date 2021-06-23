package com.natife.testtask1.mvp.presenters

import com.natife.testtask1.mvp.views.DescriptionView
import com.natife.testtask1.utils.ItemHolder


class DescriptionPresenter {
    private var view: DescriptionView? = null

    fun attach(view: DescriptionView) {
        this.view = view
    }

    fun requestItem(idArg: Int) {
        val item = ItemHolder.items.firstOrNull { it.id == idArg }
        item?.also { view?.showItem(it) }
    }

    fun detach() {
        view = null
    }
}
