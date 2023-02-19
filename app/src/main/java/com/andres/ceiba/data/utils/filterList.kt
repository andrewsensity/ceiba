package com.andres.ceiba.data.utils

import com.google.gson.Gson

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

fun <A> String.fromJson(type: Class<A>): A = Gson().fromJson(this, type)

fun <A> A.toJson(): String? = Gson().toJson(this)