package com.hzq520.kotlindemo.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * @author 小强
 *
 * @time 2019/4/11  14:45
 *
 * @desc
 *
 */
class BaseFragmentAdapter : FragmentStatePagerAdapter {


    private var fragmentList: List<Fragment>? = ArrayList()

    private var mTitle: List<String>? = null

    constructor(fm: FragmentManager?, fragmentList: List<Fragment>?, mTitle: List<String>?) : super(fm) {
        setFragments(fm, fragmentList, mTitle)
    }


    //刷新fragment
    private fun setFragments(fm: FragmentManager?, fragments: List<Fragment>?, mTitles: List<String>?) {
        this.mTitle = mTitles
        if (this.fragmentList != null) {
            val ft = fm?.beginTransaction()
            for (f in this.fragmentList ?: ArrayList()) {
                ft?.remove(f)
            }
            ft!!.commitAllowingStateLoss()
            fm.executePendingTransactions()
        }
        this.fragmentList = fragments
        notifyDataSetChanged()
    }


    override fun getItem(position: Int): Fragment {
        return fragmentList!![position]
    }

    override fun getCount() = fragmentList?.size ?: 0
}