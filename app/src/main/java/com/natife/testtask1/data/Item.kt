package com.natife.testtask1.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (
    val id: Int,
    val name: String,
    val description: String
        ) : Parcelable
