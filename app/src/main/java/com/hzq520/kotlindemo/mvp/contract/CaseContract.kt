package com.hzq520.kotlindemo.mvp.contract

import com.hazz.kotlinmvp.base.IBaseView
import com.hazz.kotlinmvp.base.IPresenter
import com.hzq520.kotlindemo.mvp.Bean.HomeEntity

/**
 * Created by xuhao on 2017/11/8.
 * 契约类
 */

interface CaseContract {

    interface View : IBaseView {

        /**
         * 设置第一次请求的数据
         */
        fun setHomeData(homeBean: HomeEntity)

        /**
         * 设置加载更多的数据
         */
//        fun setMoreData(itemList:ArrayList<HomeBean.Issue.Item>)

        /**
         * 显示错误信息
         */
        fun showError(msg: String, errorCode: Int)


    }

    interface Presenter : IPresenter<View> {

        /**
         * 获取首页精选数据 PageCount=12, orderBy=desc, city_code=, PageIndex=1, orderByValue=create_datetime
         */
        fun requestHomeData(num: Int, pageindex: Int,orderBy:String,orderByValue:String)

        /**
         * 加载更多数据
         */
        fun loadMoreData()



    }


}