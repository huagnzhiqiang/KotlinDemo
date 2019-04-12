package com.hzq520.kotlindemo.kotlin

/**
 * @author 小强
 *
 * @time 2019/4/3  15:19
 *
 * @desc
 *
 */


fun main(args: Array<String>) {

    SmallHeadFather1(BigHeadson1()).wash()


}


interface IWoshPower1 {
    fun wash()
}

class BigHeadson1 : IWoshPower1 {
    override fun wash() {
        println("大头儿子洗碗")
    }
}


//小头爸爸洗碗的能力委托给大头儿子

class SmallHeadFather1(var wash : BigHeadson1) : IWoshPower1 by wash