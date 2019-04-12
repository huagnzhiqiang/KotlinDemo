
package com.hzq520.kotlindemo.kotlin

/**
 * @author 小强
 *
 * @time 2019/4/2  14:59
 *
 * @desc
 *
 */


fun main(args: Array<String>) {


    var s = son("小强",16,"12312321")

    s.name
}


class son(var name: String,var age: Int) {

    init {

    }


    constructor(  name: String, age: Int, phone:String):this(name,age)

}