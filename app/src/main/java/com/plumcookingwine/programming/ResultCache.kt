package com.plumcookingwine.programming

class ResultCache private constructor() {

    companion object {

        val instance by lazy { ResultCache() }
    }

    private val mResultList = arrayListOf<ResultData>()

    fun add(cache: ResultData) {
        mResultList.add(cache)
    }

    fun getResults() = mResultList
}