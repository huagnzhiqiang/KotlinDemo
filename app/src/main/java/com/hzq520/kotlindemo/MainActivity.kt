package com.hzq520.kotlindemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.hzq520.kotlindemo.base.BaseActivity
import com.hzq520.kotlindemo.mvp.Bean.TabEntity
import com.hzq520.kotlindemo.ui.fragment.HomeFragment
import com.hzq520.kotlindemo.ui.fragment.HotFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/**
 * @author 小强
 *
 * @time 2019/3/26  10:15
 *
 * @desc
 *
 */
class MainActivity : BaseActivity() {


    // 顶部滑动的标签栏
    private val mTitles = arrayOf("首页", "自营销", "我的作品", "我的")


    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.drawable.icon_home, R.drawable.icon_ziyingxiao, R.drawable.icon_zuopin, R.drawable.icon_me)

    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.drawable.icon_home_red, R.drawable.icon_ziyingxiao_red, R.drawable.icon_zuopin_red, R.drawable.icon_me_red)


    private val mTabEntities = ArrayList<CustomTabEntity>()


    private var mHomeFragment: HomeFragment? = null
    private var mHotFragment: HotFragment? = null


    //默认为0
    private var mIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex");
        }

        initTab()

        tab_layout.currentTab = mIndex

        switchFragment(mIndex)

    }

    /**
     * 加载布局
     */
    override fun layoutId(): Int = R.layout.activity_main


    /**
     * 初始化视图
     */
    override fun initView() {


    }

    private fun initTab() {


        //相当于java中的for设置
        (0 until mTitles.size).mapTo(mTabEntities) {
            TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it])
        }

        //同等于上面
//        for (i in 0 until mTitles.size) {
//            mTabEntities.add(TabEntity(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]))
//        }


        //为Tab赋值
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                //切换Fragment
                switchFragment(position)
            }


            override fun onTabReselect(position: Int) {

            }
        })

    }

    /**
     * 切换Fragment
     * @param position 下标
     */
    private fun switchFragment(position: Int) {

        val transition = supportFragmentManager.beginTransaction()
        hideFragment(transition)
        //相当于swith
        when (position) {

            //首页
            0 -> mHomeFragment?.let {
                transition.show(it)
            } ?: HomeFragment().let {
                mHomeFragment = it
                transition.add(R.id.fl_container, it)
            }


            //首页
            1 -> mHotFragment?.let {
                transition.show(it)
            } ?: HotFragment().let {
                mHotFragment = it
                transition.add(R.id.fl_container, it)
            }

            //首页
            2 -> mHotFragment?.let {
                transition.show(it)
            } ?: HotFragment().let {
                mHotFragment = it
                transition.add(R.id.fl_container, it)
            }

            //首页
            3 -> mHotFragment?.let {
                transition.show(it)
            } ?: HotFragment().let {
                mHotFragment = it
                transition.add(R.id.fl_container, it)
            }


        }

        mIndex = position
        tab_layout.currentTab = mIndex
        transition.commitAllowingStateLoss()

    }

    private fun hideFragment(transition: FragmentTransaction) {
        mHomeFragment?.let { transition.hide(it) }
        mHotFragment?.let { transition.hide(it) }

    }


    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
        if (tab_layout != null) {
            outState.putInt("currTabIndex", mIndex)
        }
    }

}


