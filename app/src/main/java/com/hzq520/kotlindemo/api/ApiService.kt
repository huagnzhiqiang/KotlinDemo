package com.hzq520.kotlindemo.api

import com.hzq520.kotlindemo.mvp.Bean.HomeEntity
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by xuhao on 2017/11/16.
 * Api 接口
 */

interface ApiService {


    //获取案例分页
    @FormUrlEncoded
    @POST("api/demandcase/getpagelist")
    fun requestDemandcaseData(@Field("PageIndex") pageIndex: Int, @Field("PageCount") count: Int, @Field("orderBy") orderBy: String, @Field("orderByValue") orderByValue: String): Observable<HomeEntity>
}