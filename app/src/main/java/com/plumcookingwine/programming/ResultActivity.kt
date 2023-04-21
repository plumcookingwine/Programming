package com.plumcookingwine.programming

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.plumcookingwine.programming.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityResultBinding

    companion object {
        @JvmStatic
        fun start(context: Context, amount: String, times: String) {
            context.startActivity(Intent(context, ResultActivity::class.java).also {
                it.putExtra("amount", amount)
                it.putExtra("times", times)
            })

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val mAmount = intent?.getStringExtra("amount") ?: ""
        val mTimes = intent?.getStringExtra("times") ?: ""

        ResultCache.instance.add(ResultData(mAmount, mTimes))

        val list = ResultCache.instance.getResults()

        for (resultData in list) {
            val itemView = ItemView(this)
            itemView.setData(resultData)
            itemView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            mBinding.llResult.addView(itemView)
        }
    }
}