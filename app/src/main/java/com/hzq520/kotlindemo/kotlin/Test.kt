package com.hzq520.kotlindemo.kotlin

/**
 * @author 小强
 *
 * @time 2019/3/29  15:44
 *
 * @desc
 *
 */

fun main(args: Array<String>) {



    //区间反转
    val rager = 1..100
    val rager1 = rager.reversed()

    val arnge = 100 downTo 1 //100到1

    //函数引用
    val addFun = ::addfun

    addFun(1, 1)

    addFun.invoke(1, 2)

    val arr = 0


    //函数变量
    val padd: (Int, Int) -> Int = { a, b -> 10 + 29 }// 匿名函数


    sendRequest(method = "10", path = "https://www.hzq.com")


    var i1 = { x: Int, y: Int -> x + y }

    var j1: (Int, Int) -> Int = { x, y -> x / y }

    print(son3(3))


    when (arr) {

        1 -> {
//            print("1")
        }

        2, 3, 4 -> {
//            print("2,3,4")
        }


        in 2..5 -> {

        }
        else -> {
//            print("else")

        }
    }


    val pair = "小强" to 20


    val s: String? = null


    val i = s?.toInt()


    val j: Int = s?.toInt() ?: -1

//
//    val string = "1232"
//
//
//    string.forEach {
//        print(it)
//    }


    val s1 = "abc"

    val s2 = "123"


    for (c in s1) {


        tag@ for (c1 in s2) {
//            println("c-->" + c + "--->" + "c1-->" + c1)


            if (c == 'b' && c1 == '2') {

                break@tag

            }


        }
    }

}

fun addfun(a: Int, b: Int): Int {

    return a + b

}


/**
 * 默认Method是get方式
 */
fun sendRequest(path: String, method: String = "GET") {


    println("paht=+ ${path},method= ${method}")

}


/**
 * 可变参数
 */
fun son(vararg a: Int): Int {

    var result = 0

    a.forEach {
        result += it
    }
    return result
}


/**
 * 递归
 */
fun son1(n: Int): Int {

    if (n == 1) {
        return 1
    } else {
        return n * son1(n - 1)
    }

}

/**
 * 斐波那契
 */
fun son2(n: Int): Int {

    //第一位和第二位都是1 所以返回的是1
    if (n == 1 || n == 2) {
        return 1
    } else {
        return son2(n - 1) + son2(n - 2)
    }

}


/**
 * 尾递归
 */
tailrec fun son3(n: Int, result: Int = 0): Int {

    if (n == 1) {
        return result + 1
    } else {
        return son3(n - 1, result + n)
    }

}
