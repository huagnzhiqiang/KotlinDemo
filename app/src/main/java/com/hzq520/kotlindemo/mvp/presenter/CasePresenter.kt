package com.hzq520.kotlindemo.mvp.presenter

import android.annotation.SuppressLint
import com.hazz.kotlinmvp.base.BasePresenter
import com.hzq520.kotlindemo.mvp.Bean.HomeEntity
import com.hzq520.kotlindemo.mvp.contract.CaseContract
import com.hzq520.kotlindemo.mvp.model.CaseModel
import com.hzq520.kotlindemo.utils.JsonUtil
import com.orhanobut.logger.Logger

/**
 * @author 小强
 *
 * @time 2019/3/28  16:10
 *
 * @desc
 *
 */
class CasePresenter : BasePresenter<CaseContract.View>(), CaseContract.Presenter {

    //    val data = "{\"code\":\"200\",\"data\":{\"total\":19,\"rows\":[{\"id\":45,\"case_type\":3,\"title\":\"最佳女猪脚\",\"cover_img\":\"http://192.168.0.100:8028/files/img/20180519/201805191503088387.jpg\",\"url\":\"\",\"price\":0.01,\"head_img\":\"http://192.168.0.100:8028/files/img/20181113/201811131526351034.png\",\"user_id\":16,\"check_status\":2,\"nickname\":\"设计师姓名\",\"user_type\":1,\"create_datetime\":\"2018-05-19 15:04:37\",\"commend\":1,\"commend_datetime\":\"2018-11-26 17:47:53\",\"pre_commend_datetime\":\"2018-12-12 09:51:49\",\"commend_check_status\":0,\"show\":1,\"demand_count\":0,\"browse_count\":572229,\"description\":\"夜空中最亮的星星,你是最耀眼的,最闪亮的\",\"customer_name\":\"最佳女猪脚\",\"open_sign\":0}]},\"message\":\"查询成功\",\"remark\":\"\"}"
    val data = "{\"code\":\"200\",\"data\":{\"total\":19,\"rows\":null},\"message\":\"查询成功\",\"remark\":\"\"}"


    private val mCaseModel: CaseModel by lazy {

        CaseModel()
    }


    /**
     * 获取首页精选数据 PageCount=12, orderBy=desc, city_code=, PageIndex=1, orderByValue=create_datetime
     */
    @SuppressLint("CheckResult")
    override fun requestHomeData(index: Int, count: Int, orderBy: String, orderByValue: String) {
        checkViewAttached()
        mRootView?.showLoading()

        val sub = mCaseModel.requestHomeData(index, count, orderBy, orderByValue).subscribe({ it ->

            mRootView?.apply {

                dismissLoading()

                var bean = JsonUtil.fromJson(data, HomeEntity::class.java)
//                setHomeData(bean)
                setHomeData(it)
            }
        }, { t ->
            Logger.d("---->:" + t)
        })


        addSubscription(sub)


//        mCaseModel.requestHomeData(index, count, orderBy, orderByValue).subscribe(Consumer { t ->
//        })


//        val requestHomeData = mCaseModel.requestHomeData(index, count, orderBy, orderByValue)
//
//        val subscribe = requestHomeData.subscribe({ string ->
//            mRootView?.apply {
//                dismissLoading()
//
//                setHomeData(string)
//            }
//        }, { throwable ->
//            mRootView?.apply {
//                //处理异常
//            }
//        })
//
//        addSubscription(subscribe)
    }

    /**
     * 加载更多数据
     */
    override fun loadMoreData() {
    }
}



