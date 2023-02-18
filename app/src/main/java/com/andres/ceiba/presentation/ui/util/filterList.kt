package com.andres.ceiba.presentation.ui.util

fun <T> List<T>.filterList(
    value: String,
    search: (T) -> Boolean,
): List<T> {
    return if (value.isEmpty()) {
        this
    } else {
        val resultList = mutableListOf<T>()
        for (option in this) {
            if (search.invoke(option)) resultList.add(option)
        }
        resultList
    }
}