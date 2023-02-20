package com.andres.ceiba.data.utils

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

object Utils {

    fun readJsonFile(fileName: String): String {
        var inputStream: InputStream? = null
        try {
            inputStream =
                javaClass.classLoader?.getResourceAsStream(fileName)
            val builder = StringBuilder()
            val reader = BufferedReader(InputStreamReader(inputStream))
            var str: String? = reader.readLine()
            while (str != null) {
                builder.append(str)
                str = reader.readLine()
            }
            return builder.toString()
        } finally {
            inputStream?.close()
        }
    }

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
}