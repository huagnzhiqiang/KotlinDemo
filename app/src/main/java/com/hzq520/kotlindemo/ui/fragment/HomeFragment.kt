package com.hzq520.kotlindemo.ui.fragment

import android.support.v4.app.Fragment
import com.hzq520.kotlindemo.R
import com.hzq520.kotlindemo.base.BaseFragment
import com.hzq520.kotlindemo.base.BaseFragmentAdapter
import com.hzq520.kotlindemo.mvp.view.CaseFrgment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @author 小强
 *
 * @time 2019/3/26  14:28
 *
 * @desc 首页
 *
 */
class HomeFragment : BaseFragment() {

    val fragmentList = mutableListOf<Fragment>()

    val mTitleList = listOf("案例", "素材", "模板", "定制")


    /** 加载布局 */
    override fun getLayoutId() = R.layout.fragment_home

    /**
     * 初始化 ViewI
     */
    override fun initView() {

        fragmentList.add(CaseFrgment())
        fragmentList.add(HotFragment())
        fragmentList.add(HotFragment())
        fragmentList.add(HotFragment())

        viewPager.adapter = BaseFragmentAdapter(childFragmentManager, fragmentList, mTitleList)
        viewPager.currentItem = 0
        viewPager.offscreenPageLimit = 4

        tab_layout.setViewPager(viewPager, mTitleList.toTypedArray())

    }

    /**
     * 懒加载
     */
    override fun lazyLoad() {
    }


}