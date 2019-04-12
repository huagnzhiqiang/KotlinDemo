package com.hzq520.kotlindemo.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.classic.common.MultipleStatusView

/**
 * @author 小强
 *
 * @time 2019/3/26  11:28
 *
 * @desc 基类
 *
 */
abstract class BaseActivity : AppCompatActivity() {

//    MultipleStatusView


    protected var multipleStatusView: MultipleStatusView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId())


        initView()

        initData()

        initStart()

        initListener()

    }


    /**
     * 加载布局
     */
    @LayoutRes
    abstract fun layoutId(): Int


    /**
     * 初始化视图
     */
    abstract fun initView()


    /**
     * 初始化数据
     */
    open fun initData(){}


    /**
     * 开始请求
     */
    open fun initStart(){}


    private fun initListener() {
        multipleStatusView?.setOnClickListener { initStart() }
    }
}