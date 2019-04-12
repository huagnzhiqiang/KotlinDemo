package com.hzq520.kotlindemo.mvp.Bean

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * @author 小强
 *
 * @time 2019/3/26  14:12
 *
 * @desc 底部实体类
 *
 */
class TabEntity(var title: String, var selectedIcon: Int, var unSelectedIcon: Int) : CustomTabEntity {


    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon

    }

    override fun getTabSelectedIcon(): Int {

        return selectedIcon
    }

    override fun getTabTitle(): String {

        return title
    }
}