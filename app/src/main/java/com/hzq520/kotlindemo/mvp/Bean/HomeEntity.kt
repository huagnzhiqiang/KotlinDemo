package com.hzq520.kotlindemo.mvp.Bean

/**
 * @author 小强
 *
 * @time 2019/4/10  15:08
 *
 * @desc {"code":"200","data":{"total":19,"rows":[{"id":45,"case_type":3,"title":"最佳女猪脚","cover_img":"http://192.168.0.100:8028/files/img/20180519/201805191503088387.jpg","url":"","price":0.01,"head_img":"http://192.168.0.100:8028/files/img/20181113/201811131526351034.png","user_id":16,"check_status":2,"nickname":"设计师姓名","user_type":1,"create_datetime":"2018-05-19 15:04:37","commend":1,"commend_datetime":"2018-11-26 17:47:53","pre_commend_datetime":"2018-12-12 09:51:49","commend_check_status":0,"show":1,"demand_count":0,"browse_count":572229,"description":"夜空中最亮的星星,你是最耀眼的,最闪亮的","customer_name":"最佳女猪脚","open_sign":0}]},"message":"查询成功","remark":""}
 *
 */
data class HomeEntity(
        var code: String?, // 200
        var `data`: Data?,
        var message: String?, // 查询成功
        var remark: String?
)

data class Data(
        var rows: List<Row?>?,
        var total: Int? // 19
)

data class Row(
        var browse_count: Int?, // 572229
        var case_type: Int?, // 3
        var check_status: Int?, // 2
        var commend: Int?, // 1
        var commend_check_status: Int?, // 0
        var commend_datetime: String?, // 2018-11-26 17:47:53
        var cover_img: String?, // http://192.168.0.100:8028/files/img/20180519/201805191503088387.jpg
        var create_datetime: String?, // 2018-05-19 15:04:37
        var customer_name: String?, // 最佳女猪脚
        var demand_count: Int?, // 0
        var description: String?, // 夜空中最亮的星星,你是最耀眼的,最闪亮的
        var head_img: String?, // http://192.168.0.100:8028/files/img/20181113/201811131526351034.png
        var id: Int?, // 45
        var nickname: String?, // 设计师姓名
        var open_sign: Int?, // 0
        var pre_commend_datetime: String?, // 2018-12-12 09:51:49
        var price: Double?, // 0.01
        var show: Int?, // 1
        var title: String?, // 最佳女猪脚
        var url: String?,
        var user_id: Int?, // 16
        var user_type: Int? // 1
)