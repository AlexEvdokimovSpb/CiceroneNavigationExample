package com.umbrellait.geekbrainsnavigation.utils

import kotlin.random.Random

object Mock {

    fun getStringList(): List<String> {
        val result: ArrayList<String> = arrayListOf()

        repeat(Random.nextInt(15, 20)) {
            result.add("Item $it")
        }
        return result
    }

}