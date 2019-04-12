package com.hzq520.kotlindemo.adapter

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.hzq520.kotlindemo.R
import com.hzq520.kotlindemo.glide.GlideRoundTransform
import com.hzq520.kotlindemo.mvp.Bean.Row


/**
 * @author 小强
 *
 * @time 2019/4/11  17:59
 *
 * @desc 案例适配器
 *
 */

class CaseAdapter(data: List<Row?>?) : BaseQuickAdapter<Row, BaseViewHolder>(R.layout.item_case, data) {


    override fun convert(helper: BaseViewHolder?, item: Row?) {

        with(item ?: return) {

            helper?.setText(R.id.tv_product_title, item.title)

            var iv = helper?.getView<ImageView>(R.id.iv_product_img)

            Glide.with(mContext)
                    .load(item.cover_img)
                    .optionalTransform(GlideRoundTransform())
                    .placeholder(R.drawable.load)
                    .into(iv!!)


            val spannableString = SpannableStringBuilder()

            spannableString.append("参考价：")

            spannableString.append(" ¥ ")

            spannableString.append(item.price.toString())


            val span = ForegroundColorSpan(mContext.resources.getColor(R.color.color_eb6ea5))

            spannableString.setSpan(span, 4, spannableString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            //设置粗体
            val span1 = StyleSpan(Typeface.BOLD)
            spannableString.setSpan(span1, 6, spannableString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            //设置字体大小
            val span2 = AbsoluteSizeSpan(50)
            spannableString.setSpan(span2, 6, spannableString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            helper?.setText(R.id.tv_product_price, spannableString)
        }
    }


}