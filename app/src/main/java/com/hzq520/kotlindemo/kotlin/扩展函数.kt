package com.hzq520.kotlindemo.kotlin.扩展函数

/**
 * @author 小强
 *
 * @time 2019/4/3  17:04
 *
 * @desc
 *
 */


fun main(args: Array<String>) {


    var str: String? = null
    var newString = str.isEmpty()

    println(newString)

}


fun String?.isEmpty(): Boolean {

    return this == null || this.length == 0
}

