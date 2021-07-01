package com.codingmonk21.listcomposerdemo.listcomposer

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class DelegateAdapter<T : AdapterItem, in VH : RecyclerView.ViewHolder>(
    val viewType: Class<out T>,
    val onClick: ((T, viewId: Int) -> Unit)? = null
) {
    abstract fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((T, viewId: Int) -> Unit)?
    ): RecyclerView.ViewHolder

    abstract fun onBindViewHolder(model: T, vh: VH)
}

