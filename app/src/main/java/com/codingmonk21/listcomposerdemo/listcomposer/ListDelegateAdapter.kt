package com.codingmonk21.listcomposerdemo.listcomposer

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class ListDelegateAdapter<P : AdapterItem, in PVH : RecyclerView.ViewHolder>(
    parent: Class<out P>,
    parentClick: ((P, viewId: Int) -> Unit)? = null,
    private val childClick: ((item: AdapterItem, viewId: Int) -> Unit)? = null
) : DelegateAdapter<P, PVH>(parent, parentClick) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((P, viewId: Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return onCreateListViewHolder(parent, onClick, childClick)
    }

    abstract fun onCreateListViewHolder(
        parent: ViewGroup,
        parentClick: ((P, viewId: Int) -> Unit)?,
        childClick: ((item: AdapterItem, viewId: Int) -> Unit)?,
    ): RecyclerView.ViewHolder
}