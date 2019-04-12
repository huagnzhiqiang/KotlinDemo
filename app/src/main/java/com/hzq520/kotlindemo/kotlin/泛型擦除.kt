package com.hzq520.kotlindemo.kotlin

/**
 * @author 小强
 *
 * @time 2019/4/3  9:54
 *
 * @desc
 *
 */
fun main(args: Array<String>) {

    pareType(123)

}


inline fun <reified T> pareType(thing: T) {
    val type = T::class.java.name
    println(type)
}