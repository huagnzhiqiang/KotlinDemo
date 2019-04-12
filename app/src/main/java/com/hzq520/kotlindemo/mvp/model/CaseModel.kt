package com.hzq520.kotlindemo.mvp.model

import com.hazz.kotlinmvp.rx.scheduler.SchedulerUtils
import com.hzq520.kotlindemo.mvp.Bean.HomeEntity
import com.hzq520.kotlindemo.net.RetrofitManager
import io.reactivex.Observable

/**
 * @author 小强
 *
 * @time 2019/3/28  16:17
 *
 * @desc
 *
 */
class CaseModel {


    /**
     * 获取首页 Banner 数据
     */
    fun requestHomeData(num: Int, PageIndex: Int, orderBy: String, orderByValue: String): Observable<HomeEntity> {
        return RetrofitManager.service.requestDemandcaseData(num, PageIndex, orderBy, orderByValue)
                .compose(SchedulerUtils.ioToMain())
    }
}