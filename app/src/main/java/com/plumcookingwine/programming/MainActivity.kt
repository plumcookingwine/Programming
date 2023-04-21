package com.plumcookingwine.programming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import com.plumcookingwine.programming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mainViewModel.amountLiveData.observe(this) {
            mBinding.tvAmount.text = "Amount: $it"
        }

        mainViewModel.timesLiveData.observe(this) {
            mBinding.tvTime.text = "Times: $it"
        }

        mBinding.etAmount.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mainViewModel.inputAmount(s?.toString() ?: "")
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        mBinding.etTime.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mainViewModel.inputTimes(s?.toString() ?: "")
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        mBinding.btnSubmit.setOnClickListener {
            ResultActivity.start(
                this,
                mBinding.tvAmount.text?.toString() ?: "",
                mBinding.tvTime.text?.toString() ?: ""
            )
        }
    }
}