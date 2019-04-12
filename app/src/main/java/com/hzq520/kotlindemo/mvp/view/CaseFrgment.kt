package com.hzq520.kotlindemo.mvp.view

import android.support.v7.widget.LinearLayoutManager
import com.hzq520.kotlindemo.R
import com.hzq520.kotlindemo.adapter.CaseAdapter
import com.hzq520.kotlindemo.base.BaseFragment
import com.hzq520.kotlindemo.mvp.Bean.HomeEntity
import com.hzq520.kotlindemo.mvp.contract.CaseContract
import com.hzq520.kotlindemo.mvp.presenter.CasePresenter
import kotlinx.android.synthetic.main.fragment_case.*

/**
 * @author 小强
 *
 * @time 2019/4/11  15:28
 *
 * @desc 案例
 *
 */


class CaseFrgment : BaseFragment(), CaseContract.View {

    private val mPresenter by lazy { CasePresenter() }

    private var mCaseAdapter: CaseAdapter? = null

    /**
     * 加载布局
     */
    override fun getLayoutId(): Int = R.layout.fragment_case

    /**
     * 初始化 ViewI
     */
    override fun initView() {

        mPresenter.attachView(this)

    }

    /**
     * 懒加载
     */
    override fun lazyLoad() {
        mPresenter.requestHomeData(1, 12, "desc", "create_datetime")

    }


    /**
     * 设置第一次请求的数据
     */
    override fun setHomeData(homeBean: HomeEntity) {
        mCaseAdapter = CaseAdapter(homeBean.data?.rows)
        mRecyclerView.layoutManager = linearLayoutManager
        mRecyclerView.adapter = mCaseAdapter

    }


    private val linearLayoutManager by lazy {
        LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

    /**
     * 显示错误信息
     */
    override fun showError(msg: String, errorCode: Int) {
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}