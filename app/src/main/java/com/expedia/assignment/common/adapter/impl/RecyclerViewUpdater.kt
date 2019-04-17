package com.expedia.assignment.common.adapter.impl

import android.support.v7.widget.RecyclerView

class RecyclerViewUpdater(private val adapter: RecyclerView.Adapter<*>) : Runnable {
    override fun run() {
        adapter.notifyDataSetChanged()
    }
}
