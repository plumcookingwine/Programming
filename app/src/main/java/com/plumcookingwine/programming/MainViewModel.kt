package com.plumcookingwine.programming

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class MainViewModel : ViewModel() {

    val amountLiveData = MutableLiveData<String>()
    val timesLiveData = MutableLiveData<String>()

    // val resultLiveData =

    fun inputAmount(amount: String?) {
//        val decimalFormat = DecimalFormat(",###")
//        val res = decimalFormat.format(amount.toDouble())
        if (amount.isNullOrEmpty()) {
            amountLiveData.value = ""
            return
        }
        val amountArr = amount.split(".")
        val amountBefore = amountArr[0]
        val amountAfter = if (amountArr.size > 1) ".${amountArr[1]}" else ""

        var prePos = amountBefore.length % 3
        val builder = StringBuilder()


        for (i in amountBefore.length - 1 downTo 0) {
            val c = amountBefore[i]
            builder.append(c)
            if ((amountBefore.length - i) % 3 == 0) {
                if (i == 0) { // 防止在开头添加
                    continue
                }
                builder.append(",")
            }
        }
        builder.reverse().append(amountAfter)
        amountLiveData.value = builder.toString()
    }

    fun inputTimes(times: String) {
        val s = times.toLongOrNull() ?: 0L

        val baseHour = 60 * 60
        val baseDay = baseHour * 24

        val days = s / baseDay
        val hours = (s % baseDay) / baseHour
        val minutes = (s % baseHour) / 60
        val seconds = s % 60

        val preDay = if (days > 0) "${days}day" else ""
        val preHours = if (hours > 0) "${hours}h" else ""
        val preMinutes = if (minutes > 0) "${minutes}m" else ""
        timesLiveData.value = "${preDay}${preHours}${preMinutes}${seconds}s"
    }
}