package com.expedia.assignment.common.adapter.impl

import android.annotation.SuppressLint
import android.support.annotation.LayoutRes
import com.expedia.assignment.common.listener.OnItemClickListener
import com.expedia.assignment.common.listener.OnViewListener
import java.util.*


class AdapterDelegate<T>(private val typeParameterClass: Class<T>, @param:LayoutRes @field:LayoutRes
val layoutId: Int, val variableId: Int) {

    var listener: OnItemClickListener<T>? = null
    var viewListener: OnViewListener<T>? = null

    @SuppressLint("UseSparseArrays")
    val variableMap = HashMap<Int, Any>()

    fun matches(requiredType: Class<*>): Boolean {
        return requiredType == typeParameterClass
    }

    fun addVariable(variableId: Int, `object`: Any) {
        variableMap[variableId] = `object`
    }
}
