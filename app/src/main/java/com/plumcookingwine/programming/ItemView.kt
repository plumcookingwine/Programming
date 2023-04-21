package com.plumcookingwine.programming

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.plumcookingwine.programming.databinding.ItemBinding

class ItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    var mBinding: ItemBinding

    init {
        mBinding = ItemBinding.inflate(LayoutInflater.from(context), null, false)
        addView(mBinding.root)
    }

    fun setData(data: ResultData) {
        mBinding.tvAmount.text = "Amount: ${data.amount}"
        mBinding.tvTime.text = "Times: ${data.times}"
    }
}