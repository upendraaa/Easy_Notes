package com.d4static.easeme.listener


interface ItemListener {

    fun <T : Any> onClickItem(item: T)
}