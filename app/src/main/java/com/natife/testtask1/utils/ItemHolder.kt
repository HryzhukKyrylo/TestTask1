package com.natife.testtask1.utils

import com.natife.testtask1.data.Item

/**
 *@author admin
 */
object ItemHolder {

    val items by lazy {
        (0 until 20).map { i ->
            Item(
                id = i,
                name = "name$i",
                description = "description$i"
            )
        }
    }
}
